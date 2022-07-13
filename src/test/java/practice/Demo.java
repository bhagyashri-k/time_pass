package practice;

public class Demo {
	public static void main(String[] args) {

		String str="?1,50,888";

		String str1=	str.replaceAll("[^a-zA-Z0-9]", "");

		System.out.println(str1);
	}
}
