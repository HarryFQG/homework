package com.it.io.cm01;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.Test;

/**
 * 字节输出缓冲流
 * 		java.io.BufferedOutputStream。	
 * 		继承自OutputStream
 * 		作用：提高原有的输出流的写入速率
 * 		方法有write,字节，字节数组
 * 
 * 		构造方法；
 * 				BufferedOutputStream(OutputStream out);//可以传入任意的字节流，传递的是哪个字节流就对哪个提高效率
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
		//创建字节输出对象，绑定文件
		FileOutputStream fos=new FileOutputStream("e:\\tomcat\\fileobject\\hellow.txt");
		//创建字节输出缓冲流的对象，构造方法中传递字节输出流
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		bos.write(55);
		byte[] b="\rhellowWorld".getBytes();
		bos.flush();
		bos.write(b);
		bos.write(b, 3, 2);
		bos.close();
	}
	
	
	
	
	
	
}
