package ca.bc.gov.open.pssg.pdfmerge.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 
 * Externalize configuration for easy access to properties either as OpenShift Secrets or local Env variables. 
 * 
 * @author shaunmillargov
 *
 */
@ConfigurationProperties(prefix = "pdfmerge")
public class ConfigProperties {

	private String serviceApiVersion; 
	private boolean serviceSwaggerEnabled;
	private String aemServiceEndpoint; 
	private String aemServiceUser;
	private String aemServicePassword;
	
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

	public String getAemServiceEndpoint() {
		return aemServiceEndpoint;
	}

	public void setAemServiceEndpoint(String aemServiceEndpoint) {
		this.aemServiceEndpoint = aemServiceEndpoint;
	}

	public String getAemServiceUser() {
		return aemServiceUser;
	}

	public void setAemServiceUser(String aemServiceUser) {
		this.aemServiceUser = aemServiceUser;
	}

	public String getAemServicePassword() {
		return aemServicePassword;
	}

	public void setAemServicePassword(String aemServicePassword) {
		this.aemServicePassword = aemServicePassword;
	}
	
}
