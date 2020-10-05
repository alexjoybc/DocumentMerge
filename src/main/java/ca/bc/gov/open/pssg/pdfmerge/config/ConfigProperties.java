package ca.bc.gov.open.pssg.pdfmerge.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 
 * Externalized configuration for easy access to properties
 * 
 * @author shaunmillargov
 *
 */
@ConfigurationProperties(prefix = "pdfmerge")
public class ConfigProperties {

	private String serviceApiVersion; 
	private boolean serviceSwaggerEnabled;
	
	public String getServiceApiVersion() {
		return serviceApiVersion;
	}

	public void setServiceApiVersion(String serviceApiVersion) {
		this.serviceApiVersion = serviceApiVersion;
	}

	public boolean isServiceSwaggerEnabled() {
		return serviceSwaggerEnabled;
	}

	public void setServiceSwaggerEnabled(boolean serviceSwaggerEnabled) {
		this.serviceSwaggerEnabled = serviceSwaggerEnabled;
	}
	
}
