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
 * 字节流复制文件：4种方式
 * 		e:\\tomcat\\fileobject\\zip.zip:大小为4.76M；
 * 		数组大小为：byts[1024]
 * 		1.字节流写单个字节:						耗时：16230ms
 * 		2.字节流写数组								耗时：40ms
 * 		3.字节缓冲流写单个字节				耗时：190ms
 * 		4.字节缓冲流写数组						耗时：20
 */
public class Test01 {

	/**
	 * 第一种：字节流写单个字节
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
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally{
				try {
					fis.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
		
		long end=System.currentTimeMillis();
		System.out.println("耗时："+(end-start));
	}
	
	
	/**
	 * 第二种：字节流数组写单个字节
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
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally{
				try {
					fis.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
		
		long end=System.currentTimeMillis();
		System.out.println("耗时："+(end-start));
	}
	
	/**
	 * 第三种：字节缓冲流单个字节
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
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally{
				try {
					bis.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
		
		long end=System.currentTimeMillis();
		System.out.println("耗时："+(end-start));
	}
	
	
	
	/**
	 * 第四种：字节缓冲流写数组字节
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
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally{
				try {
					bis.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
		
		long end=System.currentTimeMillis();
		System.out.println("耗时："+(end-start));
	}
	
	//-------------------------------------------------------------------------------------------------
	/**
	 * 使用字符缓冲流复制文本文件
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
