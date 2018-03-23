package com.it.a;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * File类的创建和删除
 * 			文件或者目录
 * @author Feng
 *
 */


public class FileDemo03CreateOrDelete {

	/**
	 * File创建文件的功能
	 * boolean CreateNameFile();
	 * 文件类型不限，也就是后缀（txt,doc,ppt....）
	 * 创建的文件路径和文件名，在File构造方法中给出的
	 * @throws IOException 
	 * 注意：如果文件已经存在，就不再创建。而且，不能创建文件夹，只能创建文件。	
	 *  */	
	@Test
	public void createFile() throws IOException{	
		File file=new File("E:\\tomcat\\fileObject\\a727.txt");
		System.out.println(file+",\t"+file.exists());//检查文件是否存在
		boolean flag = file.createNewFile();
		System.out.println("是否创键成功："+flag);
	}
	/**
	 * File创建文件夹功能
	 * boolean mkdirs();//创建多级文件夹,这个覆盖了mkdir()功能。
	 * 创建的文件夹路径和文件夹名，在File构造方法中给出的
	 *如果文件夹已经存在，不在创建
	 */	
	@Test	
	public void createFile2(){
		File file=new File("E:\\tomcat\\fileobject\\newFile\\a");
		System.out.println(file+"\t,"+file.exists());//检查文件夹是否存在
		boolean flag = file.mkdirs();
		System.out.println("是否创键成功："+flag);
		
	}
	//---------------------------------------------------------------------------------------------
	/**
	 * File类的删除功能
	 * boolean delete()
	 * 删除的文件或者文件夹，在File构造方法中给出
	 * 删除成功返回true，删除失败返回false
	 * 如果文件打开，或者不存在返回false,而且删除的东西不会放回回收站。
	 * 删除有风险，运行需谨慎。
	 */
	
	/**
	 * 删除文件夹
	 */
	@Test
	public void deleteFile1(){
		File file=new File("E:\\tomcat\\fileobject\\newFile\\a");
		boolean flag = file.delete();
		System.out.println("是否删除成功："+flag);
	}
	
	/**
	 * 删除文件
	 */
	@Test
	public void deleteFile2(){
		File file=new File("E:\\tomcat\\fileobject\\a727.txt");
		boolean flag = file.delete();
		System.out.println("是否删除成功："+flag);
	}
	
	
	
	
	
	
	
}
