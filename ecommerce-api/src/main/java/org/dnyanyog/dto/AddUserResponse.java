package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class AddUserResponse {
	private String responseCode;
	private String messege;
	private AddUserRequest addUserRequest;
	private Integer user_id;
	
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
	public AddUserRequest getAddUserRequest() {
		return addUserRequest;
	}
	public void setAddUserRequest(AddUserRequest addUserRequest) {
		this.addUserRequest = addUserRequest;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	

}
