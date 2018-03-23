package com.it.b;
/**
 * 斐波那契数列
 * @author Administrator
 *
 */
public class FeiBoShuLie {

	public static void main(String[] args) {
		int sum=getFeiBoNa(12);
		System.out.println(sum);
	}
	/**
	 * 使用方法递归，计算斐波那契数列
	 */
	 
	public static int getFeiBoNa(int month){
		if(month==1){
			return 1;
		}
		if(month==2){
			return 1;
		}
		return getFeiBoNa(month-1)+getFeiBoNa(month-2);
	}
	
}
