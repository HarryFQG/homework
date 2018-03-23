package com.it.io.am01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * �ֽ�������
 * 		InputStream:�����е��ֽ����ĸ���
 * 		ʹ�ã���ȡ�����ļ���ÿ��ֻ����һ���ֽڵ�����
 * 		��ȡ������
 * 			int read():��ȡһ���ֽ�
 * 			int read(byte[] b):��ȡһ�������ֽڵ�������
 * @author Administrator
 *
 */
public class InputStreamM {
	/**
	 * ʵ���ļ��ĸ��ƣ�
	 * 		��e:\\tomcat\\fileobject\\hellow.txt���Ƶ�e:\\tomcat\\fileobject\\a\\abc.txt��
	 *		���룺һ���ֽ�
	 *		�����һ���ֽ�
	 */
	@Test
	public void copyFile(){
		//��������������
		FileOutputStream fos=null;
		FileInputStream fis=null;
		try{
			//������������Դ������������Դ�������Ŀ��
			fis=new FileInputStream("e:\\tomcat\\fileobject\\hellow.txt");
			fos=new FileOutputStream("e:\\tomcat\\fileobject\\a\\abcd.txt");
			//�ֽ�����������ȡһ���ֽڣ������д��һ�ֽ�
			int len=0;
			while((len=fis.read())!=-1){
				fos.write(len);
				
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
			}finally{
				try {
					if(fis!=null)				fis.close();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
	}
		/**
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
				fos=new FileOutputStream("e:\\tomcat\\fileobject\\a\\zip.zip");
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
	
	
	
	
	
	
}











