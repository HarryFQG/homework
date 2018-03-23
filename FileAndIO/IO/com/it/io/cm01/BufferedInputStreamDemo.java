package com.it.io.cm01;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;

/**
 * 字节输入流的缓冲流
 * 		java.io.BufferedInputStream
 * 		继承：InputStream,标准的字节输入流
 * 		读取方法：
 * 			read():单个字节，字节数组
 * 		构造方法：
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
