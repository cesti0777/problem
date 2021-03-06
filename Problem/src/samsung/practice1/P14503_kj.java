package samsung.practice1;

import java.util.Scanner;

public class P14503_kj {
	public static int n; // ����
	public static int m; // ����
	public static int r;
	public static int c;
	public static int d; // 0�� 1�� 2�� 3��
	public static int[][] map = new int[50][50];
	public static int[][] visited = new int[50][50];
	public static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		n = Integer.parseInt(line.split(" ")[0]);
		m = Integer.parseInt(line.split(" ")[1]);
		line = sc.nextLine();
		r = Integer.parseInt(line.split(" ")[0]);
		c = Integer.parseInt(line.split(" ")[1]);
		d = Integer.parseInt(line.split(" ")[2]);
		for (int i = 0; i < n; i++) {
			line = sc.nextLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(line.split(" ")[j]);
			}
		}

		// r�� �������� ���� ������ ĭ / c�� �������κ��� ������ ĭ
		// r�� ��, c�� ���� �ǹ�! (r,c)=(1,1)�̸� ��ǥ�� 1,1�� ����
		visited[r][c] = 1;
		count++;
		count++;
		// 0�� 1�� 2�� 3��
		// �� r-1 / �� c+1 / �� r+1 / �� c-1
		// ��-��-��-�� ������ ����
		// 0-3-2-1
		robot(d);
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				max = Math.max(max, visited[i][j]);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print("   " + visited[i][j]);
			}
			System.out.println();
		}
		System.out.println(max);
	}

	public static void robot(int d) {
		switch (d) {
		case 0: // ��->��
			if (visited[r][c - 1] == 0 && map[r][c - 1] == 0) {
				c--;
				visited[r][c] = count;
				count++;
				d = 3;
				robot(d);
			} else if (visited[r + 1][c] == 0 && map[r + 1][c] == 0) {
				d = 3;
				robot(d);
			} else if (visited[r][c + 1] == 0 && map[r][c + 1] == 0) {
				d = 2;
				robot(d);
			} else if (visited[r - 1][c] == 0 && map[r - 1][c] == 0) {
				d = 1;
				robot(d);
			} else if (map[r + 1][c] == 0) {
				r++;
				robot(d);
			} else {
				break;
			}
			break;
		case 1: // ��->��
			if (visited[r - 1][c] == 0 && map[r - 1][c] == 0) {
				r--;
				visited[r][c] = count;
				count++;
				d = 0;
				robot(d);
			} else if (visited[r][c - 1] == 0 && map[r][c - 1] == 0) {
				d = 0;
				robot(d);
			} else if (visited[r + 1][c] == 0 && map[r + 1][c] == 0) {
				d = 3;
				robot(d);
			} else if (visited[r][c + 1] == 0 && map[r][c + 1] == 0) {
				d = 2;
				robot(d);
			} else if (map[r][c - 1] == 0) {
				c--;
				robot(d);
			} else {
				break;
			}
			break;
		case 2:// ��->��
			if (visited[r][c + 1] == 0 && map[r][c + 1] == 0) {
				c++;
				visited[r][c] = count;
				count++;
				d = 1;
				robot(d);
			} else if (visited[r - 1][c] == 0 && map[r - 1][c] == 0) {
				d = 1;
				robot(d);
			} else if (visited[r][c - 1] == 0 && map[r][c - 1] == 0) {
				d = 0;
				robot(d);
			} else if (visited[r + 1][c] == 0 && map[r + 1][c] == 0) {
				d = 3;
				robot(d);
			} else if (map[r - 1][c] == 0) {
				r--;
				robot(d);
			} else {
				break;
			}
			break;
		case 3:// ��->��
			if (visited[r + 1][c] == 0 && map[r + 1][c] == 0) {
				r++;
				visited[r][c] = count;
				count++;
				d = 2;
				robot(d);
			} else if (visited[r][c + 1] == 0 && map[r][c + 1] == 0) {
				d = 2;
				robot(d);
			} else if (visited[r - 1][c] == 0 && map[r - 1][c] == 0) {
				d = 1;
				robot(d);
			} else if (visited[r][c - 1] == 0 && map[r][c - 1] == 0) {
				d = 0;
				robot(d);
			} else if (map[r][c + 1] == 0) {
				c++;
				robot(d);
			} else {
				break;
			}
			break;
		}
	}
}