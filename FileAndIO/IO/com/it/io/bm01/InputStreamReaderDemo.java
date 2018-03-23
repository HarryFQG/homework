package com.it.io.bm01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

/**
 * ת����
 * 		java.io.InputStreamReader �̳�Reader
 * 		�ַ�����������ȡ�ı��ļ�
 * @author Administrator
 *		
 *		��ȡ������
 *			read()��ȡһ���ַ�����ȡ�ַ�����
 *		���ɣ�OutputStreamWriterд�ļ�
 *					InputStreamReader��ȡ�ļ�
 *				
 *				OutputStreamWriter(OutputStream out):�����ֽ������	
 *				InputStreamReader (InputStream in):�����ֽ�������
 *				���Դ��ݵ��ֽ���������FileInputStream
 *				InputStreamReader(InputStream in,String charsetName����
 */
public class InputStreamReaderDemo {

	/**
	 * ת������InputStreamReader��ȡ�ı�
	 * ����ϵͳĬ�ϱ������ȡGBK�ļ�
	 * @throws IOException
	 */
	@Test
	public void readerGBK() throws IOException{
		FileInputStream fis=new FileInputStream("e:\\tomcat\\fileobject\\hellow.txt");
		//����ת�������󣬹��췽���а�װ�ֽ�����
		InputStreamReader isr=new InputStreamReader(fis);
		char[] c=new char[1024];
		int len=0;
		while((len=isr.read(c))!=-1){
			System.out.println(new String(c,0,len));
		}
		isr.close();
	}
	/**
	 * ת������InputStreamReader��ȡ�ı�
	 * ����UTF-8�������ȡUTF�ļ�
	 * @throws IOException
	 */
	@Test
	public void readerUTF() throws IOException{
		FileInputStream fis=new FileInputStream("e:\\tomcat\\fileobject\\hellow.txt");
		//����ת�������󣬹��췽���а�װ�ֽ�����
		InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
		char[] c=new char[1024];
		int len=0;
		while((len=isr.read(c))!=-1){
			System.out.println(new String(c,0,len));
		}
		isr.close();
	}
	
	
	
	
	
	
	
}

