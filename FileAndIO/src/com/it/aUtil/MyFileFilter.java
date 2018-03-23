package com.it.aUtil;

import java.io.File;
import java.io.FileFilter;
/**
 * 自定义过滤器
 * 实现FileFilter接口的抽象方法
 * @author Administrator
 *和FileDemo07Interceptor组合一起
 */
public class MyFileFilter implements FileFilter{

	@Override
	public boolean accept(File pathName) {
		/**
		 * pathName：接受的是来自listFiles();而且是个全路径名
		 * e:\\tomcat\\fileobject\\Lucene.txt
		 * 对路径进行判断，如果是Txt文件，返回TRUE，不是返回false;
		 * 文件的后缀结尾是.txt
		 */
		String name=pathName.getName();
		boolean flag=name.endsWith(".txt");
		return flag;
	}

	
	
	
	
	
	
}
