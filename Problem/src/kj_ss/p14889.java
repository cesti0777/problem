package kj_ss;

import java.util.Scanner;

public class p14889 {
	static int n;
	static int[][] all = new int[101][101];
	static int min = Integer.MAX_VALUE;
	static int[] arr;
	static int sumS = 0;
	static int sumL = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				all[i][j] = sc.nextInt();
			}
		}
		arr = new int[101];
		run(arr, 0, n / 2, 0);
		System.out.println(min);
	}

	public static void run(int[] str, int index, int count, int now) {
		// index : 조합통 번호
		// count : 뽑을 개수
		// now : 배열 번호
		if (count == 0) { // 다 뽑은 경우
			cal(str, index, team(str, index));
			return;
		}
		if (now == n / 2) { // 조합통 까지 왔으면
			return;
		}
		str[index] = now;
		run(str, index + 1, count - 1, now + 1);
		run(str, index, count, now + 1);
	}

	public static int[] team(int[] str, int index) {
		int[] other = new int[101];
		boolean[] check = new boolean[n];
		for (int i = 0; i < index; i++) {
			check[str[i]] = true;
		}
		int otherIdx = 0;
		for (int i = 0; i < n; i++) {
			if (check[i] == false) {
				other[otherIdx] = i;
				otherIdx++;
			}
		}
		return other;
	}

	public static void cal(int[] str, int index, int[] str2) {
		for (int i = 0; i < n / 2; i++) {
			if (str[i] == i) {
				for (int j = 0; j < n / 2; j++) {
					if (str[j] == j && i != j) {
						sumS += all[str[i]][str[j]];
					}
				}
			}
		}

		for (int i = 0; i < n / 2; i++) {
			if (str2[i] == i) {
				for (int j = 0; j < n / 2; j++) {
					if (str2[j] == j && i != j) {
						sumL += all[str2[i]][str2[j]];
						System.out.println(sumL);
					}
				}
			}
		}
		if (Math.abs(sumS - sumL) < min)
			min = Math.abs(sumS - sumL);
	}

}
