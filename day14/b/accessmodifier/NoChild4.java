package my.day14.b.accessmodifier;

import my.day13.b.inheritance2.Member;

public class NoChild4 {

	void test() {
		Member mbr = new Member();
		mbr.setId("hongkd");
		System.out.println(mbr.getId());
	}
	
}
