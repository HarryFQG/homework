package com.it.io.am01;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * 使用字节流和字符流复制文本
 * @author Administrator
 *
 */
public class CopyTxt {

	/**1.使用字节流
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
			fos=new FileOutputStream("e:\\tomcat\\fileobject\\a\\zip11.zip");
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
				throw new RuntimeException("资源释放失败！");
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
	/**
	 * 必须是文本文件，不能是图片，音乐，视频。复制过去了也打不开。
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			try {
				if(fw!=null)				fw.close();
				
			} catch (IOException e) {
			
				e.printStackTrace();
				throw new RuntimeException("文件复制失败！");
			}finally{
				try {
					if(fr!=null)				fr.close();
					
				
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	
	
	
}
