package com.fsimone.hibernate.controller;

import javax.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;


@XmlRootElement
public class Stringx {
	
	private String log;
	private int id;
	
	public Stringx() {
	}
	
	public Stringx(String param) {
		this.log = param;
	}
	
	@XmlElement
	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}
	
	public int getId() {
		return id;
	}

	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}


}
