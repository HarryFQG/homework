package com.it.aUtil;

import java.io.File;
import java.io.FileFilter;
/**
 * 
 * @author Administrator
 *��com/it/b/FileDemo04Iterator.javaһ��
 */
public class MyFileFilter2 implements FileFilter{

	@Override
	public boolean accept(File pathName) {
		//�ж��Ƿ���Ŀ¼
		if(pathName.isDirectory())return true;
		return pathName.getName().endsWith(".txt");
	}

	
	
	
	
	
}
