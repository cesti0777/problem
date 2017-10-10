package samsung.practice1;

import java.util.Scanner;

public class P14502_kj {
	static int n;
	static int m;
	static int[][] map = new int[8][8];
	static int[][] tempmap = new int[8][8];
	static int nowcount = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tempmap[i][j] = map[i][j];
			}
		}

		// spread(tempmap);
		// System.out.println(count(tempmap));
		// for (int i = 0; i < n; i++) {
		// for (int j = 0; j < m; j++) {
		// System.out.print(tempmap[i][j]);
		// System.out.print(" ");
		// }
		// System.out.println();
		// }

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tempmap[i][j] == 0) {
					for (int i2 = 0; i2 < n; i2++) {
						for (int j2 = 0; j2 < m; j2++) {
							if (tempmap[i2][j2] == 0) {
								for (int i3 = 0; i3 < n; i3++) {
									for (int j3 = 0; j3 < m; j3++) {
										if (i3 != i && i3 != i2 && j3 != j && j3 != j2 && i2 != i && j2 != j
												&& tempmap[i3][j3] == 0) {
											tempmap[i][j] = 1;
											tempmap[i2][j2] = 1;
											tempmap[i3][j3] = 1;
											spread(tempmap);
											System.out.println(count(tempmap));
											//System.out.println(i+"/"+j+"_"+i2+"/"+j2+"_"+i3+"/"+j3+":"+count(tempmap));
											if (nowcount < count(tempmap))
												nowcount = count(tempmap);
											tempmap[i][j] = 0;
											tempmap[i2][j2] = 0;
											tempmap[i3][j3] = 0;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(nowcount);
	}

	public static void spread(int[][] tempmap) { // ���̷��� Ȯ��
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tempmap[i][j] == 2) {
					if (i - 1 >= 0 && j < m && tempmap[i - 1][j] == 0)
						tempmap[i - 1][j] = 2;
					if (i + 1 < n && j < m && tempmap[i + 1][j] == 0)
						tempmap[i + 1][j] = 2;
					if (j - 1 >= 0 && i < n && tempmap[i][j - 1] == 0)
						tempmap[i][j - 1] = 2;
					if (j + 1 < m && i < n && tempmap[i][j + 1] == 0)
						tempmap[i][j + 1] = 2;
				}
			}
		}
	}

	public static int count(int[][] tempmap) { // ���� �ȵ� ĭ ���� ����
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tempmap[i][j] == 0)
					count++;
			}
		}
		return count;
	}
}
