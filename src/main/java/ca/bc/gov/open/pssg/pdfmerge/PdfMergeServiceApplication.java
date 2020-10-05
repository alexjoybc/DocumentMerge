package ca.bc.gov.open.pssg.pdfmerge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ca.bc.gov.open.pssg.pdfmerge")
public class PdfMergeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdfMergeServiceApplication.class, args);
	}

}
