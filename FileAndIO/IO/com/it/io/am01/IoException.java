package com.it.io.am01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * IO流的异常处理
 * try catch finally
 * @author Administrator
 *
 */
public class IoException {

	/**细节：
	 * 1.保证流对象的作用域足够
	 * 2.怎么处理流的异常。
	 * 3.不能够对付物理因素，比如直接拔U盘。只能捕获软件异常
	 */
	@Test
	public void IoException(){
		FileOutputStream fos=null;
			try {
				fos=new FileOutputStream("e:\\tomcat\\fileobject\\hellow.txt");
				fos.write(100);
				
				
			}  catch (IOException e) {			
				e.getStackTrace();
				throw new  RuntimeException("文件写入失败！重试....");
			}finally{
				try {
					if(fos!=null){
						fos.close();
					}
				} catch (IOException e) {					
					e.printStackTrace();
					throw new  RuntimeException("关闭资源失败！重试....");
				}				
			}
	
		
	}
	
}
