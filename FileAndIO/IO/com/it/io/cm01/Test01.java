package com.it.io.cm01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/*
 * �ֽ��������ļ���4�ַ�ʽ
 * 		e:\\tomcat\\fileobject\\zip.zip:��СΪ4.76M��
 * 		�����СΪ��byts[1024]
 * 		1.�ֽ���д�����ֽ�:						��ʱ��16230ms
 * 		2.�ֽ���д����								��ʱ��40ms
 * 		3.�ֽڻ�����д�����ֽ�				��ʱ��190ms
 * 		4.�ֽڻ�����д����						��ʱ��20
 */
public class Test01 {

	/**
	 * ��һ�֣��ֽ���д�����ֽ�
	 * @throws Exception 
	 */
	@Test
	public void stream01() {
		long start=System.currentTimeMillis();
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try{
			
			fis=new FileInputStream("e:\\tomcat\\fileobject\\zip.zip");
			fos=new FileOutputStream("e:\\tomcat\\fileobject\\a\\zip.zip");
			int len=0;
			while((len=fis.read())!=-1){
				fos.write(len);				
			}
			
		}catch(Exception e){
			e.getStackTrace();
			throw new  RuntimeException();
		}finally{
			try {
				fos.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}finally{
				try {
					fis.close();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
		
		long end=System.currentTimeMillis();
		System.out.println("��ʱ��"+(end-start));
	}
	
	
	/**
	 * �ڶ��֣��ֽ�������д�����ֽ�
	 * @throws Exception 
	 */
	@Test
	public void streamArray() {
		long start=System.currentTimeMillis();
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try{
			
			fis=new FileInputStream("e:\\tomcat\\fileobject\\zip.zip");
			fos=new FileOutputStream("e:\\tomcat\\fileobject\\a\\zip.zip");
			int len=0;
			byte[] b=new byte[1024];
			while((len=fis.read(b))!=-1){
				fos.write(b,0,len);				
			}
			
		}catch(Exception e){
			e.getStackTrace();
			throw new  RuntimeException();
		}finally{
			try {
				fos.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}finally{
				try {
					fis.close();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
		
		long end=System.currentTimeMillis();
		System.out.println("��ʱ��"+(end-start));
	}
	
	/**
	 * �����֣��ֽڻ����������ֽ�
	 * @throws Exception 
	 */
	@Test
	public void bufferStream() {
		long start=System.currentTimeMillis();
		BufferedOutputStream bos=null;
		BufferedInputStream bis=null;
		try{
			
			bis=new BufferedInputStream(new FileInputStream("e:\\tomcat\\fileobject\\zip.zip"));
			bos=new BufferedOutputStream(new FileOutputStream("e:\\tomcat\\fileobject\\a\\zip.zip"));
			int len=0;
			
			while((len=bis.read())!=-1){
				bos.write(len);				
			}
			
		}catch(Exception e){
			e.getStackTrace();
			throw new  RuntimeException();
		}finally{
			try {
				bos.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}finally{
				try {
					bis.close();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
		
		long end=System.currentTimeMillis();
		System.out.println("��ʱ��"+(end-start));
	}
	
	
	
	/**
	 * �����֣��ֽڻ�����д�����ֽ�
	 * @throws Exception 
	 */
	@Test
	public void bufferStreamArray() {
		long start=System.currentTimeMillis();
		BufferedOutputStream bos=null;
		BufferedInputStream bis=null;
		try{
			
			bis=new BufferedInputStream(new FileInputStream("e:\\tomcat\\fileobject\\zip.zip"));
			bos=new BufferedOutputStream(new FileOutputStream("e:\\tomcat\\fileobject\\a\\zip.zip"));
			int len=0;
			byte[] b=new byte[1024];
			while((len=bis.read(b))!=-1){
				bos.write(b,0,len);				
			}
			
		}catch(Exception e){
			e.getStackTrace();
			throw new  RuntimeException();
		}finally{
			try {
				bos.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}finally{
				try {
					bis.close();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
		
		long end=System.currentTimeMillis();
		System.out.println("��ʱ��"+(end-start));
	}
	
	//-------------------------------------------------------------------------------------------------
	/**
	 * ʹ���ַ������������ı��ļ�
	 * @throws Exception
	 */
	@Test
	public void copyWriterAndReader() throws Exception{
		BufferedReader br=new BufferedReader(new FileReader("e:\\tomcat\\fileobject\\a.txt"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("e:\\tomcat\\fileobject\\a\\a.txt"));
		int line=0;
		String str=null;
		while((str=br.readLine())!=null){
			line++;
			bw.write(line+"\t"+str);
			
			bw.newLine();
			bw.flush();			
		}
		bw.close();
		br.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
