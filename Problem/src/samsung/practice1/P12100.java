package samsung.practice1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P12100 {
	static int n;
	static int map[][] = new int[20][20];
	static Map cloneMap;
	static int max;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();

		// �� �Է�
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = in.nextInt();
			}
		}

		Queue<Map> q = new LinkedList<Map>();
		q.add(new Map(map, 0));

		while (!q.isEmpty()) {
			int tmpI = 0;
			int tmpJ = 0;

			Map m = q.remove();

			if (m.cnt == 5) {
				countMax(m);
				continue;
			}

			// ��
			cloneMap = cloneMap(m);
			for (int j = 0; j < n; j++) {
				int cnt = 0;
				for (int i = 0; i < n; i++) {
					if (cloneMap.map[i][j] > 0) {
						tmpI = i;
						tmpJ = j;
						cnt++;
						if (i < n - 1) {
							for (int k = i + 1; k < n; k++) {
								if (cloneMap.map[k][j] > 0) {
									if (cloneMap.map[k][j] == cloneMap.map[tmpI][tmpJ]) {
										cloneMap.map[tmpI][tmpJ] *= 2;
										cloneMap.map[k][j] = 0;
										i = k - 1;
										break;
									} else {
										i = k - 1;
										break;
									}
								}
							}
						}
					}
				}
				int tmp = 0;
				for (int i = 0; i < cnt; i++) {
					for (int k = i; k < n; k++) {
						if (cloneMap.map[k][j] > 0) {
							tmp = cloneMap.map[k][j];
							cloneMap.map[k][j] = 0;
							cloneMap.map[i][j] = tmp;
							break;
						}
					}
				}
			}

			cloneMap.cnt++;
			q.add(cloneMap);

			// ��
			cloneMap = cloneMap(m);
			for (int j = 0; j < n; j++) {
				int cnt = 0;
				for (int i = n - 1; i >= 0; i--) {
					if (cloneMap.map[i][j] > 0) {
						tmpI = i;
						tmpJ = j;
						cnt++;
						if (i > 0) {
							for (int k = i - 1; k >= 0; k--) {
								if (cloneMap.map[k][j] > 0) {
									if (cloneMap.map[k][j] == cloneMap.map[tmpI][tmpJ]) {
										cloneMap.map[tmpI][tmpJ] *= 2;
										cloneMap.map[k][j] = 0;
										i = k + 1;
										break;
									} else {
										i = k + 1;
										break;
									}
								}
							}
						}
					}
				}

				int tmp = 0;
				for (int i = n - 1; i >= n - cnt; i--) {
					for (int k = i; k >= 0; k--) {
						if (cloneMap.map[k][j] > 0) {
							tmp = cloneMap.map[k][j];
							cloneMap.map[k][j] = 0;
							cloneMap.map[i][j] = tmp;
							break;
						}
					}
				}
			}

			cloneMap.cnt++;
			q.add(cloneMap);

			// ��
			cloneMap = cloneMap(m);
			for (int i = 0; i < n; i++) {
				int cnt = 0;
				for (int j = 0; j < n; j++) {
					if (cloneMap.map[i][j] > 0) {
						tmpI = i;
						tmpJ = j;
						cnt++;
						if (j < n - 1) {
							for (int k = j + 1; k < n; k++) {
								if (cloneMap.map[i][k] > 0) {
									if (cloneMap.map[i][k] == cloneMap.map[tmpI][tmpJ]) {
										cloneMap.map[tmpI][tmpJ] *= 2;
										cloneMap.map[i][k] = 0;
										j = k - 1;
										break;
									} else {
										j = k - 1;
										break;
									}
								}
							}
						}
					}
				}
				int tmp = 0;
				for (int j = 0; j < cnt; j++) {
					for (int k = j; k < n; k++) {
						if (cloneMap.map[i][k] > 0) {
							tmp = cloneMap.map[i][k];
							cloneMap.map[i][k] = 0;
							cloneMap.map[i][j] = tmp;
							break;
						}
					}
				}
			}

			cloneMap.cnt++;
			q.add(cloneMap);

			// ��
			cloneMap = cloneMap(m);
			for (int i = 0; i < n; i++) {
				int cnt = 0;
				for (int j = n - 1; j >= 0; j--) {
					if (cloneMap.map[i][j] > 0) {
						tmpI = i;
						tmpJ = j;
						cnt++;
						if (j > 0) {
							for (int k = j - 1; k >= 0; k--) {
								if (cloneMap.map[i][k] > 0) {
									if (cloneMap.map[i][k] == cloneMap.map[tmpI][tmpJ]) {
										cloneMap.map[tmpI][tmpJ] *= 2;
										cloneMap.map[i][k] = 0;
										j = k + 1;
										break;
									} else {
										j = k + 1;
										break;
									}
								}
							}
						}
					}
				}
				int tmp = 0;
				for (int j = n - 1; j >= n - cnt; j--) {
					for (int k = j; k >= 0; k--) {
						if (cloneMap.map[i][k] > 0) {
							tmp = cloneMap.map[i][k];
							cloneMap.map[i][k] = 0;
							cloneMap.map[i][j] = tmp;
							break;
						}
					}
				}
			}

			cloneMap.cnt++;
			q.add(cloneMap);

			m = null;
		}
		System.out.println(max);
	}

	public static void countMax(Map m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, m.map[i][j]);
			}
		}
	}

	public static class Map {
		int[][] map = new int[20][20];
		int cnt = 0;

		public Map() {
		}

		public Map(int[][] map, int cnt) {
			super();
			this.map = map;
			this.cnt = cnt;
		}
	}

	public static Map cloneMap(Map m) {
		int map[][] = new int[20][20];
		int cnt = m.cnt;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = m.map[i][j];
			}
		}
		return new Map(map, cnt);
	}
}