package io.day3;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 7104392080727611056L;
	private String name;
	private int age;
	private String address;
	
	public Student() {}

	// 파라미터가 있는 생성자
	public Student(String name, int age, String address) {
		super();	// 생략가능
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	
	
	
}
