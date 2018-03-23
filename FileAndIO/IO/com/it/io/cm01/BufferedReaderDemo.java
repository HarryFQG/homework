package com.it.io.cm01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

/**
 * �ַ���������
 * 		java.io.BufferedReader �̳�Reader
 * 		��ȡ���ܣ�read():�����ַ����ַ�����
 * 
 * 		���캯����
 * 			BufferedReader(Reader r);//������������ַ���FileReader InputStreamReader
 * 		
 * 		���еķ�����
 * 			String readLine()��ȡһ������\r\n	
 * 		  С�ص㣺
 * 				��ȡ���ݵķ���һ�㶼�з���ֵ
 * 				int����û�з���ֵΪ����
 * 				���������Ҳ���Ϊnull
 * 				boolean�����Ҳ���Ϊfalse
 * 
 * @author Administrator
 *
 */
public class BufferedReaderDemo {
	@Test
	public void bufferedReader() throws IOException{
		
		BufferedReader br=new BufferedReader(new FileReader("e:\\tomcat\\fileobject\\hellow.txt"));
		//�Լ����з�����ȡ��
		String len=null;
		int i=0;
		while((len=br.readLine())!=null){
			i++;
			System.out.println("���з�����"+i+"��,"+len);
		}
		/*int len=0;
		char[] c=new char[10];
		while((len=br.read(c))!=-1){
			System.out.print(new String(c,0,len));
			
		}*/		
		
		
		br.close();
		
		
	}
	
}
