package com.it.io.cm01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;
/**
 * 字符输出流缓冲流
 * java.io.BufferedWriter继承自Writer
 * 写入方法write()单个字符，字符数组，字符串
 * 构造方法：
 * 		BufferedWriter(Writer out) ；任意Writer父类的方法
		BufferedWriter(Writer out, int sz)； 

 * @author Administrator
 *
 */
public class BufferedWriterDemo {
	
	@Test
	public void bufferWriter() throws IOException{
		BufferedWriter bw=new BufferedWriter(new FileWriter("e:\\tomcat\\fileobject\\hellow.txt"));
		//写字符串
		bw.write("床前明月光，疑是地上霜。举头望明月，低头思故乡。");
		bw.flush();
		
		//写字符数组
		char[] c="哈希表是一种数据结构".toCharArray();
		bw.write(c);
		bw.flush();
		
		bw.write(122);

		bw.flush();
		bw.close();
	}
	
	
	
	
}



