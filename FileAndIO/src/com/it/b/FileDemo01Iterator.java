package com.it.b;

import java.io.File;

import org.junit.Test;

/**
 * ��һ��Ŀ¼�µ��������ݣ�������ȫ�ĵı���
 * @author Administrator
 *
 */
public class FileDemo01Iterator {

	/**
	 * ���巽����ʵ��Ŀ¼��ȫ����
	 */
	@Test
	public void getAllDir(){
				File file=new File("e:\\tomcat\\fileobject\\");
				//���÷���listFiles(),��Ŀ¼���б���
				File[] list=file.listFiles();
				for(File f:list){
					if(f.isDirectory()){
						System.out.println("�������ļ���");
						File[] list1=f.listFiles();
						for(File f1:list1){
							System.out.println(f1);
						}
					}else{
						System.out.println("���ļ��Ĵ�С��"+f.length()/1024);
					}
					
				}
	}
	
	
	
	
}
