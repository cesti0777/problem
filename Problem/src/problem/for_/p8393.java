package problem.for_;

import java.util.Scanner;

public class p8393 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			int n = in.nextInt();
			int result = 0;
			
			for(int i = 1; i <= n ; i++){
				result += i;
			}
			System.out.println(result);
		}finally {
			in.close();
			in = null;
		}
	}
}
