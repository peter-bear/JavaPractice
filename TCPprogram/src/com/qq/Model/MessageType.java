package com.qq.Model;

public interface MessageType {
	
	/**�ڽӿ��ж�����һЩ��������ͬ������ֵ��ʾ��ͬ����Ϣ����*/
	String MESSAGE_LOGIN_SUCCEED ="1"; //��ʾ��¼�ɹ�
	String MESSAGE_LOGIN_FAIL ="2"; //��ʾ��¼ʧ��
	String MESSAGE_COMM_MES = "3";//��ʾ��ͨ���ݰ�
	String MESSAGE_GET_ONLINE_FRIENDS ="4";//Ҫ�󷵻������û��б�
	String MESSAGE_ONLINE_FRIENDS ="5";//���������ߵ��û��б�
	String MESSAGE_TO_ALL="6"; //Ⱥ����Ϣ
	String MESSAGE_FILE ="7"; //���͵����ļ�
	String MESSAGE_CLIENT_EXIT ="9"; //��ʾ�ͻ����˳�
}
