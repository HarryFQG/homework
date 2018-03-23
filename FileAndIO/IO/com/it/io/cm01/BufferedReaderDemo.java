package com.it.io.cm01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

/**
 * 字符输入流：
 * 		java.io.BufferedReader 继承Reader
 * 		读取功能：read():单个字符，字符数组
 * 
 * 		构造函数：
 * 			BufferedReader(Reader r);//可以是任意的字符流FileReader InputStreamReader
 * 		
 * 		特有的方法：
 * 			String readLine()读取一行数据\r\n	
 * 		  小特点：
 * 				获取内容的方法一般都有返回值
 * 				int类型没有返回值为负数
 * 				引用类型找不到为null
 * 				boolean类型找不到为false
 * 
 * @author Administrator
 *
 */
public class BufferedReaderDemo {
	@Test
	public void bufferedReader() throws IOException{
		
		BufferedReader br=new BufferedReader(new FileReader("e:\\tomcat\\fileobject\\hellow.txt"));
		//自己特有方法读取：
		String len=null;
		int i=0;
		while((len=br.readLine())!=null){
			i++;
			System.out.println("特有方法："+i+"行,"+len);
		}
		/*int len=0;
		char[] c=new char[10];
		while((len=br.read(c))!=-1){
			System.out.print(new String(c,0,len));
			
		}*/		
		
		
		br.close();
		
		
	}
	
}
