package com.qq.Model;

import java.io.Serializable;

public class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	private String sender; //发送者
	private String getter; //接收者
	private String content; //内容
	private String sendTime; //发送时间
	private byte[] file; // 字节数组
	private String mesType; //消息类型
	
	
	
	public String getMesType() {
		return mesType;
	}
	public void setMesType(String mesType) {
		this.mesType = mesType;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getGetter() {
		return getter;
	}
	public void setGetter(String getter) {
		this.getter = getter;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	
}
