package com.crgt.innov2015.model;

/**
 * Class which holds data point comparison for three Cloud Service Providers
 * AWS, Cloud Foundry, Azure
 * @author mvattipulusu
 *
 */
public class CSPVO {
	
	
	private String type;
	private String awsValue;
	private String cfValue;
	private String azureValue;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAwsValue() {
		return awsValue;
	}
	public void setAwsValue(String awsValue) {
		this.awsValue = awsValue;
	}
	public String getCfValue() {
		return cfValue;
	}
	public void setCfValue(String cfValue) {
		this.cfValue = cfValue;
	}
	public String getAzureValue() {
		return azureValue;
	}
	public void setAzureValue(String azureValue) {
		this.azureValue = azureValue;
	}
	


	/*private CSPCharacteristic cspCharacteristic;
	private CloudServiceProvider cloudServiceProvider;
	public CSPCharacteristic getCspCharacteristic() {
		return cspCharacteristic;
	}
	public void setCspCharacteristic(CSPCharacteristic cspCharacteristic) {
		this.cspCharacteristic = cspCharacteristic;
	}
	public CloudServiceProvider getCloudServiceProvider() {
		return cloudServiceProvider;
	}
	public void setCloudServiceProvider(CloudServiceProvider cloudServiceProvider) {
		this.cloudServiceProvider = cloudServiceProvider;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CSPVO [cspCharacteristic=");
		builder.append(cspCharacteristic);
		builder.append(", cloudServiceProvider=");
		builder.append(cloudServiceProvider);
		builder.append("]");
		return builder.toString();
	}*/
	
	
	
	
}
