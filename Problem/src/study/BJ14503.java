package study;

import java.util.Scanner;

public class BJ14503 {
	static int map[][] = new int[50][50];
	static boolean visited[][] = new boolean[50][50];
	static int n, m;// ���μ���
	static int r, c;// ��ġ
	static int d;// ����
	static int no = 0;
	static int cnt = 1;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		m = in.nextInt();
		r = in.nextInt();
		c = in.nextInt();
		d = in.nextInt();
		visited[r][c] = true;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = in.nextInt();
			}
		}

		while (true) {
			if (no == 4) {// �׹��� ��� ������ ����
				switch (d) {
				case 0: // ��(��)
					if (map[r + 1][c] == 0) {
						r++;
						no = 0;
						break;
					} else {
						System.out.println(cnt);
						return;
					}
				case 1: // ��(��)
					if (map[r][c - 1] == 0) {
						c--;
						no = 0;
						break;
					} else {
						System.out.println(cnt);
						return;
					}
				case 2: // ��(��)
					if (map[r - 1][c] == 0) {
						r--;
						no = 0;
						break;
					} else {
						System.out.println(cnt);
						return;
					}
				case 3: // ��(��)
					if (map[r][c + 1] == 0) {					
						c++;
						no = 0;
						break;					
					} else {
						System.out.println(cnt);
						return;
					}
				}
			} else {
				switch (d) {
				case 0: // ��(��)
					if (visited[r][c - 1] != true && map[r][c - 1] == 0) {
						d = 3;
						c--;
						visited[r][c] = true;
						no = 0;
						cnt++;
						break;
					} else {
						d = 3;
						break;
					}
				case 1: // ��(��)
					if (visited[r - 1][c] != true && map[r - 1][c] == 0) {
						d = 0;
						r--;
						visited[r][c] = true;
						no = 0;
						cnt++;
						break;
					} else {
						d = 0;
						no++;
						break;
					}
				case 2: // ��(��)
					if (visited[r][c + 1] != true && map[r][c + 1] == 0) {
						d = 1;
						c++;
						visited[r][c] = true;
						no = 0;
						cnt++;
						break;
					} else {
						d = 1;
						no++;
						break;
					}
				case 3: // ��(��)
					if (visited[r + 1][c] != true && map[r + 1][c] == 0) {
						d = 2;
						r++;
						visited[r][c] = true;
						no = 0;
						cnt++;
						break;
					} else {
						d = 2;
						no++;
						break;
					}
				}
			}
		}
	}
}