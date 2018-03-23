package com.it.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;


/**
 * 从一个给定的(a.txt)文本之中查找，出指定的字符串
 * @author Administrator
 *
 */
public class MyFindStr {

	
	@Test
	public void testFind(){
		
		try {
			int i = findStr();
			System.out.println("个数："+i);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public int findStr() throws Exception{
		FileReader fr=new FileReader("E:\\Tomcat\\fileObject\\b.txt");
		BufferedReader brf=new BufferedReader(fr);
		String str=null;
		int count=0;
		int j=0;
		
		while((str=brf.readLine())!=null){
			System.out.println("第"+(++j)+"行");
			char[] c=str.toCharArray();
			for(int i=0;i<c.length;i++){
				if(c[i]=='中'){
					System.out.println("i="+i);
					count++;
				}
			}
			
			
		}
		brf.close();
		
		return count;
	}
	
	
	
}
