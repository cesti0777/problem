package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ12100_New {
	static int answer;
	static int n;
	static int map[][];
	
	static int curR;
	static int curC;
	static int[][] curMap;
	static int totalCnt;
	static int[][] cloneMap;
	static int full;
	static int tmp;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = in.nextInt();
			}
		}

		execute();

		System.out.println(answer);
	}

	public static void execute() {

		int[][] curMap = null;
		int totalCnt = 0;
		int[][] cloneMap;
		int full;
		int tmp;

		Queue<Object> q = new LinkedList<Object>();//bfs ť
		q.add(map);
		q.add(0);
		
		while (!q.isEmpty()) {
			curMap = (int[][]) q.remove();
			totalCnt = (int) q.remove();

			if (totalCnt == 5) {//Ż�� ����, �̵� 5ȸ ������
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if(curMap[i][j] != 0){
							answer = Math.max(answer, curMap[i][j]);//���� ū ������ �� ����
						}
					}
				}
				continue;
			}
			

			// ��
			cloneMap = cloneMap(curMap);////�̵��� �ʻ��� ����, �ٸ��������� �̵��� �� �����¸� ��� �ϹǷ�
			for (int j = 0; j < n; j++) {// �� ��ȸ, ����
				// ��ġ��
				for (int i = 0; i < n - 1; i++) {// �� ��ȸ
					if (cloneMap[i][j] == 0) {//��ĭ �ǳ� �ٱ�
						continue;
					}
					//���� �߰��ϸ� ��ġ ���
					curR = i;
					for (int k = i + 1; k < n; k++) {// ���� �� Ž��
						if (cloneMap[k][j] != 0) {// �� �߰�
							if (cloneMap[curR][j] == cloneMap[k][j]) {// ���� ��
								cloneMap[curR][j] *= 2;
								cloneMap[k][j] = 0;
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
				full = 0;// ���� �� �ε���
				tmp = 0;
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

			// ��
			cloneMap = cloneMap(curMap);
			for (int j = 0; j < n; j++) {// �� ��ȸ
				// ��ġ��
				for (int i = n - 1; i > 0; i--) {// �� ��ȸ
					if (cloneMap[i][j] == 0) {
						continue;
					}
					//���� �߰��ϸ� ��ġ ���
					curR = i;
					for (int k = i - 1; k >= 0; k--) {// ���� �� Ž��
						if (cloneMap[k][j] != 0) {// �� �߰�
							if (cloneMap[curR][j] == cloneMap[k][j]) {// ���� ��
								cloneMap[curR][j] *= 2;
								cloneMap[k][j] = 0;
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
				full = n - 1;// ���� �� �ε���
				tmp = 0;
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

			// ��
			cloneMap = cloneMap(curMap);
			for (int i = 0; i < n; i++) {// �� ��ȸ
				// ��ġ��
				for (int j = 0; j < n - 1; j++) {// �� ��ȸ
					if (cloneMap[i][j] == 0) {
						continue;
					}
					//���� �߰��ϸ� ��ġ ���
					curC = j;
					for (int k = j + 1; k < n; k++) {// ���� �� Ž��
						if (cloneMap[i][k] != 0) {// �� �߰�
							if (cloneMap[i][curC] == cloneMap[i][k]) {// ����  ��
								cloneMap[i][curC] *= 2;
								cloneMap[i][k] = 0;
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
				full = 0;// ���� �� �ε���
				tmp = 0;
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

			// ��
			cloneMap = cloneMap(curMap);
			for (int i = 0; i < n; i++) {// �� ��ȸ
				// ��ġ��
				for (int j = n - 1; j > 0; j--) {// �� ��ȸ
					if (cloneMap[i][j] == 0) {
						continue;
					}
					//���� �߰��ϸ� ��ġ ���
					curC = j;
					for (int k = j - 1; k >= 0; k--) {// ���� �� Ž��
						if (cloneMap[i][k] != 0) {// �� �߰�
							if (cloneMap[i][curC] == cloneMap[i][k]) {// ���� ��
								cloneMap[i][curC] *= 2;
								cloneMap[i][k] = 0;
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
				full = n - 1;// ���� �� �ε���
				tmp = 0;
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
		} // end while
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