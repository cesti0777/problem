package midas1;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String first = sc.nextLine();
		int n = Integer.parseInt(first.split(" ")[0]);
		int m = Integer.parseInt(first.split(" ")[1]);
		int k = Integer.parseInt(first.split(" ")[2]);
		int result;
		if(n <= k) { 
			result = (int)(n+m-k)/3;
		}
		else { 
			result = n/2;
		}
		System.out.print(result);
	}

}