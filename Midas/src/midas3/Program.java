package midas3;

import java.util.Scanner;

class Program {
	static int n = 0;
	static int[][] array = null;
	static int[][] union = null;
	static int[] result = null;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		array = new int[n][n];
		union = new int[2][100];
		result = new int[100];
		int count = 0;
		int uindex = 0;
		int outputresult = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (array[i][j] == 1) {
					if (j - 1 >= 0 && array[i][j - 1] != 0) {
						array[i][j] = array[i][j - 1];
					} else if (i - 1 >= 0 && array[i - 1][j] != 0) {
						array[i][j] = array[i - 1][j];
					} else {
						count++;
						array[i][j] = count;
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (array[i][j] != 0) {
					if (j - 1 >= 0 && i - 1 >= 0 && array[i][j - 1] != 0 && array[i - 1][j] != 0) {
						if (array[i][j - 1] != array[i - 1][j]) {
							union[0][uindex] = array[i][j - 1];
							union[1][uindex] = array[i - 1][j];
							uindex++;
						}
					}
				}
			}
		}
		for (int k = 0; k < 100; k++) {
			if (union[0][k] != 0) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (array[i][j] == union[1][k]) {
							array[i][j] = union[0][k];
						}
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (array[i][j] != 0) {
					result[array[i][j]]++;
				}
			}
		}
		for (int i = 1; i < 100; i++) {
			if (result[i] != 0) {
				outputresult++;
			}
		}
		System.out.print(outputresult);
	}
}