package problem.for_;

import java.util.Scanner;

public class p2439 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			int n = in.nextInt();
			for (int i = 0; i < n; i++) {
				for (int j = i; j < n - 1; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		} finally {
			in.close();
			in = null;
		}
	}
}
