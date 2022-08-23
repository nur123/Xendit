package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QRCodeData{

	public QRCodeData() {
	}

	public QRCodeData(String callbackUrl, Integer amount, String description) {
		this.callbackUrl = callbackUrl;
		this.amount = amount;
		this.description = description;
	}

	@JsonProperty("callback_url")
	private String callbackUrl;

	@JsonProperty("amount")
	private Integer amount;

	@JsonProperty("description")
	private String description;

	public void setCallbackUrl(String callbackUrl){
		this.callbackUrl = callbackUrl;
	}

	public String getCallbackUrl(){
		return callbackUrl;
	}

	public void setAmount(Integer amount){
		this.amount = amount;
	}

	public Integer getAmount(){
		return amount;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}
}