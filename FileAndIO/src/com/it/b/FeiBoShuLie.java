package com.it.b;
/**
 * 쳲���������
 * @author Administrator
 *
 */
public class FeiBoShuLie {

	public static void main(String[] args) {
		int sum=getFeiBoNa(12);
		System.out.println(sum);
	}
	/**
	 * ʹ�÷����ݹ飬����쳲���������
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
