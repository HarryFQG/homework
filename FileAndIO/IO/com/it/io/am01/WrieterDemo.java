package com.it.io.am01;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * 	�ַ������
 * 			java.io.writer �����ַ�������ĸ���
 * 		�����ԣ�ֻ��д�ı��ļ�������дͼƬ�����֣���Ƶ
 * @author Administrator
 *		д��������
 *			write(int c):дһ���ַ�
 *			write(char[] c):д�ַ�����
 *			write(char[] c��int len)��д�ַ�����,��ʼ������
 *			write(String str )��д�ַ�����
 *	Writer ����������	FileWriter
 *		File�����
 *		String �ļ���
 *
 *		ע�⣺�ַ������д����ʱ����ʹ��ˢ�¹���.�����ǣ�дһ��ˢ��һ��
 */
public class WrieterDemo {

	@Test
	public void write0() throws IOException{
		
		FileWriter fw=new FileWriter("e:\\tomcat\\fileobject\\hellow.txt");
		//д�ķ�����
		fw.write(100);
		fw.append("\nappend1");
		fw.flush();
		
		/*дһ��char����*/
		char[] c={'A','B','C','X'};
		fw.write(c);
		fw.flush();
		
		/*д�����һ����*/
		fw.write(c, 1, 2);		
		fw.flush();
		
		/*д���ַ���*/
		fw.write(new String (c));
		fw.flush();
	
		fw.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
