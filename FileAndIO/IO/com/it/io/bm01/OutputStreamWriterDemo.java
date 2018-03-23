package com.it.io.bm01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

/**
 * 转换流
 * 		java.io.OutputStreamWriter继承Writer类
 * 		就是一个字符输出流，只写文本
 * 		write()字符串，字符数组，字符串
 * 		
 * 		OutputStreamWriter使用方法：
 * 			构造函数：
 * 					1.OutputStreamWriter(OutputStream out):接受所有的字节输出流
 * 						但是：字节输出流：FileOutputStream
 * 		
 * 					2.OutputStreamWriter(OutputStream out,String  charsetName):第二个参数是码表名字，只可以用两个，UTF-8,GBK
 * 
 * @author Administrator
 *
 */
public class OutputStreamWriterDemo {

	/**
	 * 转换流对象OutputStream写文本
	 * 文本采用GBK的形式写入
	 * @throws FileNotFoundException 
	 * @throws UnsupportedEncodingException 
	 */
	@Test
	public void writeGBK() throws Exception{
		//创建字节输出流，绑定数据源
		FileOutputStream fos=new FileOutputStream("e:\\tomcat\\fileobject\\hellow.txt");
		//创建转换流对象，构造方法，绑定字节输出流
		OutputStreamWriter osw=new OutputStreamWriter(fos,"GBK");
		//转换流写数组
		osw.write("我们");
		osw.close();
		
	}
	
	/**
	 * 转换流对象OutputStream写文本
	 * 文本采用UTF-8的形式写入
	 * @throws FileNotFoundException 
	 * @throws UnsupportedEncodingException 
	 */
	@Test
	public void writeUTF() throws Exception{
		//创建字节输出流，绑定数据源
		FileOutputStream fos=new FileOutputStream("e:\\tomcat\\fileobject\\hellow.txt");
		//创建转换流对象，构造方法包装字节流并且带第二个参数码表，绑定字节输出流
		OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
		//转换流写数组
		osw.write("我们UTF-8");
		osw.close();
		
	}
	
	
	
	
	
	
	
}




