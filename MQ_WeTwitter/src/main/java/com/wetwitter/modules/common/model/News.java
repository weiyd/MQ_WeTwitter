package com.wetwitter.modules.common.model;

public class News 
{
	private int id;
	
	private String sender_id;
	
	private String receiver_id;
	
	private String sender_name;
	
	private String receiver_name;
	
	private String sender_note;
	
	private String receiver_note;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSender_id() {
		return sender_id;
	}

	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}

	public String getReceiver_id() {
		return receiver_id;
	}

	public void setReceiver_id(String receiver_id) {
		this.receiver_id = receiver_id;
	}

	public String getSender_name() {
		return sender_name;
	}

	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}

	public String getReceiver_name() {
		return receiver_name;
	}

	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}

	public String getSender_note() {
		return sender_note;
	}

	public void setSender_note(String sender_note) {
		this.sender_note = sender_note;
	}

	public String getReceiver_note() {
		return receiver_note;
	}

	public void setReceiver_note(String receiver_note) {
		this.receiver_note = receiver_note;
	}

}
