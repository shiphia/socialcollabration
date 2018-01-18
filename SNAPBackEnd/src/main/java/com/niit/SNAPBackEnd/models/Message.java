package com.niit.SNAPBackEnd.models;

public class Message {
	private String message;
	private String email;
	private int id;

	public Message() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Message(int id, String message,String email) {
		this.id = id;
		this.message = message;
		this.email=email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
