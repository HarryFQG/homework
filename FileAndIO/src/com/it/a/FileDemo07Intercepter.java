package com.it.a;

import java.io.File;

import org.junit.Test;

import com.it.aUtil.MyFileFilter;
/**
 * �ļ���Ļ�ȡ��
 * �ļ��Ĺ�����
 * ����һ��Ŀ¼ʱ�򣬿��Ը�����Ҫ��ֻ��ȡ��Ҫ�������������ļ�
 * ����Ŀ¼�ķ���ListFiles()����
 * 		ListFiles(FileFilter filter);�ӿ�����
 * 		����FileFilter�ӿڵ�ʵ����
 * �Զ���FileFilter�ӿڵ�ʵ���࣬��д���󷽷�
 * �ӿ�ʵ������󴫵ݵ���������listFiles();
 * @author Administrator
 *
 */
public class FileDemo07Intercepter {
	
	 
	/**
	 * ���ļ��Ĺ��ˣ���ȡָ���ĺ�׺���ļ���Ҳ������ָ�����ļ���(�ӿڵĻص�)
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
