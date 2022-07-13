package com.pack;

public class Testing {
	
private Testing(String name)
	{
		System.out.println(name);
	}
	public void addOne(int a, int b)
	{
		System.out.println("Adding two integer");
		System.out.println(a+b);
	}
	public static String sumName(String name1)
	{
		Testing t = new Testing("Bhagyashri");
		return name1;
		
	}
	public static void main(String[] args) {
		
	}
	public static void sum() {
		// TODO Auto-generated method stub
		
	}

}
