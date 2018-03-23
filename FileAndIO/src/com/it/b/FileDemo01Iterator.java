package com.it.b;

import java.io.File;

import org.junit.Test;

/**
 * 对一个目录下的所有类容，进行完全的的遍历
 * @author Administrator
 *
 */
public class FileDemo01Iterator {

	/**
	 * 定义方法，实现目录的全遍历
	 */
	@Test
	public void getAllDir(){
				File file=new File("e:\\tomcat\\fileobject\\");
				//调用方法listFiles(),对目录进行遍历
				File[] list=file.listFiles();
				for(File f:list){
					if(f.isDirectory()){
						System.out.println("遍历子文件夹");
						File[] list1=f.listFiles();
						for(File f1:list1){
							System.out.println(f1);
						}
					}else{
						System.out.println("子文件的大小："+f.length()/1024);
					}
					
				}
	}
	
	
	
	
}
