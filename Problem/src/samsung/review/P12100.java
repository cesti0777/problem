package samsung.review;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P12100 {
	static int testCnt;
	static int answer;
	static int n;
	static int map[][];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		testCnt = in.nextInt();

		for (int testCase = 1; testCase <= testCnt; testCase++) {
			init();

			n = in.nextInt();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = in.nextInt();
				}
			}

			execute();

			System.out.println("#" + testCase + " " + answer);
		}
	}

	public static void execute() {
		int curR;
		int curC;

		Queue<Object> q = new LinkedList<Object>();
		q.add(map);
		q.add(1);

		while (!q.isEmpty()) {
			int[][] curMap = (int[][]) q.remove();
			int totalCnt = (int) q.remove();
			int[][] cloneMap;

			if (totalCnt > 5) {
				continue;
			}

			// ��
			cloneMap = cloneMap(curMap);
			for (int j = 0; j < n; j++) {// �� ��ȸ
				// ��ġ��
				for (int i = 0; i < n - 1; i++) {// �� ��ȸ
					if (cloneMap[i][j] == 0) {
						continue;
					}
					// �� �� ����
					curR = i;
					curC = j;
					for (int k = i + 1; k < n; k++) {// ���� �� Ž��
						if (cloneMap[k][curC] != 0) {// �� �߰�
							if (cloneMap[curR][curC] == cloneMap[k][curC]) {// ����
								cloneMap[curR][curC] *= 2;
								cloneMap[k][curC] = 0;
								i = k;
								break;
							} else {
								i = k - 1;
								break;
							}
						}
					}
				}
				// �б�
				int full = 0;// ���� �� �ε���
				int tmp = 0;
				for (int i = 0; i < n; i++) {// �� ��ȸ
					if (cloneMap[i][j] != 0) {// �� �߰�
						tmp = cloneMap[i][j];
						cloneMap[i][j] = 0;
						cloneMap[full][j] = tmp;
						full++;
					}
				}
			}
			q.add(cloneMap);
			q.add(totalCnt + 1);
			if (totalCnt == 5) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						answer = Math.max(answer, cloneMap[i][j]);
					}
				}
			}

			// ��
			cloneMap = cloneMap(curMap);
			for (int j = 0; j < n; j++) {// �� ��ȸ
				// ��ġ��
				for (int i = n - 1; i > 0; i--) {// �� ��ȸ
					if (cloneMap[i][j] == 0) {
						continue;
					}
					// �� �� ����
					curR = i;
					curC = j;
					for (int k = i - 1; k >= 0; k--) {// ���� �� Ž��
						if (cloneMap[k][curC] != 0) {// �� �߰�
							if (cloneMap[curR][curC] == cloneMap[k][curC]) {// ����
								cloneMap[curR][curC] *= 2;
								cloneMap[k][curC] = 0;
								i = k;
								break;
							} else {
								i = k + 1;
								break;
							}
						}
					}
				}
				// �б�
				int full = n - 1;// ���� �� �ε���
				int tmp = 0;
				for (int i = n - 1; i >= 0; i--) {// �� ��ȸ
					if (cloneMap[i][j] != 0) {// �� �߰�
						tmp = cloneMap[i][j];
						cloneMap[i][j] = 0;
						cloneMap[full][j] = tmp;
						full--;
					}
				}
			}
			q.add(cloneMap);
			q.add(totalCnt + 1);
			if (totalCnt == 5) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						answer = Math.max(answer, cloneMap[i][j]);
					}
				}
			}

			// ��
			cloneMap = cloneMap(curMap);
			for (int i = 0; i < n; i++) {// �� ��ȸ
				// ��ġ��
				for (int j = 0; j < n - 1; j++) {// �� ��ȸ
					if (cloneMap[i][j] == 0) {
						continue;
					}
					// �� �� ����
					curR = i;
					curC = j;
					for (int k = j + 1; k < n; k++) {// ���� �� Ž��
						if (cloneMap[curR][k] != 0) {// �� �߰�
							if (cloneMap[curR][curC] == cloneMap[curR][k]) {// ����
								cloneMap[curR][curC] *= 2;
								cloneMap[curR][k] = 0;
								j = k;
								break;
							} else {
								j = k - 1;
								break;
							}
						}
					}
				}
				// �б�
				int full = 0;// ���� �� �ε���
				int tmp = 0;
				for (int j = 0; j < n; j++) {// �� ��ȸ
					if (cloneMap[i][j] != 0) {// �� �߰�
						tmp = cloneMap[i][j];
						cloneMap[i][j] = 0;
						cloneMap[i][full] = tmp;
						full++;
					}
				}
			}
			q.add(cloneMap);
			q.add(totalCnt + 1);
			if (totalCnt == 5) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						answer = Math.max(answer, cloneMap[i][j]);
					}
				}
			}

			// ��
			cloneMap = cloneMap(curMap);
			for (int i = 0; i < n; i++) {// �� ��ȸ
				// ��ġ��
				for (int j = n - 1; j > 0; j--) {// �� ��ȸ
					if (cloneMap[i][j] == 0) {
						continue;
					}
					// �� �� ����
					curR = i;
					curC = j;
					for (int k = j - 1; k >= 0; k--) {// ���� �� Ž��
						if (cloneMap[curR][k] != 0) {// �� �߰�
							if (cloneMap[curR][curC] == cloneMap[curR][k]) {// ����
								cloneMap[curR][curC] *= 2;
								cloneMap[curR][k] = 0;
								j = k;
								break;
							} else {
								j = k + 1;
								break;
							}
						}
					}
				}
				// �б�
				int full = n - 1;// ���� �� �ε���
				int tmp = 0;
				for (int j = n - 1; j >= 0; j--) {// �� ��ȸ
					if (cloneMap[i][j] != 0) {// �� �߰�
						tmp = cloneMap[i][j];
						cloneMap[i][j] = 0;
						cloneMap[i][full] = tmp;
						full--;
					}
				}
			}
			q.add(cloneMap);
			q.add(totalCnt + 1);
			if (totalCnt == 5) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						answer = Math.max(answer, cloneMap[i][j]);
					}
				}
			}
		} // end while
	}

	public static void init() {
		answer = 0;
		n = 0;
		map = null;
		map = new int[20][20];
	}

	public static void print(int[][] arr) {
		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

	public static int[][] cloneMap(int[][] arr) {
		int[][] cloneMap = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cloneMap[i][j] = arr[i][j];
			}
		}
		return cloneMap;
	} 
}

