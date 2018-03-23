package com.it.io.am02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.Test;

/**
 * 打印流
 * 		PrintStream
 * 		PrintWriter
 * 	打印流的特点：
 * 		1.此流不负责数据源，只负责数据目的
 * 		2.为其它输出流，添加功能
 * 		3.永远不会抛出IOException异常，但是可能会抛出其它的异常
 * 
 * 	两个打印流的方法完全一致，区别：
 * 		1.构造器，就是打印流的输出目的端
 * 		2.PrintStream
 * 			构造方法，接受File类型，接受字符串文件名，接受字节输出流OutputStream
 * 		3.PrintWriter
 * 			*构造方法，接受File类型，接受字符串文件名，接受字节输出流OutputStream,接受字符输出流Writer
 * @author Administrator
 *
 */
public class PrinterWriterDemo {

	/*
	 * 打印流，向File对象的数据目写入数据
	 * 方法：print println		原样输出，写啥打啥
	 * 		writer				走码表
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
