package my.day14.b.accessmodifier;

import my.day13.b.inheritance2.Member;

public class Child3 extends Member {

	void test() {
		super.setId("superman");
		System.out.println(getId());
	}
	
}
