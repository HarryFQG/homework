package com.it.a;

import java.io.File;

import org.junit.Test;

import com.it.aUtil.MyFileFilter;
/**
 * 文件类的获取，
 * 文件的过滤器
 * 遍历一个目录时候，可以根据需要，只获取需要的满足条件的文件
 * 遍历目录的方法ListFiles()重载
 * 		ListFiles(FileFilter filter);接口类型
 * 		传递FileFilter接口的实现类
 * 自定义FileFilter接口的实现类，重写抽象方法
 * 接口实现类对象传递到遍历方法listFiles();
 * @author Administrator
 *
 */
public class FileDemo07Intercepter {
	
	 
	/**
	 * 对文件的过滤，获取指定的后缀名文件，也可以是指定的文件。(接口的回调)
	 */
	@Test
	public void fileFilter(){
		File file=new File("e:\\tomcat\\fileobject\\");
		File[] fileList=file.listFiles(new MyFileFilter());
		for(File f:fileList){
			System.out.println(f);
		}
	}
	
	
	
	
	
	
	
	
}
