package com.it.io.am02;

import java.io.Serializable;

/**
 * ��������л��뷴���л�
 * 		ʵ����
 * @author Administrator
 *
 */
public class Person implements Serializable{
	private String name;
	private  int age;
	/*private  transient int age;transient �ؼ�����ֹ�����Ա����л�*/
	
	static final long serialVersionUID = 42L;/*�Զ������кţ��̶�д�������ܸı䣬Ψһ�Զ���ľ��Ǻ�������֡�*/
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	
	
}
