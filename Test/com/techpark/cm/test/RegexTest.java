package com.techpark.cm.test;

import junit.framework.TestCase;

public class RegexTest extends TestCase {

	public void testNum(){
		String t = "1111111111111a";
		System.out.println(t.matches("^[0-9]*$"));
	}
	
	public void testPassword(){
		String t= "111123";
		//System.out.println(t.matches("([0-9].*([a-zA-Z].*[!$#%*@]|[!$#%*@].*[a-zA-Z])|[a-zA-Z].*([0-9].*[!$#%@*]|[!$#%@*].*[0-9])|[!$#%@*].*([0-9].*[a-zA-Z]|[a-zA-Z].*[0-9]))"));
		System.out.println(t.matches("^[\\w]{6,}$"));
	}
	
	public void testTel(){
		String t = "18728866578";
		System.out.println(t.matches("^[1][3-8]+\\d{9}"));
	}
	
	public void testImg(){
		String t="11.jpg";
		System.out.println(t.matches("\\w+\\.(jpg|gif|bmp|png)"));
	}
}
