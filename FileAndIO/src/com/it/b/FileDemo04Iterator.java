package com.it.b;

import java.io.File;

import org.junit.Test;

import com.it.aUtil.MyFileFilter2;

/**
 * ����Ŀ¼����ȡĿ¼�µ�����.txt�ļ�
 * �����༶Ŀ¼��ʹ�õݹ�ʵ��
 * �����Ĺ����У�ʹ�ù�����
 * @author Administrator
 */
public class FileDemo04Iterator {
	
	@Test
	public void test(){
		File file=new File("e:\\tomcat\\fileobject\\");
		getTxtAll(file);
	} 
	
	
	/**
	 * ���巽����ʵ��ָ������Ŀ¼
	 * ��ȡĿ¼�е����е��ı��ļ�(.txt)
	 */
	public void getTxtAll(File file){
		//����File���󷽷�listFiles()��ȡ�����������
		File[] fileArr=file.listFiles(new MyFileFilter2());
		for(File f:fileArr){
			//��f·�������ж��ǲ����ļ���
			if(f.isDirectory()){
				//���еݹ�
				getTxtAll(f);
			}else{
				System.out.println("�ļ���"+f);
				
			}
		}
		
	}
	
	
	
	
	
}
