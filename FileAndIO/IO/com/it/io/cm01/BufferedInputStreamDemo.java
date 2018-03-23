package com.it.io.cm01;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;

/**
 * �ֽ��������Ļ�����
 * 		java.io.BufferedInputStream
 * 		�̳У�InputStream,��׼���ֽ�������
 * 		��ȡ������
 * 			read():�����ֽڣ��ֽ�����
 * 		���췽����
 * 			BufferedInputStream(InputStream in);
 * 			BufferedInputStream(InputStream in, int size) ;
 * 			
 * 		
 * @author Administrator
 *
 */
public class BufferedInputStreamDemo {

	@Test
	public void bufferInput() throws Exception{
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream("e:\\tomcat\\fileobject\\hellow.txt"));
		int len=0;
		byte[] b=new byte[10];
		while((len=bis.read(b))!=-1){
			System.out.print(new String(b,0,len));
		}
		bis.close();
	}
	
	
	
}
