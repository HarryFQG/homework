package com.it.io.am02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

/**
 * 对象的序列化与反序列化
 * 		ObjectInputStream和ObjectOutpuStream操作类
 * 		和Person实体类配合使用.
 * ObjectInputStream :反序列化
 * 
 * ObjectOutpuStream：序列化
 * 
 * @author Administrator
 *
 */
public class ObjectStreamDemo {

	/**
	 * ObjectOutputStream
	 * 构造方法：ObjectOutputStream(OutputStream out):传递任意字节流
	 * 调用方法：
	 * 		void writeObject(Object o);写出对象的方法
	 * @throws IOException 
	 */
	
	@Test
	public void writeObj() throws IOException{
		//创建字节输出流，封装文件
		FileOutputStream fos=new FileOutputStream("e:\\tomcat\\fileobject\\PsersonPro.properties") ;
		//创建写出对象的序列化流的对象，构造函数中传入字节流
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		Person p=new Person("李四",20);
		//调用序列化流的对象的writeObject(Object obj)方法，写出方法
		oos.writeObject(p);
		oos.close();
	}
	
	/**
	 * ObjectInputSt ream
	 * 构造方法：ObjectInputStream(InputStream in);传递任意字节输入流，输入流封装文件，必须是序列化过的文件
	 * Object readObject();读取对象
	 * @throws IOException 
	 * @throws Exception 
	 * 
	 */
	@Test
	public void readObj() throws Exception{
		FileInputStream fis=new FileInputStream("e:\\tomcat\\fileobject\\PsersonPro.properties");
		//创建反序列化流，构造方法中，传递字节输入流
		ObjectInputStream ois=new ObjectInputStream(fis);
		//调用反系列化流的readObject()方法读取对象。
		Object obj = ois.readObject();
		System.out.println(obj.toString());
		ois.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
