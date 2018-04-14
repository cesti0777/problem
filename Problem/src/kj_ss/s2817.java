package kj_ss;

import java.util.Scanner;

public class s2817 {
	static int n;
	static int k;
	static int t;
	static int[] arr;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			n = sc.nextInt();
			k = sc.nextInt();
			count = 0;
			arr = new int[n];
			int[] temp = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			for (int k = 1; k <= n; k++) {
				run(temp, 0, 0, k);
			}
			System.out.println("#" + i + " " + count);
		}
	}

	public static void run(int[] str, int start, int index, int cnt) {
		// start : ������ �ε���
		// index : ���� �ε���
		// cnt : � ������
		// str : ������

		if (cnt == 0) { // �迭���� ������
			sum(str, start);
			return;
		}
		if (index == n) { // �迭�� ��� �ε����� ��Ծ�����
			return;
		} else {
			str[start] = index; // ������ start��°�� index�� �ϳ� �ִ´�
			run(str, start + 1, index + 1, cnt - 1); // ���� ���
			run(str, start, index + 1, cnt); // �Ȼ��� ���
		}
	}

	public static void sum(int[] str, int start) {
		int temp = 0;
		for (int i = 0; i < start; i++) {
			temp += arr[str[i]];
		}
		if (temp == k)
			count++;
	}

	public static void print(int[] comArr, int idx) {

		for (int i = 0; i < idx; i++) {
			// System.out.print(nums[comArr[i]] + " ");
			System.out.print(comArr[i] + " ");
		}
		System.out.println();
	}

}