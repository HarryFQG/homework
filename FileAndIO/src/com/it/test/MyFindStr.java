package com.it.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;


/**
 * ��һ��������(a.txt)�ı�֮�в��ң���ָ�����ַ���
 * @author Administrator
 *
 */
public class MyFindStr {

	
	@Test
	public void testFind(){
		
		try {
			int i = findStr();
			System.out.println("������"+i);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
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
			System.out.println("��"+(++j)+"��");
			char[] c=str.toCharArray();
			for(int i=0;i<c.length;i++){
				if(c[i]=='��'){
					System.out.println("i="+i);
					count++;
				}
			}
			
			
		}
		brf.close();
		
		return count;
	}
	
	
	
}
