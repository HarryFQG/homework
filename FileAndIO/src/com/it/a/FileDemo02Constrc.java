package com.it.a;

import java.io.File;

/**
 * File��Ĺ��췽��
 * �������صķ�ʽ
 * @author Feng
 *�������ͨ��exists()�����ж��ļ�������·���Ƿ���ڡ�
 */


public class FileDemo02Constrc {

	
	
	public static void main(String[] args) {
		constrator1();
		System.out.println("������2��File(String parent, String child) ");
		construction2();
		System.out.println("������3��File(File parent, String child) ");
		construction3();
	}	
	
	/*
	 * ���췽��1��
	 * File(String pathName);
	 * ����·����������д���ļ��У�����д��һ���ļ�
	 * c:\\abc 	c:\\abc\Demo.java
	 * ��·����װFile���Ͷ���
	 */
	private static void constrator1() {
		File file=new File("e:\\Tomcat\\Tomcat.txt");
		System.out.println(file);
		boolean flag=file.exists();
		System.out.println(flag);
	}
	
	
	/**
	 * ���췽����
	 * File(String parent, String child) 
	 * ���ݵ����ַ�����·�������ַ�����·��
	 * ����Ը���
	 */
	private static void construction2(){
		File file=new File("e:","Tomcat");
		System.out.println(file+"\t,flag"+file.exists());
		
	}
	
	/**
	 * ���췽����
	 * File(File parent, String child) 
	 * ���ݵ���File���͵ĸ�·�������ַ�����·��
	 * �ô�����·����File���ͣ���·������ֱ�ӵ���File��ķ���
	 */
	private static void construction3(){
		File parent=new File("e:");
		File file1=new File(parent,"Tomcat");
		System.out.println(file1+"\t,flag"+file1.exists());
		
	}
	
	
	
	
}
