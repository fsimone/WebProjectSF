package com.fsimone.hibernate.controller;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Stringx {
	
	private String log;
	
	public Stringx(String param) {
		this.log = param;
	}
	
	
	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}


}
