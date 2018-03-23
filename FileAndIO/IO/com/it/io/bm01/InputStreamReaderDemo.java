package com.it.io.bm01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

/**
 * 转换流
 * 		java.io.InputStreamReader 继承Reader
 * 		字符输入流，读取文本文件
 * @author Administrator
 *		
 *		读取方法：
 *			read()读取一个字符，读取字符数组
 *		技巧：OutputStreamWriter写文件
 *					InputStreamReader读取文件
 *				
 *				OutputStreamWriter(OutputStream out):所有字节输出流	
 *				InputStreamReader (InputStream in):所有字节输入流
 *				可以传递的字节输入流：FileInputStream
 *				InputStreamReader(InputStream in,String charsetName）；
 */
public class InputStreamReaderDemo {

	/**
	 * 转换流，InputStreamReader读取文本
	 * 采用系统默认编码表，读取GBK文件
	 * @throws IOException
	 */
	@Test
	public void readerGBK() throws IOException{
		FileInputStream fis=new FileInputStream("e:\\tomcat\\fileobject\\hellow.txt");
		//创建转换流对象，构造方法中包装字节流，
		InputStreamReader isr=new InputStreamReader(fis);
		char[] c=new char[1024];
		int len=0;
		while((len=isr.read(c))!=-1){
			System.out.println(new String(c,0,len));
		}
		isr.close();
	}
	/**
	 * 转换流，InputStreamReader读取文本
	 * 采用UTF-8编码表，读取UTF文件
	 * @throws IOException
	 */
	@Test
	public void readerUTF() throws IOException{
		FileInputStream fis=new FileInputStream("e:\\tomcat\\fileobject\\hellow.txt");
		//创建转换流对象，构造方法中包装字节流，
		InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
		char[] c=new char[1024];
		int len=0;
		while((len=isr.read(c))!=-1){
			System.out.println(new String(c,0,len));
		}
		isr.close();
	}
	
	
	
	
	
	
	
}

