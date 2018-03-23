package com.it.a;

import java.io.File;

/**
 * File类的构造方法
 * 三种重载的方式
 * @author Feng
 *另外可以通过exists()方法判断文件，或者路径是否存在。
 */


public class FileDemo02Constrc {

	
	
	public static void main(String[] args) {
		constrator1();
		System.out.println("构造器2：File(String parent, String child) ");
		construction2();
		System.out.println("构造器3：File(File parent, String child) ");
		construction3();
	}	
	
	/*
	 * 构造方法1：
	 * File(String pathName);
	 * 传递路径名：可以写到文件夹，可以写到一个文件
	 * c:\\abc 	c:\\abc\Demo.java
	 * 将路径封装File类型对象
	 */
	private static void constrator1() {
		File file=new File("e:\\Tomcat\\Tomcat.txt");
		System.out.println(file);
		boolean flag=file.exists();
		System.out.println(flag);
	}
	
	
	/**
	 * 构造方法二
	 * File(String parent, String child) 
	 * 传递的是字符串父路径，和字符串子路径
	 * 灵活性更好
	 */
	private static void construction2(){
		File file=new File("e:","Tomcat");
		System.out.println(file+"\t,flag"+file.exists());
		
	}
	
	/**
	 * 构造方法三
	 * File(File parent, String child) 
	 * 传递的是File类型的父路径，和字符串子路径
	 * 好处：父路径是File类型，父路径可以直接调用File类的方法
	 */
	private static void construction3(){
		File parent=new File("e:");
		File file1=new File(parent,"Tomcat");
		System.out.println(file1+"\t,flag"+file1.exists());
		
	}
	
	
	
	
}
