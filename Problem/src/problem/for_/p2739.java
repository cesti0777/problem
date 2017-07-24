package problem.for_;

import java.util.Scanner;

public class p2739 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			int n = in.nextInt();
			for(int i = 1; i < 10 ; i++){
				System.out.println(n + " * " + i + " = " + n * i);
			}
		}finally {
			in.close();
			in = null;
		}
	}
}