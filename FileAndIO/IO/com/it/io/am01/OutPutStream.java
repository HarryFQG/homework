package com.it.io.am01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.Test;

/**
 * �ֽ������
 * 		java.io.OutputStream		�����ֽ�������ĸ���
 * 		���ã���Java��������д����
 * 		�ֽ�: ÿ��ֻ����дһ���ֽ�(8λ�����Ƶ�����)������
 * 		д�������ļ�
 * 		������
 * 		write(int b);д��һ���ֽ�
 * 		write(byte[] b):д���ֽ�����
 * 		write(byte[] b,int off,int len):д���ֽ����飬��ʼд���������lenд����
 * 		close():�ر��������ͷ�������ص���Դ
 * 		
 * 		
 * 		���������ɲ���ϵͳ��Դͳһ����
 * 		
 * @author Administrator
 *
 */
public class OutPutStream {

	/**
	 * FileOutputStream:�ļ�����д�ͻ�������
	 * ��д��FileOutputStream�Ĺ��췽���У��ڶ�����������true���ɡ�
	 * 		���ļ���д�뻻�У�����\r\n,\r\n����д����һ�е�ĩβ��������һ�еĿ�ͷ
	 * @throws FileNotFoundException 
	 */	
	@Test
	public void fileOutputStream() throws Exception{
		File file=new File("e:\\tomcat\\fileobject\\hellow.txt");
		FileOutputStream fos=new FileOutputStream(file,true);//������ĩβ����׷�ӣ������д����false,�ͻḲ��
		fos.write(",Hellow\r\n".getBytes());
		fos.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
