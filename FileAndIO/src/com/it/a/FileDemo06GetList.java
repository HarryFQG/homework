package com.it.a;

import java.io.File;

import org.junit.Test;

/**
 * File��Ļ�ȡ����
 * List
 * ListFiles:
 * @author Administrator
 *
 */
public class FileDemo06GetList {

	
	/**
	 * File��Ļ�ȡ����
	 * String[] list;
	 * ��ȡ����File���췽���з�װ��·���е��ļ����ļ���
	 * 		ֻ�����һ��·������������
	 */
	@Test
	public void getList(){
		File file=new File("e:\\tomcat\\fileobject\\");//��õ�������ļ����µ��ļ����ļ���(�������غ��ܱ������ļ����ļ���)
		String[] files=file.list();
		for(String str:files ){
			System.out.println(str);
		}
		
	}
	
	/**
	 * File��Ļ�ȡ����
	 * File[] list;(����)
	 * ��ȡ����File���췽���з�װ��·���е��ļ����ļ��е�File����
	 * ���ص��Ǹ�������·��
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
	 * ��ȡϵͳ���еĸ�Ŀ¼
	 */
	@Test
	public void getList2(){
		File[] list = File.listRoots();
		for(File f:list){
			System.out.println(f);
		}
	}
}
