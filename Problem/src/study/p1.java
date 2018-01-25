package study;

import java.util.Scanner;

public class p1 {

	static int testCnt;
	static int answer;
	static int n, m;
	static int u, t;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		testCnt = in.nextInt();

		for (int testCase = 1; testCase <= testCnt; testCase++) {

			init();

			n = in.nextInt();
			m = in.nextInt();

			execute();

			System.out.println(n + " " + m);
			System.out.println("#" + testCase + " " + u + " " + t);
		}
	}

	public static void init() {
		n = 0;
		m = 0;
		u = 0;
		t = 0;
	}

	public static void execute() {
		t = m;
		if (2 * t == n) {
			return;
		}

		while (true) {
			t -= 2;
			u += 2;
			if (2 * t + u == n) {
				return;
			}
		}
	}
}