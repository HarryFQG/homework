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
 * ���϶���Properties�࣬�̳�Hashtable,ʵ��Map�ӿ�
 * ���Ժ�IO������ʹ�ã�ʵ�����ݵĳ־û��洢
 * 
 * @author Administrator
 *
 */
public class PropertiesDemo {

	/**
	 * ʹ��Properties���ϣ��洢��ֵ��
	 * setProperty��ͬ��Map�ӿڵ�put
	 * setProperty(String key,String value);
	 * ͨ����ȡֵ��getProperty(String  key);
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
		/*��������		 */
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
	 * Properties���ϵ����й���:
	 *		 load(InputStream in) 
	 * 		load(Reader r)
	 * 		����������ֽ��������ַ���
	 * 		�������ȡ�ļ��еļ�ֵ�ԣ����漯��
	 * @throws IOException 
	 */
	@Test
	public void readPro() throws IOException{
		Properties p=new Properties();
		FileReader fr=new FileReader("e:\\tomcat\\fileobject\\pro.properties");
		//���ü��Ϸ���load,�����ַ�������������
		p.load(fr);
		fr.close();
		System.out.println(p);
		
	}
	
	/**
	 * Properties���ϵ����й���:
	 *		 store(OutputStream out) 
	 * 		store(Writer w)
	 * 		����������ֽ��������ַ���
	 * 		�������еļ�ֵ�ԣ�д���ļ��б���
	 * @throws IOException 
	 */
	@Test
	public void storePro() throws IOException{
		Properties p=new Properties();
		p.setProperty("name", "����");
		p.setProperty("age","31" );
		p.setProperty("email","345@qq.com" );
		FileWriter fw=new FileWriter("e:\\tomcat\\fileobject\\pro.properties");
		//����ֵ�Դ���ļ���ʹ�ü��ϵ�store�����������ַ�����������ڶ�����������ص�ԭ��
		p.store(fw, "Random");
		
		fw.close();
	}
	
	
	
	
	
	
}
