package com.it.io.am02;

import java.io.Serializable;

/**
 * 对象的序列化与反序列化
 * 		实体类
 * @author Administrator
 *
 */
public class Person implements Serializable{
	private String name;
	private  int age;
	/*private  transient int age;transient 关键字阻止该属性被序列化*/
	
	static final long serialVersionUID = 42L;/*自定义序列号：固定写法，不能改变，唯一自定义的就是后面的数字。*/
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
