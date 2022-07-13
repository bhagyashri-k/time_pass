package com.vtiger.generic;

public class Digit123 {

	public static void main(String[] args) {
		int num =121, sum=0, rem=0;
		while(num>0)
		{
			 rem=num%10;
			sum=sum+rem;
			num=num/10;
		}
		
		System.out.println("Sum of 121 "+sum);
	}

}
