package com.it.aUtil;

import java.io.File;
import java.io.FileFilter;
/**
 * 
 * @author Administrator
 *和com/it/b/FileDemo04Iterator.java一起
 */
public class MyFileFilter2 implements FileFilter{

	@Override
	public boolean accept(File pathName) {
		//判断是否是目录
		if(pathName.isDirectory())return true;
		return pathName.getName().endsWith(".txt");
	}

	
	
	
	
	
}
