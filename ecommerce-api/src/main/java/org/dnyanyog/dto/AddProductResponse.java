package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class AddProductResponse {
	private String responseCode;
	private String messege;
	private AddProductRequest addProductRequest;
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
	public AddProductRequest getAddProductRequest() {
		return addProductRequest;
	}
	public void setAddProductRequest(AddProductRequest addProductRequest) {
		this.addProductRequest = addProductRequest;
	}
	
	

}
