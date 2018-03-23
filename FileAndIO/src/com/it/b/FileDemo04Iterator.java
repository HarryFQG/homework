package com.it.b;

import java.io.File;

import org.junit.Test;

import com.it.aUtil.MyFileFilter2;

/**
 * 遍历目录，获取目录下的所有.txt文件
 * 遍历多级目录，使用递归实现
 * 遍历的过程中，使用过滤器
 * @author Administrator
 */
public class FileDemo04Iterator {
	
	@Test
	public void test(){
		File file=new File("e:\\tomcat\\fileobject\\");
		getTxtAll(file);
	} 
	
	
	/**
	 * 定义方法，实现指定遍历目录
	 * 获取目录中的所有的文本文件(.txt)
	 */
	public void getTxtAll(File file){
		//调用File对象方法listFiles()获取，加入过滤器
		File[] fileArr=file.listFiles(new MyFileFilter2());
		for(File f:fileArr){
			//对f路径进行判断是不是文件夹
			if(f.isDirectory()){
				//进行递归
				getTxtAll(f);
			}else{
				System.out.println("文件："+f);
				
			}
		}
		
	}
	
	
	
	
	
}
