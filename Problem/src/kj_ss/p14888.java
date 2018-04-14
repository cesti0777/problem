package kj_ss;

import java.util.Scanner;

public class p14888 {
	static int n;
	static int plus;
	static int minus;
	static int gop;
	static int nanu;
	static int[] array = new int[12];
	static int max;
	static int min;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		for (int i = 0; i < n; i++) {
			array[i] = in.nextInt();
		}

		plus = in.nextInt();
		minus = in.nextInt();
		gop = in.nextInt();
		nanu = in.nextInt();

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		run(plus, minus, gop, nanu, 0, array[0]);
		System.out.println(max);
		System.out.println(min);
	}

	public static void run(int ptemp, int mtemp, int gtemp, int ntemp, int num, int now) {
		if (num + 1 < n) {
			if (ptemp > 0) { // 더하기 횟수가 남아있으면 또 돌린다
				run(ptemp - 1, mtemp, gtemp, ntemp, num + 1, now + array[num + 1]);
			}
			if (mtemp > 0)
				run(ptemp, mtemp - 1, gtemp, ntemp, num + 1, now - array[num + 1]);
			if (gtemp > 0)
				run(ptemp, mtemp, gtemp - 1, ntemp, num + 1, now * array[num + 1]);
			if (ntemp > 0) {
				if (now > 0)
					run(ptemp, mtemp, gtemp, ntemp - 1, num + 1, now / array[num + 1]);
				else
					run(ptemp, mtemp, gtemp, ntemp - 1, num + 1, -(Math.abs(now) / array[num + 1]));
			}
		} else {
			if (now > max) {
				max = now;
			}
			if (now < min) {
				min = now;
			}
			return;
		}
	}
}
