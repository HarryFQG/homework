package com.it.b;

import org.junit.Test;

/**
 * �����ĵݹ��ʹ��
 * 		�����Լ������Լ�
 * �����ڣ���������������岻�䣬�������е�ʱ�򣬲����ᷢ���ı䡣
 *ע�⣺һ��Ҫ�г��ڣ���Ȼ�Ͷ�������ڶ��ݹ�Ĵ������ܹ��ࣻ��������ֹ�ݹ�
 * @author Administrator
 *
 */
public class FileDemo02DiGuiDemo {

	public static void main(String[] args) {
		int i=DiGui(100);
		System.out.println(i);
		int inc=DiGui1(100);
		System.out.println(inc);
		
	}
	/*����:1+2+....+n
	 * ������ɣ�n+(n-1)+(n-2)+....+1
	*/
	public static int DiGui(int n){
		if(n==1){
			return n;
		}
		return n+DiGui(n-1);
	}
	/*����:1*2*....*n
	 * ������ɣ�n*(n-1)*(n-2)*....*1
	*/
	public static int DiGui1(int n){
		if(n==1){
			return n;
		}
		return n*DiGui(n-1);
	}
}
