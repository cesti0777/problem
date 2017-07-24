package problem.if_;

import java.util.Scanner;

public class p1546 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		try{
			float n = in.nextInt();
			float a = in.nextInt();
			float b = in.nextInt();
			float c = in.nextInt();
			float m = Math.max(c, Math.max(a, b));
			float result = 0;
			
			a = a/m*100;
			b = b/m*100;
			c = c/m*100;
			
			System.out.println(String.format("%.2f" , (a+b+c)/3));
			
		}finally {
			in.close();
			in = null;
		}
	}
}