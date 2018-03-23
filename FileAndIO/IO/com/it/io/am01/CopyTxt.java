package com.it.io.am01;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * ʹ���ֽ������ַ��������ı�
 * @author Administrator
 *
 */
public class CopyTxt {

	/**1.ʹ���ֽ���
	 * ʵ���ļ��ĸ��ƣ�
	 * 		��e:\\tomcat\\fileobject\\zip.zip���Ƶ�e:\\tomcat\\fileobject\\a\\zip.zip��
	 *		���룺һ���ֽ�
	 *		�����һ���ֽ�
	 *		���û����������Ч�ʡ�
	 *		���ԣ�����ʹ��ʱ��
	 */
	@Test
	public void copyFile1(){
		long start = System.currentTimeMillis();
		//��������������
		FileOutputStream fos=null;
		FileInputStream fis=null;
		try{
			//������������Դ������������Դ�������Ŀ��
			fis=new FileInputStream("e:\\tomcat\\fileobject\\zip.zip");
			fos=new FileOutputStream("e:\\tomcat\\fileobject\\a\\zip11.zip");
			//�ֽ�����������ȡһ���ֽڣ������д��һ�ֽ�
			int len=0;
			//�����ֽ��������ڻ���
			byte[] b=new byte[1024];
			//��ȡ���飬д������
			while((len=fis.read(b))!=-1){
				fos.write(b,0,len);
				
			}
			
			
		}catch(Exception e){
			System.out.println(e);
			throw new RuntimeException("�ļ����ʧ�ܣ�");
		}finally{
			try {
				if(fos!=null)				fos.close();
				
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
				throw new RuntimeException("��Դ�ͷ�ʧ�ܣ�");
			}finally{
				try {
					if(fis!=null)				fis.close();
					long end = System.currentTimeMillis();
					System.out.println(end-start);
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
	
	}
	/**
	 * �������ı��ļ���������ͼƬ�����֣���Ƶ�����ƹ�ȥ��Ҳ�򲻿���
	 */
	@Test
	public void writerAndReader(){
		FileReader fr=null;
		FileWriter fw=null;
		try {
			fr=new FileReader("e:\\tomcat\\fileobject\\Lucene.txt");
			fw=new FileWriter("e:\\tomcat\\fileobject\\a\\Lucene1122.txt");
			int len=0;
			char[] c=new char[1024];
			while((len=fr.read(c))!=-1){
				fw.write(c, 0, len);
				fw.flush();
			}
			
			
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally{
			try {
				if(fw!=null)				fw.close();
				
			} catch (IOException e) {
			
				e.printStackTrace();
				throw new RuntimeException("�ļ�����ʧ�ܣ�");
			}finally{
				try {
					if(fr!=null)				fr.close();
					
				
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	
	
	
}
