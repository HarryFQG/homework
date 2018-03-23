package com.it.a;

import java.io.File;

import org.junit.Test;

/**
 * File��Ļ�ȡ����
 * @author Feng
 */
public class FileDemo04Get {
	
	/**
	 * File��Ļ�ȡ����
	 * String getName(); 
	 * ����·���б�ʾ���ļ������ļ�����
	 * ��ȡ����·�����������֣�������Ƿ���ڡ�
	 */
	@Test
	public void getFile(){
		File file=new File("e:\\tomcat\\fileobject\\a727.doc");//��ȡ׼ȷ���ļ�
		File file1=new File("e:\\tomcat\\fileobject\\");//��ȡ׼ȷ���ļ���
		String str1=file.getName();
		String str2=file1.getName();
		String str3=file.getPath();
		System.out.println("�ļ�·��:"+str1+"\t�ļ���·����"+str2+"\tpath:"+str3);
	}

	/**
	 * File���͵Ļ�ȡ����
	 * long length()
	 * ����·���б�ʾ���ļ����ֽ���
	 * ֻ�ܻ�õ����ļ��Ĵ�С�����ܻ���ļ��еĴ�С��
	 */
	@Test
	public void getFileLength(){
		File file=new File("e:\\tomcat\\fileobject\\a727.doc");
		long len = file.length();
		System.out.println("�ļ���С��"+len/1024+"Kb");
		
	}
	/**
	 * File���͵Ļ�ȡ����
	 * String getAbsolutePath();
	 * File getAbsoluteFile() ���ص���File����
	 * ��ȡ����·��:
	 * eclipse�����У�д����һ�����·������þ���λ���ǹ���Ŀ¼
	 */
	@Test
	public void getAbsoluteFile(){
		File file=new File(" ");
		File file1 = file.getAbsoluteFile();
		String parent = file1.getParent();
		File f=new File(parent);
		System.out.println(f);
	}
	
	/**
	 * File��Ļ�ȡ����
	 * String getParent() ���ص���String���͵Ķ���
	 * File  getAbsoluteFile() ���ص���File���͵Ķ���(�Ƽ�ʹ�����)
	 */
	//��ȡ��·��
	@Test
	public void getParent(){
		File file=new File("e:\\tomcat\\fileobject\\a727.doc");
		File parent=file.getParentFile();
		System.out.println("��·����"+parent.getPath());
	} 
	
	
	
}
