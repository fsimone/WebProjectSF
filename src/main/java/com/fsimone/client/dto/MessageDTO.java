package com.fsimone.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDTO {
	
	private Integer id;
	private String message;
	
	public MessageDTO() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@JsonProperty("description")
	public String getMessage() {
		return message;
	}
	
	@JsonProperty("description")
	public void setMessage(String message) {
		this.message = message;
	}
	

}
