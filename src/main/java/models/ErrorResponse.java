package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse{

	@JsonProperty("errorCode")
	private String errorCode;

	@JsonProperty("description")
	private String description;

	public void setErrorCode(String errorCode){
		this.errorCode = errorCode;
	}

	public String getErrorCode(){
		return errorCode;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}
}