package com.it.aUtil;

import java.io.File;
import java.io.FileFilter;
/**
 * �Զ��������
 * ʵ��FileFilter�ӿڵĳ��󷽷�
 * @author Administrator
 *��FileDemo07Interceptor���һ��
 */
public class MyFileFilter implements FileFilter{

	@Override
	public boolean accept(File pathName) {
		/**
		 * pathName�����ܵ�������listFiles();�����Ǹ�ȫ·����
		 * e:\\tomcat\\fileobject\\Lucene.txt
		 * ��·�������жϣ������Txt�ļ�������TRUE�����Ƿ���false;
		 * �ļ��ĺ�׺��β��.txt
		 */
		String name=pathName.getName();
		boolean flag=name.endsWith(".txt");
		return flag;
	}

	
	
	
	
	
	
}
