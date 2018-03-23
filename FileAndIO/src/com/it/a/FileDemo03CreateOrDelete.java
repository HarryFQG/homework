package com.it.a;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * File��Ĵ�����ɾ��
 * 			�ļ�����Ŀ¼
 * @author Feng
 *
 */


public class FileDemo03CreateOrDelete {

	/**
	 * File�����ļ��Ĺ���
	 * boolean CreateNameFile();
	 * �ļ����Ͳ��ޣ�Ҳ���Ǻ�׺��txt,doc,ppt....��
	 * �������ļ�·�����ļ�������File���췽���и�����
	 * @throws IOException 
	 * ע�⣺����ļ��Ѿ����ڣ��Ͳ��ٴ��������ң����ܴ����ļ��У�ֻ�ܴ����ļ���	
	 *  */	
	@Test
	public void createFile() throws IOException{	
		File file=new File("E:\\tomcat\\fileObject\\a727.txt");
		System.out.println(file+",\t"+file.exists());//����ļ��Ƿ����
		boolean flag = file.createNewFile();
		System.out.println("�Ƿ񴴼��ɹ���"+flag);
	}
	/**
	 * File�����ļ��й���
	 * boolean mkdirs();//�����༶�ļ���,���������mkdir()���ܡ�
	 * �������ļ���·�����ļ���������File���췽���и�����
	 *����ļ����Ѿ����ڣ����ڴ���
	 */	
	@Test	
	public void createFile2(){
		File file=new File("E:\\tomcat\\fileobject\\newFile\\a");
		System.out.println(file+"\t,"+file.exists());//����ļ����Ƿ����
		boolean flag = file.mkdirs();
		System.out.println("�Ƿ񴴼��ɹ���"+flag);
		
	}
	//---------------------------------------------------------------------------------------------
	/**
	 * File���ɾ������
	 * boolean delete()
	 * ɾ�����ļ������ļ��У���File���췽���и���
	 * ɾ���ɹ�����true��ɾ��ʧ�ܷ���false
	 * ����ļ��򿪣����߲����ڷ���false,����ɾ���Ķ�������Żػ���վ��
	 * ɾ���з��գ������������
	 */
	
	/**
	 * ɾ���ļ���
	 */
	@Test
	public void deleteFile1(){
		File file=new File("E:\\tomcat\\fileobject\\newFile\\a");
		boolean flag = file.delete();
		System.out.println("�Ƿ�ɾ���ɹ���"+flag);
	}
	
	/**
	 * ɾ���ļ�
	 */
	@Test
	public void deleteFile2(){
		File file=new File("E:\\tomcat\\fileobject\\a727.txt");
		boolean flag = file.delete();
		System.out.println("�Ƿ�ɾ���ɹ���"+flag);
	}
	
	
	
	
	
	
	
}
