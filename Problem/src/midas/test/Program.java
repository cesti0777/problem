package midas.test;

import java.util.Scanner;

public class Program {
	static int n = 0;
	static int[][] arr = null;
	static int[][] union = null;
	static int[] result = null;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		arr = new int[n][n];
		union = new int[2][100];
		result = new int[100];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = in.nextInt();
			}
		}

		int cnt = 0;
		int u = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					if (j - 1 >= 0 && arr[i][j - 1] != 0) {
						arr[i][j] = arr[i][j - 1];
					} else if (i - 1 >= 0 && arr[i - 1][j] != 0) {
						arr[i][j] = arr[i - 1][j];
					} else {
						cnt++;
						arr[i][j] = cnt;
					}
				}
			}
		}

//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				if (arr[i][j] / 10 < 1) {
//					System.out.print(" " + arr[i][j]);
//					System.out.print(" ");
//				} else {
//					System.out.print(arr[i][j]);
//					System.out.print(" ");
//				}
//
//			}
//			System.out.println();
//		}
//		System.out.println();
//
//		System.out.println(cnt);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] != 0) {
					if (j - 1 >= 0 && i - 1 >= 0 && arr[i][j - 1] != 0 && arr[i - 1][j] != 0) {
						if (arr[i][j - 1] != arr[i - 1][j]) {
							union[0][u] = arr[i][j - 1];
							union[1][u] = arr[i - 1][j];
							u++;
						}
					}
				}
			}
		}
		for (int a = 0; a < 100; a++) {
			if (union[0][a] != 0) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (arr[i][j] == union[1][a]) {
							arr[i][j] = union[0][a];
						}
					}
				}
			}
		}

//		for (int a = 0; a < 50; a++) {
//			System.out.print(union[0][a]);
//			System.out.print(" ");
//			System.out.print(union[1][a]);
//			System.out.println();
//		}

//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				if (arr[i][j] / 10 < 1) {
//					System.out.print(" " + arr[i][j]);
//					System.out.print(" ");
//				} else {
//					System.out.print(arr[i][j]);
//					System.out.print(" ");
//				}
//
//			}
//			System.out.println();
//		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] != 0) {
					result[arr[i][j]]++;
				}
			}
		}

		int totalR = 0;
		for (int i = 1; i < 100; i++) {
			if (result[i] != 0) {
				totalR++;
			}
		}

		System.out.println(totalR);
	}
}
