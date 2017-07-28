package problem.fun;

import java.util.ArrayList;
import java.util.Scanner;

public class p1065 {
	public static boolean hanNum(int n) {
		ArrayList<Integer> arrN = new ArrayList<>();
		while (true) {
			arrN.add(n % 10);
			n = n / 10;
			if (n == 0) {
				break;
			}
		}
		if (arrN.size() == 1) {
			return true;
		} else if (arrN.size() == 2) {
			return true;
		} else if (arrN.size() == 3) {
			if (arrN.get(0) - arrN.get(1) == arrN.get(1) - arrN.get(2)) {
				return true;
			}
		} else {
			if (arrN.get(0) - arrN.get(1) == arrN.get(1) - arrN.get(2)
					&& arrN.get(1) - arrN.get(2) == arrN.get(2) - arrN.get(3)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		try {
			int n = in.nextInt();
			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				if (hanNum(i)) {
					cnt++;
				}
			}
			System.out.println(cnt);
		} finally {
			in.close();
			in = null;
		}
	}
}
