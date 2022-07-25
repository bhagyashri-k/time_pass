package java_practice;

import java.math.BigDecimal;
import java.math.BigInteger;

public class AddTwoLongNum {

	public static void main(String[] args) {
		BigInteger n1 = new BigInteger("456789135879124");
		BigInteger n2 = new BigInteger("456789135879124");
		BigInteger sum = n1.add(n2);
		System.out.println(sum);
		
		BigDecimal n3 = new BigDecimal("4567891358791.24");
		BigDecimal n4 = new BigDecimal("4567891358791.24");
		BigDecimal sum1 = n3.add(n4);
		System.out.println(sum1);
		
//		It is not correct logic
		String s1 = "ABC";
		String s2 = new String("ABC");
//		System.out.println(s1==s2);
		System.out.println(s1.equalsIgnoreCase(s2));

	}

}
