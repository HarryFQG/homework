package com.it.io.cm01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;
/**
 * �ַ������������
 * java.io.BufferedWriter�̳���Writer
 * д�뷽��write()�����ַ����ַ����飬�ַ���
 * ���췽����
 * 		BufferedWriter(Writer out) ������Writer����ķ���
		BufferedWriter(Writer out, int sz)�� 

 * @author Administrator
 *
 */
public class BufferedWriterDemo {
	
	@Test
	public void bufferWriter() throws IOException{
		BufferedWriter bw=new BufferedWriter(new FileWriter("e:\\tomcat\\fileobject\\hellow.txt"));
		//д�ַ���
		bw.write("��ǰ���¹⣬���ǵ���˪����ͷ�����£���ͷ˼���硣");
		bw.flush();
		
		//д�ַ�����
		char[] c="��ϣ����һ�����ݽṹ".toCharArray();
		bw.write(c);
		bw.flush();
		
		bw.write(122);

		bw.flush();
		bw.close();
	}
	
	
	
	
}



