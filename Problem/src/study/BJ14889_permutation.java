package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BJ14889_permutation {

	static int N;
	static int[][] S;
	static int min = Integer.MAX_VALUE;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = new int[20][20];
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				S[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < N / 2; i++) {
			arr[i] = 0;
		}
		for (int i = N / 2; i < N; i++) {
			arr[i] = 1;
		}

		do {
			calc();
			System.out.println(Arrays.toString(arr));

		} while (next_premutation(arr, N));
		System.out.println(min);
	}

	public static void calc() {
		List<Integer> A_list = new ArrayList<Integer>();
		List<Integer> B_list = new ArrayList<Integer>();
		int A_sum = 0;
		int B_sum = 0;

		for (int i = 0; i < N; i++) {
			if (arr[i] == 0)
				A_list.add(i);
			if (arr[i] == 1)
				B_list.add(i);
		}

		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N / 2; j++) {
				if (i == j)
					continue;
				A_sum += S[A_list.get(i)][A_list.get(j)];

				B_sum += S[B_list.get(i)][B_list.get(j)];

			}
		}
		min = Math.min(min, Math.abs(A_sum - B_sum));
	}

	public static boolean next_premutation(int[] arr, int n) {
		int i = n - 1;
		while (i > 0 && arr[i - 1] >= arr[i])
			i--;
		if (i <= 0)
			return false;
		int j = n - 1;

		while (arr[i - 1] >= arr[j])
			j--;
		int temp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = temp;

		j = n - 1;

		while (i < j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}

		return true;
	}
}