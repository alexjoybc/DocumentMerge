package ca.bc.gov.open.pssg.pdfmerge.utils;

import java.io.ByteArrayOutputStream;
import java.io.StringWriter;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ca.bc.gov.open.pssg.pdfmerge.model.MergePage;



/**
 * A set of DDX utils. 
 * 
 * @author 176899
 *
 */
public class DDXUtils {

	/**
	 * Creates a Merge DDX document for Assembler using an org.w3c.dom.Document object
	 * 
	 * @return
	 */
	public static Document createMergeDDX(LinkedList<MergePage> pageList) {

		Document document = null;
		try {
			
			// Create DocumentBuilderFactory and DocumentBuilder objects
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			// Create a new Document object
			document = builder.newDocument();
			
			// Create the root element and append it to the XML DOM
			Element root = (Element) document.createElement("DDX");
			//root.setAttribute("xmlns", "https://ns.adobe.com/DDX/1.0/");
			root.setAttribute("xmlns", "http://ns.adobe.com/DDX/1.0/");
			document.appendChild(root);
			
			// Create the PDFsFromBookmarks element
			Element PDFs = (Element) document.createElement("PDF");
			PDFs.setAttribute("result", "out.pdf");
			root.appendChild(PDFs);
			
			// Add each pageId element to the DDX
			for (int i = 0; i < pageList.size(); i++) {
				Element PDF = (Element) document.createElement("PDF");
				PDF.setAttribute("source", pageList.get(i).getId());
				PDFs.appendChild(PDF);
			}
			
		} catch (Exception e) {
			System.out.println("The following exception occurred when creating the mergeDDX: " + e.getMessage());
		}

		return document;
	}
	
//	/**
//	 * 
//	 * @param ddx
//	 * @return
//	 */
//	public static com.adobe.idp.Document convertDDX(Document ddx) {
//		
//		byte[] mybytes = null;
//		
//		try {
//			// Create a Java Transformer object
//			TransformerFactory transFact = TransformerFactory.newInstance();
//			Transformer transForm = transFact.newTransformer();
//			
//			// Create a Java ByteArrayOutputStream object
//			ByteArrayOutputStream myOutStream = new ByteArrayOutputStream();
//			
//			// Create a Java Source object
//			javax.xml.transform.dom.DOMSource myInput = new DOMSource(ddx);
//			
//			// Create a Java Result object
//			javax.xml.transform.stream.StreamResult myOutput = new StreamResult(myOutStream);
//			
//			// Populate the Java ByteArrayOutputStream object
//			transForm.transform(myInput, myOutput);
//			
//			// Get the size of the ByteArrayOutputStream buffer
//			int myByteSize = myOutStream.size();
//			
//			// Allocate myByteSize to the byte array
//			mybytes = new byte[myByteSize];
//			
//			// Copy the content to the byte array
//			mybytes = myOutStream.toByteArray();
//			
//		} catch (Exception e) {
//			System.out.println("The following exception occurred: " + e.getMessage());
//		}
//		
//		// Create a com.adobe.idp.Document object and copy the
//		// contents of the byte array
//		com.adobe.idp.Document myDocument = new com.adobe.idp.Document(mybytes);
//		return myDocument;
//
//	}
	
	/**
	 * 
	 * @param ddx
	 * @return
	 * @throws TransformerException
	 */
	public static String DDXDocumentToString(Document ddx) throws TransformerException {
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(ddx);
        StreamResult result = new StreamResult(new StringWriter());
        transformer.transform(source, result);

        return result.getWriter().toString();
	}
	
}
