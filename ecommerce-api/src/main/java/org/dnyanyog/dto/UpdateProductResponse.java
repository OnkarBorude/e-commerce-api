package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class UpdateProductResponse {
	
	private String responseCode;
	private String messege;
	private UpdateProductRequest updateProductRequest;
	
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getMessege() {
		return messege;
	}
	public void setMessege(String messege) {
		this.messege = messege;
	}
	public UpdateProductRequest getUpdateProductRequest() {
		return updateProductRequest;
	}
	public void setUpdateProductRequest(UpdateProductRequest updateProductRequest) {
		this.updateProductRequest = updateProductRequest;
	}
	

}
