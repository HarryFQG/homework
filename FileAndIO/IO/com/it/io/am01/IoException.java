package com.it.io.am01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * IO�����쳣����
 * try catch finally
 * @author Administrator
 *
 */
public class IoException {

	/**ϸ�ڣ�
	 * 1.��֤��������������㹻
	 * 2.��ô���������쳣��
	 * 3.���ܹ��Ը��������أ�����ֱ�Ӱ�U�̡�ֻ�ܲ�������쳣
	 */
	@Test
	public void IoException(){
		FileOutputStream fos=null;
			try {
				fos=new FileOutputStream("e:\\tomcat\\fileobject\\hellow.txt");
				fos.write(100);
				
				
			}  catch (IOException e) {			
				e.getStackTrace();
				throw new  RuntimeException("�ļ�д��ʧ�ܣ�����....");
			}finally{
				try {
					if(fos!=null){
						fos.close();
					}
				} catch (IOException e) {					
					e.printStackTrace();
					throw new  RuntimeException("�ر���Դʧ�ܣ�����....");
				}				
			}
	
		
	}
	
}
