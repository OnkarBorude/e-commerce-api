package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

@Component
public class UpdateUserResponse {
	
	private String responseCode;
	private String messege;
	private UpdateUserRequest updateUserRequest;
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
	public UpdateUserRequest getUpdateUserRequest() {
		return updateUserRequest;
	}
	public void setUpdateUserRequest(UpdateUserRequest updateUserRequest) {
		this.updateUserRequest = updateUserRequest;
	}
	
	

}
