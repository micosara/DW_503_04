package test;

public class Casting {

	public static void main(String[] args) {
		int i = (int)(123f);
		int j = (int)(123456873748474f);
		
		byte b = (byte)(478346);
		
		System.out.println(i);
		System.out.println(j);
		System.out.println(b);
		
		System.out.println(Byte.MAX_VALUE);
	}

}
