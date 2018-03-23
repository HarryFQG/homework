package com.it.a;

import java.io.File;

import org.junit.Test;

/**
 * File类的获取功能
 * @author Feng
 */
public class FileDemo04Get {
	
	/**
	 * File类的获取功能
	 * String getName(); 
	 * 返回路径中表示的文件或者文件夹名
	 * 获取的是路径中最后的名字，不检查是否存在。
	 */
	@Test
	public void getFile(){
		File file=new File("e:\\tomcat\\fileobject\\a727.doc");//获取准确的文件
		File file1=new File("e:\\tomcat\\fileobject\\");//获取准确的文件夹
		String str1=file.getName();
		String str2=file1.getName();
		String str3=file.getPath();
		System.out.println("文件路径:"+str1+"\t文件夹路径："+str2+"\tpath:"+str3);
	}

	/**
	 * File类型的获取功能
	 * long length()
	 * 返回路径中表示的文件的字节数
	 * 只能获得单个文件的大小，不能获得文件夹的大小。
	 */
	@Test
	public void getFileLength(){
		File file=new File("e:\\tomcat\\fileobject\\a727.doc");
		long len = file.length();
		System.out.println("文件大小："+len/1024+"Kb");
		
	}
	/**
	 * File类型的获取功能
	 * String getAbsolutePath();
	 * File getAbsoluteFile() 返回的是File对象
	 * 获取绝对路径:
	 * eclipse环境中，写的是一个相对路径，获得绝对位置是工程目录
	 */
	@Test
	public void getAbsoluteFile(){
		File file=new File(" ");
		File file1 = file.getAbsoluteFile();
		String parent = file1.getParent();
		File f=new File(parent);
		System.out.println(f);
	}
	
	/**
	 * File类的获取功能
	 * String getParent() 返回的是String类型的对象
	 * File  getAbsoluteFile() 返回的是File类型的对象。(推荐使用这个)
	 */
	//获取父路径
	@Test
	public void getParent(){
		File file=new File("e:\\tomcat\\fileobject\\a727.doc");
		File parent=file.getParentFile();
		System.out.println("父路径："+parent.getPath());
	} 
	
	
	
}
