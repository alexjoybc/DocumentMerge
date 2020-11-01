package ca.bc.gov.open.pssg.pdfmerge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ca.bc.gov.open.pssg.pdfmerge")
public class DocumentMergeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentMergeServiceApplication.class, args);
	}

}
