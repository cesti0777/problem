package problem.for_;

import java.util.Scanner;

public class p11720 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		try{
			int n1 = Integer.parseInt(in.nextLine());
			String n2 = in.nextLine();
			int result = 0;
			
			for(int i = 0; i < n1 ; i++){
				result += Character.getNumericValue(n2.charAt(i));
			}
			System.out.println(result);
		}finally {
			in.close();
			in = null;
		}
	}
}
