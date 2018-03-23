package com.it.io.bm01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

/**
 * ת����
 * 		java.io.OutputStreamWriter�̳�Writer��
 * 		����һ���ַ��������ֻд�ı�
 * 		write()�ַ������ַ����飬�ַ���
 * 		
 * 		OutputStreamWriterʹ�÷�����
 * 			���캯����
 * 					1.OutputStreamWriter(OutputStream out):�������е��ֽ������
 * 						���ǣ��ֽ��������FileOutputStream
 * 		
 * 					2.OutputStreamWriter(OutputStream out,String  charsetName):�ڶ���������������֣�ֻ������������UTF-8,GBK
 * 
 * @author Administrator
 *
 */
public class OutputStreamWriterDemo {

	/**
	 * ת��������OutputStreamд�ı�
	 * �ı�����GBK����ʽд��
	 * @throws FileNotFoundException 
	 * @throws UnsupportedEncodingException 
	 */
	@Test
	public void writeGBK() throws Exception{
		//�����ֽ��������������Դ
		FileOutputStream fos=new FileOutputStream("e:\\tomcat\\fileobject\\hellow.txt");
		//����ת�������󣬹��췽�������ֽ������
		OutputStreamWriter osw=new OutputStreamWriter(fos,"GBK");
		//ת����д����
		osw.write("����");
		osw.close();
		
	}
	
	/**
	 * ת��������OutputStreamд�ı�
	 * �ı�����UTF-8����ʽд��
	 * @throws FileNotFoundException 
	 * @throws UnsupportedEncodingException 
	 */
	@Test
	public void writeUTF() throws Exception{
		//�����ֽ��������������Դ
		FileOutputStream fos=new FileOutputStream("e:\\tomcat\\fileobject\\hellow.txt");
		//����ת�������󣬹��췽����װ�ֽ������Ҵ��ڶ�������������ֽ������
		OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
		//ת����д����
		osw.write("����UTF-8");
		osw.close();
		
	}
	
	
	
	
	
	
	
}




