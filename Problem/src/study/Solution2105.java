package study;

import java.util.Scanner;

public class Solution2105 { // 디저트 카페

	static int[][] map = new int[21][21];
	static boolean[][] visit;
	static boolean[] check;
	static int startC = 0, startR = 0;
	static int[][] dir = { { 1, 1 }, { -1, 1 }, { -1, -1 }, { 1, -1 } }; 
	static int maxDessert = -1;
	static int N = 0;

	public static void dfs(int r, int c, int direction, int count) {

		for (int i = direction; i < 4; i++) {
			int nextC = c + dir[i][0];
			int nextR = r + dir[i][1];

			if (nextC >= 0 && nextC < N && nextR >= 0 && nextR < N) {
				if (nextC == startC && nextR == startR && count >= 4) { 
					if (count > maxDessert) {
						maxDessert = count;
					}
					return;
				}

				int nextDst = map[nextR][nextC];
				if (visit[nextR][nextC] == false && check[nextDst] == false) {
					visit[nextR][nextC] = true;
					check[nextDst] = true;
					
					dfs(nextR, nextC, i, count + 1);

					visit[nextR][nextC] = false;
					check[nextDst] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			N = sc.nextInt();
			check = new boolean[101];
			visit = new boolean[N][N];
			maxDessert = -1;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					startC = j;
					startR = i;

					int nowDst = map[i][j];
					check[nowDst] = true;
					visit[i][j] = true;

					dfs(i, j, 0, 1);
					
					check[nowDst] = false;
					visit[i][j] = false;
					
				}
			}
			System.out.println("#" + (t + 1) + " " + maxDessert);
		}
		sc.close();
	}
}