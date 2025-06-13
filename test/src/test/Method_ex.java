package test;

public class Method_ex {

	public static void main(String[] args) {
		
		System.out.println("main 시작");
		
		System.out.println("println() 시작");
		System.out.println(sum(1,4));
		System.out.println("println() 종료");
		
		
		System.out.println("main 종료");

	}
	
	public static int sum(int a, int b) {
		System.out.println("sum() 시작");
		System.out.println("sum() 종료");
		return a+b;
	}

}
