package practice;

public class DemoJav {
	final static int x;
//	final int y;
	static {
		x=20;
		System.out.println(x);
	}
	public DemoJav( int x) {
//		this.x=x;
//		this.y=y;
		
	}

	public static void main(String[] args) {
		DemoJav obj = new DemoJav(10);
		System.out.println(obj.x);

	}

}
