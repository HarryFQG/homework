package com.it.a;

import java.io.File;

import org.junit.Test;

/**
 * File����жϹ���
 * @author Administrator
 *
 */
public class FileDemo05Exists {

	/**
	 * File�жϹ���
	 * boolean exists();
	 * �ж�File���췽���з�װ��·���Ƿ����
	 * ���ڷ���True,�����ڷ���false
	 */
	@Test
	public void getExists(){
		
		File file=new File("e:\\tomcat\\fileobject\\a727.doc");
		boolean flag = file.exists();
		System.out.println("�ļ����Ƿ���ڣ�"+flag);
		
	}
	
	/*
	 * File�жϹ���
	 * boolean isDirectory();
	 * �ж�File���������Ƿ񴫵����ļ���
	 * ���ڷ���True,�����ڷ���false
	 */
	@Test
	public void getIsDirectory(){
		File file=new File("e:\\tomcat\\fileobject\\a727.doc");
		boolean flag = file.isDirectory();
		
		File file1=new File("e:\\tomcat\\fileobject\\");
		boolean flag1 = file1.isDirectory();
		System.out.println("�ǲ����ļ��У�"+flag+"\t,flag1:"+flag1);
	}
	
	/*
	 * File�жϹ���
	 * boolean isFile();
	 * �ж�File���������Ƿ񴫵ݵ����ļ�
	 * ���ڷ���True,�����ڷ���false
	 */
	@Test
	public void getIsFile(){
		File file=new File("e:\\tomcat\\fileobject\\a727.doc");
		boolean flag = file.isDirectory();
		
		File file1=new File("e:\\tomcat\\fileobject\\");
		boolean flag1 = file1.isDirectory();
		System.out.println("�ǲ����ļ���"+flag+"\t,flag1:"+flag1);
	}
	
	
	
}
