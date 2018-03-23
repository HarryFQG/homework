package com.it.a;

import java.io.File;

public class FileDemo01 {
	public static void main(String[] args) {
		//File静态成员变量
		//
		String str= File.pathSeparator;
		System.out.println(str);				//window的目录分隔符是一个；，linux是一个：。
		String str1=File.separator;
		System.out.println(str1);			//window的目录名称分隔符是一个\，linux是一个/。
		
		
	}
}
