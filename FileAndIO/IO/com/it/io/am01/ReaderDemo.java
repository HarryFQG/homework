package com.it.io.am01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

/**
 * 字符输入文件：
 * 			读取文本文件，记事本儿能打开的文件，并且人能看得懂。
 * 			java.io.Reader
 * 专门读取文本文件:
 * 		
 * 
 * 		读取方法：read():
 * 			int read():读取一个字符
 * 			int read(char[] c):读取字符数组
 * 		子类：FileReader
 * 			构造方法：绑定数据源
 * 				File file;
 * 				String path;
 * @author Administrator
 *
 */
public class ReaderDemo {

	@Test
	public void read0() throws IOException{
		FileReader fr=new FileReader("e:\\tomcat\\fileobject\\hellow.txt");
		int len =0;
		while((len=fr.read())!=-1){
			System.out.println((char)len);
		}
		
		fr.close();
	}
	
	
	@Test
	public void read1() throws IOException{
		FileReader fr=new FileReader("e:\\tomcat\\fileobject\\hellow.txt");
	
		char[] c = new char[1024];
		int len=0;		
		while((len=fr.read(c))!=-1){
			System.out.println(new String(c,0,len));
		}
		fr.close();
	}
	
	
	
	
	
	
}










