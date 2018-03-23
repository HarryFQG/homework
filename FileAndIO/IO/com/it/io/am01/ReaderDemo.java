package com.it.io.am01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

/**
 * �ַ������ļ���
 * 			��ȡ�ı��ļ������±����ܴ򿪵��ļ����������ܿ��ö���
 * 			java.io.Reader
 * ר�Ŷ�ȡ�ı��ļ�:
 * 		
 * 
 * 		��ȡ������read():
 * 			int read():��ȡһ���ַ�
 * 			int read(char[] c):��ȡ�ַ�����
 * 		���ࣺFileReader
 * 			���췽����������Դ
 * 				File file;
 * 				String path;
 * @author Administrator
 *
 */
public class ReaderDemo {

	@Test
	public void read0() throws IOException{
		FileReader fr=new FileReader("e:\\tomcat\\fileobject\\hellow.txt");
		int len =0;
		while((len=fr.read())!=-1){
			System.out.println((char)len);
		}
		
		fr.close();
	}
	
	
	@Test
	public void read1() throws IOException{
		FileReader fr=new FileReader("e:\\tomcat\\fileobject\\hellow.txt");
	
		char[] c = new char[1024];
		int len=0;		
		while((len=fr.read(c))!=-1){
			System.out.println(new String(c,0,len));
		}
		fr.close();
	}
	
	
	
	
	
	
}










