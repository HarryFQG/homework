package com.it.a;

import java.io.File;

import org.junit.Test;

/**
 * File类的判断功能
 * @author Administrator
 *
 */
public class FileDemo05Exists {

	/**
	 * File判断功能
	 * boolean exists();
	 * 判断File构造方法中封装的路径是否存在
	 * 存在返回True,不存在返回false
	 */
	@Test
	public void getExists(){
		
		File file=new File("e:\\tomcat\\fileobject\\a727.doc");
		boolean flag = file.exists();
		System.out.println("文件夹是否存在："+flag);
		
	}
	
	/*
	 * File判断工能
	 * boolean isDirectory();
	 * 判断File构造器中是否传递是文件夹
	 * 存在返回True,不存在返回false
	 */
	@Test
	public void getIsDirectory(){
		File file=new File("e:\\tomcat\\fileobject\\a727.doc");
		boolean flag = file.isDirectory();
		
		File file1=new File("e:\\tomcat\\fileobject\\");
		boolean flag1 = file1.isDirectory();
		System.out.println("是不是文件夹："+flag+"\t,flag1:"+flag1);
	}
	
	/*
	 * File判断工能
	 * boolean isFile();
	 * 判断File构造器中是否传递的是文件
	 * 存在返回True,不存在返回false
	 */
	@Test
	public void getIsFile(){
		File file=new File("e:\\tomcat\\fileobject\\a727.doc");
		boolean flag = file.isDirectory();
		
		File file1=new File("e:\\tomcat\\fileobject\\");
		boolean flag1 = file1.isDirectory();
		System.out.println("是不是文件："+flag+"\t,flag1:"+flag1);
	}
	
	
	
}
