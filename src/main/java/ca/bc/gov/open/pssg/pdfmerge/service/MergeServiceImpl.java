package ca.bc.gov.open.pssg.pdfmerge.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ca.bc.gov.open.pssg.pdfmerge.model.PDFMergeRequest;
import ca.bc.gov.open.pssg.pdfmerge.model.PDFMergeResponse;

/**
 * 
 * @author shaunmillargov
 *
 */
@Service
public class MergeServiceImpl implements MergeService {
	
	private final Logger logger = LoggerFactory.getLogger(MergeServiceImpl.class);

	@Override
	public PDFMergeResponse mergeDocuments(PDFMergeRequest request, String correlationId) {
		
		
try {
			
			// Set connection properties required to invoke AEM Forms using SOAP mode
			// These will be fetched either from OpenShift Secrets or Java properties file depending on the hosting environment. 
			Properties connectionProps = new Properties();
			connectionProps.setProperty(ServiceClientFactoryProperties.DSC_DEFAULT_SOAP_ENDPOINT, "http://sarcee.bcgov:8080");
			connectionProps.setProperty(ServiceClientFactoryProperties.DSC_TRANSPORT_PROTOCOL, ServiceClientFactoryProperties.DSC_SOAP_PROTOCOL);
			connectionProps.setProperty(ServiceClientFactoryProperties.DSC_SERVER_TYPE, "JBoss");
			connectionProps.setProperty(ServiceClientFactoryProperties.DSC_CREDENTIAL_USERNAME, "einfo");
			connectionProps.setProperty(ServiceClientFactoryProperties.DSC_CREDENTIAL_PASSWORD, "einfo999");

			// Create a ServiceClientFactory instance
			ServiceClientFactory myFactory = ServiceClientFactory.createInstance(connectionProps);

			// Create an AssemblerServiceClient object
			AssemblerServiceClient assemblerClient = new AssemblerServiceClient(myFactory);
			
			// Create 2 page objects. 
			MergePage mp1 = new MergePage(FileUtils.readFileToByteArray(new File("C:\\Users\\176899\\workspaces\\neon\\pdfmerge\\AEMMergeTest\\files\\RecordOfProceedings_1.5_pdfa.pdf")));
			MergePage mp2 = new MergePage(FileUtils.readFileToByteArray(new File("C:\\Users\\176899\\workspaces\\neon\\pdfmerge\\AEMMergeTest\\files\\ReleaseOrder_1.5_pdfa.pdf")));
			
			// Java LinkedList serves to maintain incoming order of PDFs
			LinkedList<MergePage> pageList=new LinkedList<MergePage>();
			pageList.add(mp1);
		    pageList.add(mp2);
			
			// Using new DDXUtils to Dynamically generate the DDX file. 
			org.w3c.dom.Document aDDx = DDXUtils.createMergeDDX(pageList);
			System.out.println(DDXUtils.DDXDocumentToString(aDDx));
			Document myDDX = DDXUtils.convertDDX(aDDx);

			// Create a Map object to store PDF source documents
			Map<String, Object> inputs = new HashMap<String, Object>();
			
			Iterator<MergePage> it = pageList.iterator();
		    while(it.hasNext()) {
		      MergePage pageElement = (MergePage)it.next();
			  Document pageDocument = new Document(pageElement.getFile());
			  inputs.put(pageElement.getId(), (Object)pageDocument);
		    }

			// Create an AssemblerOptionsSpec object
			AssemblerOptionSpec assemblerSpec = new AssemblerOptionSpec();
			assemblerSpec.setFailOnError(false);

			// Submit the job to Assembler service
			AssemblerResult jobResult = assemblerClient.invokeDDX(myDDX, inputs, assemblerSpec);
			java.util.Map allDocs = jobResult.getDocuments();

			// Retrieve the result PDF document from the Map object
			Document outDoc = null;

			// Iterate through the map object to retrieve the result PDF document
			for (Iterator i = allDocs.entrySet().iterator(); i.hasNext();) {
				// Retrieve the Map object’s value
				Map.Entry e = (Map.Entry) i.next();

				// Get the key name as specified in the
				// DDX document
				String keyName = (String) e.getKey();
				if (keyName.equalsIgnoreCase("out.pdf")) {
					Object o = e.getValue();
					outDoc = (Document) o;

					// Save the result PDF file
					File myOutFile = new File("C:\\Users\\176899\\workspaces\\neon\\pdfmerge\\AEMMergeTest\\output\\out.pdf");
					outDoc.copyToFile(myOutFile);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
}




