package com.testNG.practice;

import org.testng.annotations.Test;

public class Annotations2 extends Annotations {
	@Test(groups="regression")
	public void annotations2_test1() {
		System.out.println("@test executing annotations2 test1");
	}
	@Test(groups="smoke")
	public void annotations2_test2() {
	System.out.println("@test executing annotations2 test2");
}
}
