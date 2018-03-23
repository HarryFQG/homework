package com.it.io.am01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;

/**
 * 集合对象Properties类，继承Hashtable,实现Map接口
 * 可以和IO对象结合使用，实现数据的持久化存储
 * 
 * @author Administrator
 *
 */
public class PropertiesDemo {

	/**
	 * 使用Properties集合，存储键值对
	 * setProperty等同于Map接口的put
	 * setProperty(String key,String value);
	 * 通过键取值，getProperty(String  key);
	 */
	@Test
	public void peoperties(){
		Properties p=new Properties();
		p.setProperty("a","1");
		p.setProperty("b", "2");
		p.setProperty("c", "3");
		System.out.println(p);
		String value=p.getProperty("a");
		System.out.println(value);
		/*遍历集合		 */
	Set<Entry<Object, Object>> entrySet = p.entrySet();
		Iterator iter=entrySet.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
			
		}
		Set<String> set=p.stringPropertyNames();
		for(String key : set){
			System.out.println(key+"..."+p.getProperty(key));
			
		}
		
	}
	
	
	/**
	 * Properties集合的特有工能:
	 *		 load(InputStream in) 
	 * 		load(Reader r)
	 * 		传递任意的字节流或者字符流
	 * 		流对象读取文件中的键值对，保存集合
	 * @throws IOException 
	 */
	@Test
	public void readPro() throws IOException{
		Properties p=new Properties();
		FileReader fr=new FileReader("e:\\tomcat\\fileobject\\pro.properties");
		//调用集合方法load,传递字符串到输入流中
		p.load(fr);
		fr.close();
		System.out.println(p);
		
	}
	
	/**
	 * Properties集合的特有工能:
	 *		 store(OutputStream out) 
	 * 		store(Writer w)
	 * 		接受任意的字节流或者字符流
	 * 		将集合中的键值对，写会文件中保存
	 * @throws IOException 
	 */
	@Test
	public void storePro() throws IOException{
		Properties p=new Properties();
		p.setProperty("name", "李四");
		p.setProperty("age","31" );
		p.setProperty("email","345@qq.com" );
		FileWriter fw=new FileWriter("e:\\tomcat\\fileobject\\pro.properties");
		//将键值对存回文件，使用集合的store方法，传递字符串输出流。第二个参数：存回的原因
		p.store(fw, "Random");
		
		fw.close();
	}
	
	
	
	
	
	
}
