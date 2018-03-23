package com.it.io.cm01;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.Test;

/**
 * �ֽ����������
 * 		java.io.BufferedOutputStream��	
 * 		�̳���OutputStream
 * 		���ã����ԭ�е��������д������
 * 		������write,�ֽڣ��ֽ�����
 * 
 * 		���췽����
 * 				BufferedOutputStream(OutputStream out);//���Դ���������ֽ��������ݵ����ĸ��ֽ����Ͷ��ĸ����Ч��
 * 				BufferedOutputStream(OutputStream out,int size );
 * 
 * @author Administrator
 *
 *
 *
 */
public class BufferOutputStreamDemo {

	@Test
	public  void buffer() throws Exception{
		//�����ֽ�������󣬰��ļ�
		FileOutputStream fos=new FileOutputStream("e:\\tomcat\\fileobject\\hellow.txt");
		//�����ֽ�����������Ķ��󣬹��췽���д����ֽ������
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		bos.write(55);
		byte[] b="\rhellowWorld".getBytes();
		bos.flush();
		bos.write(b);
		bos.write(b, 3, 2);
		bos.close();
	}
	
	
	
	
	
	
}
