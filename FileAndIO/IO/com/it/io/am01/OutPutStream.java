package com.it.io.am01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.Test;

/**
 * 字节输出流
 * 		java.io.OutputStream		所有字节输出流的父类
 * 		作用：从Java程序往外写数据
 * 		字节: 每次只往外写一个字节(8位二进制的数字)的数据
 * 		写出任意文件
 * 		方法：
 * 		write(int b);写入一个字节
 * 		write(byte[] b):写入字节数组
 * 		write(byte[] b,int off,int len):写入字节数组，开始写入的索引，len写几个
 * 		close():关闭流对象，释放与流相关的资源
 * 		
 * 		
 * 		流对象，是由操作系统资源统一管理。
 * 		
 * @author Administrator
 *
 */
public class OutPutStream {

	/**
	 * FileOutputStream:文件的续写和换行问题
	 * 续写：FileOutputStream的构造方法中，第二个参数传入true即可。
	 * 		在文件中写入换行，符号\r\n,\r\n可以写在上一行的末尾，或者下一行的开头
	 * @throws FileNotFoundException 
	 */	
	@Test
	public void fileOutputStream() throws Exception{
		File file=new File("e:\\tomcat\\fileobject\\hellow.txt");
		FileOutputStream fos=new FileOutputStream(file,true);//就是在末尾进行追加，如果不写或者false,就会覆盖
		fos.write(",Hellow\r\n".getBytes());
		fos.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