//6
//3
//2 2 2
//4 4 4
//8 8 8
//2
//16 0 
//0 0
//7
//2 2 2 2 2 2 2
//2 0 2 2 2 2 2
//2 0 2 2 2 2 2
//2 0 2 2 2 2 2
//2 2 2 0 2 2 2 
//2 2 2 2 2 2 0
//2 2 2 2 2 2 0
//10
//0 0 64 32 32 0 0 0 0 0
//0 32 32 64 0 0 0 0 0 0
//0 0 128 0 0 0 0 0 0 0 
//64 64 128 0 0 0 0 0 0 0
//0 0 64 32 32 0 0 0 0 0
//0 32 32 64 0 0 0 0 0 0
//0 0 128 0 0 0 0 0 0 0 
//64 64 128 0 0 0 0 0 0 0
//128 32 2 4 0 0 0 0 0 0
//0 0 128 0 0 0 0 0 0 0
//20
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024 1024
//20
//0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 1 0 1
//1 3 0 0 1 3 0 0 1 3 0 0 1 3 0 0 1 3 0 0
//0 2 0 0 0 2 0 0 0 2 0 0 0 2 0 0 0 2 0 0
//1 0 4 0 1 0 4 0 1 0 4 0 1 0 4 0 1 0 4 0
//0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 1 0 1
//1 3 0 0 1 3 0 0 1 3 0 0 1 3 0 0 1 3 0 0
//0 2 0 0 0 2 0 0 0 2 0 0 0 2 0 0 0 2 0 0
//1 0 0 0 1 0 4 0 1 0 4 0 1 0 4 0 1 0 4 0
//0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 1 0 1
//1 3 0 0 1 3 0 0 1 3 0 0 1 3 0 0 1 3 0 0
//0 2 0 0 0 2 0 0 0 2 0 0 0 2 0 0 0 2 0 0
//1 0 0 0 1 0 4 0 1 0 4 0 1 0 4 0 1 0 4 0
//0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 1 0 1
//1 3 0 0 1 3 0 0 1 3 0 0 1 3 0 0 1 3 0 0
//0 2 0 0 0 2 0 0 0 2 0 0 0 2 0 0 0 2 0 0
//1 0 0 0 1 0 4 0 1 0 4 0 1 0 4 0 1 0 4 0
//0 0 8 0 0 0 0 1 0 1 0 0 0 0 0 0 0 1 0 1
//1 3 8 0 1 3 0 0 1 3 0 0 1 3 0 0 1 3 0 0
//0 2 4 0 0 2 0 0 0 2 0 0 0 2 0 0 0 2 0 0
//1 0 4 0 1 0 4 0 1 0 4 0 1 0 4 0 1 0 4 0

