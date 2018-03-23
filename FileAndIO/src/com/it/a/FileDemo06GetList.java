package com.it.a;

import java.io.File;

import org.junit.Test;

/**
 * File类的获取功能
 * List
 * ListFiles:
 * @author Administrator
 *
 */
public class FileDemo06GetList {

	
	/**
	 * File类的获取功能
	 * String[] list;
	 * 获取到，File构造方法中封装的路径中的文件和文件夹
	 * 		只有最后一个路径名。不完整
	 */
	@Test
	public void getList(){
		File file=new File("e:\\tomcat\\fileobject\\");//获得的是这个文件夹下的文件和文件夹(包括隐藏和受保护的文件和文件夹)
		String[] files=file.list();
		for(String str:files ){
			System.out.println(str);
		}
		
	}
	
	/**
	 * File类的获取功能
	 * File[] list;(常用)
	 * 获取到，File构造方法中封装的路径中的文件和文件夹的File对象
	 * 返回的是个完整的路径
	 */
	@Test
	public void getList1(){
		File file=new File("e:\\tomcat\\fileobject\\");
		File[] files = file.listFiles();
		for(File file1:files){
			System.out.println(file1);
		}
	}
	
	/**
	 * 获取系统所有的更目录
	 */
	@Test
	public void getList2(){
		File[] list = File.listRoots();
		for(File f:list){
			System.out.println(f);
		}
	}
}
