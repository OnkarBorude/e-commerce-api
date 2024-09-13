package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

@Component
public class DeleteUserResponse {
	
	private String responseCode;
	private String messege;
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
	
		
}
