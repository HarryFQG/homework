package com.it.io.am02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.Test;

/**
 * ��ӡ��
 * 		PrintStream
 * 		PrintWriter
 * 	��ӡ�����ص㣺
 * 		1.��������������Դ��ֻ��������Ŀ��
 * 		2.Ϊ�������������ӹ���
 * 		3.��Զ�����׳�IOException�쳣�����ǿ��ܻ��׳��������쳣
 * 
 * 	������ӡ���ķ�����ȫһ�£�����
 * 		1.�����������Ǵ�ӡ�������Ŀ�Ķ�
 * 		2.PrintStream
 * 			���췽��������File���ͣ������ַ����ļ����������ֽ������OutputStream
 * 		3.PrintWriter
 * 			*���췽��������File���ͣ������ַ����ļ����������ֽ������OutputStream,�����ַ������Writer
 * @author Administrator
 *
 */
public class PrinterWriterDemo {

	/*
	 * ��ӡ������File���������Ŀд������
	 * ������print println		ԭ�������дɶ��ɶ
	 * 		writer				�����
	 */
	@Test
	public void print() throws FileNotFoundException{
		File file=new File("e:\\tomcat\\fileobject\\hellow.txt");
		PrintWriter pw=new PrintWriter(file);
		pw.println(100);
		pw.write(100);
		//pw.flush();
		pw.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
