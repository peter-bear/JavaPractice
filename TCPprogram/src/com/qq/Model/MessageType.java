package com.qq.Model;

public interface MessageType {
	
	/**在接口中定义了一些常量，不同常量的值表示不同的消息类型*/
	String MESSAGE_LOGIN_SUCCEED ="1"; //表示登录成功
	String MESSAGE_LOGIN_FAIL ="2"; //表示登录失败
	String MESSAGE_COMM_MES = "3";//表示普通数据包
	String MESSAGE_GET_ONLINE_FRIENDS ="4";//要求返回在线用户列表
	String MESSAGE_ONLINE_FRIENDS ="5";//返回是在线的用户列表
	String MESSAGE_TO_ALL="6"; //群发消息
	String MESSAGE_FILE ="7"; //发送的是文件
	String MESSAGE_CLIENT_EXIT ="9"; //表示客户端退出
}
