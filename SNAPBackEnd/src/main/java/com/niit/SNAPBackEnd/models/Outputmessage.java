package com.niit.SNAPBackEnd.models;

import java.util.Date;

public class Outputmessage extends Message {
	
	private Date time;

	public Outputmessage(Message original, Date time) {
		
		super(original.getId(), original.getMessage(),original.getEmail());
		this.time = time;
		
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}


}
