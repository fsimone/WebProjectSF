package com.fsimone.client.dto;

import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class JacksonClassDTO {
	
	List<MessageDTO> listMessage;
	
	
	@JsonCreator
	private JacksonClassDTO(List<MessageDTO> listMessage){
		this.listMessage = listMessage;
	}
	
	public List<MessageDTO> getListMessage() {
		return listMessage;
	}

	public void setListMessage(List<MessageDTO> listMessage) {
		this.listMessage = listMessage;
	}
	
	@Override
	@JsonIgnore
	public String toString() {
		StringBuilder  result = new StringBuilder ();
		result.append("Server LOG: * ");
		for (Iterator<MessageDTO> iterator = listMessage.iterator(); iterator.hasNext();) {
			MessageDTO messageDTO = (MessageDTO) iterator.next();
			result.append(messageDTO.getMessage()).append(" - ");
		}
		return result.toString().substring(0, result.length()-2).concat("*");
		
	}

	
	

}
