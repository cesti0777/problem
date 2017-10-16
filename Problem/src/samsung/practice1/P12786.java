package samsung.practice1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P12786 {
	static int n;
	static int k;
	static int holeCnt;
	static int holeHight;
	static int[][] map = new int[20][200];
	static boolean[][] visited = new boolean[20][200];
	static int min = 51;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		k = in.nextInt();

		// 맵 입력
		for (int j = 1; j < n * 2; j += 2) {
			holeCnt = in.nextInt();
			// 나무 세우기
			for (int i = 0; i < 20; i++) {
				map[i][j] = 1;
			}
			// 구멍 뚫기
			for (int i = 0; i < holeCnt; i++) {
				holeHight = in.nextInt();
				map[holeHight - 1][j] = 0;
			}
		}
		print(map);

		Queue<Location> q = new LinkedList<Location>();

		q.add(new Location(0, 0, 1, k, 0));

		while (!q.isEmpty()) {
			Location me = q.remove();
			int mC = me.mC;
			int mR = me.mR;
			int curTree = me.curTree;
			int curK = me.k;
			int useT = me.useT;
			int no = 0;

			if (curTree > n) {
				min = Math.min(min, useT);
				continue;
			}

			// O(제자리)
			if (visited[mR][mC + 1] != true && map[mR][mC + 1] == 0) {
				visited[mR][mC + 1] = true;
				q.add(new Location(mC + 2, mR, curTree + 1, curK, useT));
			} else {
				no++;
			}
			// A(위로 1)
			if (mR + 1 < 20 && visited[mR + 1][mC + 1] != true && map[mR + 1][mC + 1] == 0) {
				visited[mR + 1][mC + 1] = true;
				q.add(new Location(mC + 2, mR + 1, curTree + 1, curK, useT));
			} else {
				no++;
			}
			// B(위로 2x현재높이, 최대 20)
			if (mR + mR + 1 >= 20) {
				if (visited[19][mC + 1] != true && map[19][mC + 1] == 0) {
					visited[19][mC + 1] = true;
					q.add(new Location(mC + 2, 19, curTree + 1, curK, useT));
				}
			} else if (visited[mR + mR + 1][mC + 1] != true && map[mR + mR + 1][mC + 1] == 0) {
				visited[mR + mR + 1][mC + 1] = true;
				q.add(new Location(mC + 2, mR + mR + 1, curTree + 1, curK, useT));
			} else {
				no++;
			}
			// C(아래로 1)
			if (mR - 1 >= 0 && visited[mR - 1][mC + 1] != true && map[mR - 1][mC + 1] == 0) {
				visited[mR - 1][mC + 1] = true;
				q.add(new Location(mC + 2, mR - 1, curTree + 1, curK, useT));
			} else {
				no++;
			}
			// T(순간이동, 4가지 안되면 사용)
			if (curK > 0) {
				mC = me.mC;
				mR = me.mR;
				if (no == 4) {
					for (int i = 0; i < 20; i++) {
						if (visited[i][mC + 1] != true && map[i][mC + 1] == 0) {
							visited[i][mC + 1] = true;
							q.add(new Location(mC + 2, i, curTree + 1, curK - 1, useT + 1));
						}
					}
				}
			}
			me = null;
		} // end while

		// 최종 출력
		if (min == 51) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	public static void print(int[][] arr) {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 2 * n; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

	public static class Location {
		int mC;
		int mR;
		int curTree;
		int k;
		int useT;

		public Location() {
		}

		public Location(int mC, int mR, int curTree, int k, int useT) {
			super();
			this.mC = mC;
			this.mR = mR;
			this.curTree = curTree;
			this.k = k;
			this.useT = useT;
		}
	}
}

//50
//50
//10 1 2 4 6 7 12 14 15 17 20
//10 2 4 6 7 9 12 15 18 19 20
//10 1 2 4 6 7 12 14 15 17 20
//10 2 4 6 7 9 12 15 18 19 20
//10 1 2 4 6 7 12 14 15 17 20
//10 2 4 6 7 9 12 15 18 19 20
//10 1 2 4 6 7 12 14 15 17 20
//10 2 4 6 7 9 12 15 18 19 20
//10 1 2 4 6 7 12 14 15 17 20
//10 2 4 6 7 9 12 15 18 19 20
//10 1 2 4 6 7 12 14 15 17 20
//10 2 4 6 7 9 12 15 18 19 20
//10 1 2 4 6 7 12 14 15 17 20
//10 2 4 6 7 9 12 15 18 19 20
//10 1 2 4 6 7 12 14 15 17 20
//10 2 4 6 7 9 12 15 18 19 20
//10 1 2 4 6 7 12 14 15 17 20
//10 2 4 6 7 9 12 15 18 19 20
//10 1 2 4 6 7 12 14 15 17 20
//10 2 4 6 7 9 12 15 18 19 20
