package samsung.practice1;

import java.util.Scanner;

public class P14501_kj {
	static int n; // �����
	static int[] day = new int[16]; // [�����][�ҿ���]
	static int[] money = new int[16];
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			day[i] = sc.nextInt();
			money[i] = sc.nextInt();
		}
		for (int i = 1; i <= n; i++){
			cal(i, 0);
		}
		System.out.println(max);
	}

	public static void cal(int nowday, int sum) {
		if (nowday <= n) {
			if (nowday + day[nowday] > n + 1) {
				max = Math.max(max, sum);
				return;
			} else {
				max = Math.max(max, sum + money[nowday]);
				cal(nowday + day[nowday], sum + money[nowday]);
			}
			cal(nowday + 1, sum);
		}
	}
}