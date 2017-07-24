package problem.for_;

import java.util.Scanner;

public class p2741 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		try{
			for(int i=0; i<n; i++){
				System.out.println(i+1);
			}
		}finally {
			in.close();
			in = null;
		}
	}
}