package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ12100 {
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

		Queue<Map> q = new LinkedList<Map>();//bfs ť
		q.add(new Map(map, 0));//Map class inqueue (��,�̵�Ƚ��)

		while (!q.isEmpty()) {

			Map m = q.remove();//dequeue, (m.map:������� �̵��� �ʻ���, m.cnt:������� �̵�Ƚ��)

			if (m.cnt == 5) {
				countMax(m);
				continue;
			}

			int tmpI = 0;//�̰��� ��ĥ����
			int tmpJ = 0;//�̰��� ��ĥ����
			
			// ��
			cloneMap = cloneMap(m);//�̵��� �ʻ��¸� �����ؿ�, �ٸ��������� �̵��Ҷ� �����¸� ��� �ϹǷ�
			for (int j = 0; j < n; j++) {//�� ����
				int cnt = 0;//��ġ�� ���� ���� ���� ����
				for (int i = 0; i < n; i++) {//�� �̵�
					if (cloneMap.map[i][j] > 0) {//��ĭ�� �ƴϸ�, �����̸�
						tmpI = i;//���� ���� ��ġ ����
						cnt++;//���� �� ���� �̹Ƿ� ���� ����
						if (i < n - 1) {//���� ���ڰ� ���� ���� �ƴϸ�
							for (int k = i + 1; k < n; k++) {//���� ���� ���� ��ġ���� ������
								if (cloneMap.map[k][j] > 0) {//��ĭ�� �ƴϸ�, �����̸�
									if (cloneMap.map[k][j] == cloneMap.map[tmpI][j]) {//���� ���ڿ� ������ �˻�
										cloneMap.map[tmpI][j] *= 2;//2�� ����  = ��ħ
										cloneMap.map[k][j] = 0;//�̵��� ���� ����
										i = k - 1;//Ž�� ���� ������ �ǳʶٱ�
										break;
									} else {
										i = k - 1;//Ž�� ���� ������ �ǳʶٱ�
										break;
									}
								}
							}
						}
					}
				}
				int tmp = 0;
				for (int i = 0; i < cnt; i++) {//�����ִ� ���� ���� ��ŭ �ݺ�
					for (int k = i; k < n; k++) {//�� �� ��ĭ ���� ������ ���鼭
						if (cloneMap.map[k][j] > 0) {//��ĭ�� �ƴϸ�, �����̸�
							tmp = cloneMap.map[k][j];
							cloneMap.map[k][j] = 0;//�̵��� ���� ����
							cloneMap.map[i][j] = tmp;
							break;
						}
					}
				}
			}

			cloneMap.cnt++;//�̵� Ƚ�� ����
			q.add(cloneMap);//�̵� �Ϸ��� �ʻ��� inqueue

			// ��
			cloneMap = cloneMap(m);
			for (int j = 0; j < n; j++) {
				int cnt = 0;
				for (int i = n - 1; i >= 0; i--) {
					if (cloneMap.map[i][j] > 0) {
						tmpI = i;
						cnt++;
						if (i > 0) {
							for (int k = i - 1; k >= 0; k--) {
								if (cloneMap.map[k][j] > 0) {
									if (cloneMap.map[k][j] == cloneMap.map[tmpI][j]) {
										cloneMap.map[tmpI][j] *= 2;
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
						tmpJ = j;
						cnt++;
						if (j < n - 1) {
							for (int k = j + 1; k < n; k++) {
								if (cloneMap.map[i][k] > 0) {
									if (cloneMap.map[i][k] == cloneMap.map[i][tmpJ]) {
										cloneMap.map[i][tmpJ] *= 2;
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
						tmpJ = j;
						cnt++;
						if (j > 0) {
							for (int k = j - 1; k >= 0; k--) {
								if (cloneMap.map[i][k] > 0) {
									if (cloneMap.map[i][k] == cloneMap.map[i][tmpJ]) {
										cloneMap.map[i][tmpJ] *= 2;
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