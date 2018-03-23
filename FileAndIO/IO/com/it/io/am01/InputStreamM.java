package com.it.io.am01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * 字节输入流
 * 		InputStream:是所有的字节流的父类
 * 		使用：读取任意文件，每次只读入一个字节的数据
 * 		读取方法：
 * 			int read():读取一个字节
 * 			int read(byte[] b):读取一定量的字节到数组中
 * @author Administrator
 *
 */
public class InputStreamM {
	/**
	 * 实现文件的复制：
	 * 		将e:\\tomcat\\fileobject\\hellow.txt复制到e:\\tomcat\\fileobject\\a\\abc.txt中
	 *		输入：一个字节
	 *		输出：一个字节
	 */
	@Test
	public void copyFile(){
		//定义两个流对象
		FileOutputStream fos=null;
		FileInputStream fis=null;
		try{
			//建立两个数据源，绑定输入数据源，和输出目的
			fis=new FileInputStream("e:\\tomcat\\fileobject\\hellow.txt");
			fos=new FileOutputStream("e:\\tomcat\\fileobject\\a\\abcd.txt");
			//字节输入流，读取一个字节，输出流写出一字节
			int len=0;
			while((len=fis.read())!=-1){
				fos.write(len);
				
			}
			
			
		}catch(Exception e){
			System.out.println(e);
			throw new RuntimeException("文件输出失败！");
		}finally{
			try {
				if(fos!=null)				fos.close();
				
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally{
				try {
					if(fis!=null)				fis.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
	}
		/**
		 * 实现文件的复制：
		 * 		将e:\\tomcat\\fileobject\\zip.zip复制到e:\\tomcat\\fileobject\\a\\zip.zip中
		 *		输入：一个字节
		 *		输出：一个字节
		 *		采用缓冲区，提高效率。
		 *		测试：复制使用时间
		 */
		@Test
		public void copyFile1(){
			long start = System.currentTimeMillis();
			//定义两个流对象
			FileOutputStream fos=null;
			FileInputStream fis=null;
			try{
				//建立两个数据源，绑定输入数据源，和输出目的
				fis=new FileInputStream("e:\\tomcat\\fileobject\\zip.zip");
				fos=new FileOutputStream("e:\\tomcat\\fileobject\\a\\zip.zip");
				//字节输入流，读取一个字节，输出流写出一字节
				int len=0;
				//定义字节数组用于缓冲
				byte[] b=new byte[1024];
				//读取数组，写入数组
				while((len=fis.read(b))!=-1){
					fos.write(b,0,len);
					
				}
				
				
			}catch(Exception e){
				System.out.println(e);
				throw new RuntimeException("文件输出失败！");
			}finally{
				try {
					if(fos!=null)				fos.close();
					
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}finally{
					try {
						if(fis!=null)				fis.close();
						long end = System.currentTimeMillis();
						System.out.println(end-start);
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			}
	}
	
	
	
	
	
	
}











