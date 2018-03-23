package com.it.b;

import org.junit.Test;

/**
 * 方法的递归的使用
 * 		方法自己调用自己
 * 适用于，方法中运算的主体不变，但是运行的时候，参数会发生改变。
 *注意：一定要有出口，不然就堆溢出；第二递归的次数不能过多；构造器禁止递归
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
	/*计算:1+2+....+n
	 * 计算规律：n+(n-1)+(n-2)+....+1
	*/
	public static int DiGui(int n){
		if(n==1){
			return n;
		}
		return n+DiGui(n-1);
	}
	/*计算:1*2*....*n
	 * 计算规律：n*(n-1)*(n-2)*....*1
	*/
	public static int DiGui1(int n){
		if(n==1){
			return n;
		}
		return n*DiGui(n-1);
	}
}
