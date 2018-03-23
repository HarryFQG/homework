package com.it.io.am02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

/**
 * ��������л��뷴���л�
 * 		ObjectInputStream��ObjectOutpuStream������
 * 		��Personʵ�������ʹ��.
 * ObjectInputStream :�����л�
 * 
 * ObjectOutpuStream�����л�
 * 
 * @author Administrator
 *
 */
public class ObjectStreamDemo {

	/**
	 * ObjectOutputStream
	 * ���췽����ObjectOutputStream(OutputStream out):���������ֽ���
	 * ���÷�����
	 * 		void writeObject(Object o);д������ķ���
	 * @throws IOException 
	 */
	
	@Test
	public void writeObj() throws IOException{
		//�����ֽ����������װ�ļ�
		FileOutputStream fos=new FileOutputStream("e:\\tomcat\\fileobject\\PsersonPro.properties") ;
		//����д����������л����Ķ��󣬹��캯���д����ֽ���
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		Person p=new Person("����",20);
		//�������л����Ķ����writeObject(Object obj)������д������
		oos.writeObject(p);
		oos.close();
	}
	
	/**
	 * ObjectInputSt ream
	 * ���췽����ObjectInputStream(InputStream in);���������ֽ�����������������װ�ļ������������л������ļ�
	 * Object readObject();��ȡ����
	 * @throws IOException 
	 * @throws Exception 
	 * 
	 */
	@Test
	public void readObj() throws Exception{
		FileInputStream fis=new FileInputStream("e:\\tomcat\\fileobject\\PsersonPro.properties");
		//���������л��������췽���У������ֽ�������
		ObjectInputStream ois=new ObjectInputStream(fis);
		//���÷�ϵ�л�����readObject()������ȡ����
		Object obj = ois.readObject();
		System.out.println(obj.toString());
		ois.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
