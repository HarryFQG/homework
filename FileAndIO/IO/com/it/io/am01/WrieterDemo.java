package com.it.io.am01;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * 	字符输出流
 * 			java.io.writer 所有字符输出流的父类
 * 		局限性：只能写文本文件，不能写图片，音乐，视频
 * @author Administrator
 *		写方法：：
 *			write(int c):写一个字符
 *			write(char[] c):写字符数组
 *			write(char[] c，int len)：写字符数组,开始索引；
 *			write(String str )：写字符串；
 *	Writer 类的子类对象	FileWriter
 *		File类对象
 *		String 文件名
 *
 *		注意：字符输出流写数据时，须使用刷新功能.而且是，写一次刷新一次
 */
public class WrieterDemo {

	@Test
	public void write0() throws IOException{
		
		FileWriter fw=new FileWriter("e:\\tomcat\\fileobject\\hellow.txt");
		//写的方法。
		fw.write(100);
		fw.append("\nappend1");
		fw.flush();
		
		/*写一个char数组*/
		char[] c={'A','B','C','X'};
		fw.write(c);
		fw.flush();
		
		/*写数组的一部分*/
		fw.write(c, 1, 2);		
		fw.flush();
		
		/*写入字符串*/
		fw.write(new String (c));
		fw.flush();
	
		fw.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
