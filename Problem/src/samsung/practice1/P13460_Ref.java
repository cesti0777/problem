package samsung.practice1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//https://www.acmicpc.net/problem/13460
//°��Ż��2
public class P13460_Ref {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		char arr[][] = new char[n][m];

		int rx = 0, ry = 0, bx = 0, by = 0;
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		for (int i = 0; i < n; i++) {
			String tmp = sc.next();
			for (int j = 0; j < m; j++) {
				arr[i][j] = tmp.charAt(j);

				if (arr[i][j] == 'R') {
					rx = i;
					ry = j;
				} else if (arr[i][j] == 'B') {
					bx = i;
					by = j;
				}
			}
		}

		Queue<Data> qu = new LinkedList<Data>();
		boolean chk[][][][] = new boolean[11][11][11][11];

		qu.offer(new Data(rx, ry, bx, by, 0));
		chk[rx][ry][bx][by] = true;

		boolean ok1, ok2; // ok1 : �Ķ������� ���ۿ� ������
		// ok2 : ���������� ���ۿ� ������
		int nbx = 0, nby = 0, nrx = 0, nry = 0;

		while (!qu.isEmpty()) {
			Data d = qu.remove();

			for (int i = 0; i < 4; i++) {
				int cnt = 1;
				ok1 = false;
				ok2 = false;

				// �Ķ��� ������
				while (true) {
					nbx = d.bx + dx[i] * cnt;
					nby = d.by + dy[i] * cnt;

					// �ϴ� �����鼭 �տ� ���� �ƴ� ���� ������ �ִ��� üũ�� ���߿� �ؿ���!
					// ��ĭ�� �þ��_cnt ������ ���� ���� ������
					if (arr[nbx][nby] == '#') {
						// �ٽ� �ٷ� �� ��ǥ�ڸ��� ���ư���
						nbx = nbx - dx[i];
						nby = nby - dy[i];
						break; // �׸� ������
					}
					// ������ ������
					else if (arr[nbx][nby] == 'O') {
						ok1 = true; // �Ķ������� �������� ������!
						break;
					}

					cnt++;
				}

				cnt = 1;

				// ������ ������
				while (true) {
					nrx = d.rx + dx[i] * cnt;
					nry = d.ry + dy[i] * cnt;

					// �ϴ� �����鼭 �տ� ���� �ƴ� �Ķ������� �ִ����� �ؿ��� üũ!

					if (arr[nrx][nry] == '#') {
						nrx = nrx - dx[i];
						nry = nry - dy[i];
						break;
					} else if (arr[nrx][nry] == 'O') {
						ok2 = true; // �������� ���ۿ� ������!
						break;
					}

					cnt++;
				}

				// �Ķ� ������ ���ۿ� �����ٸ� �����̹Ƿ� ��
				if (ok1 == true)
					continue;

				// ���� ������ ���ۿ� �����ٸ� �����̹Ƿ� ��� �� ���α׷� ����
				if (ok2 == true) {
					if (d.count + 1 <= 10) {
						System.out.println((d.count + 1));
						System.exit(0);
					} else {
						System.out.println(-1);
						System.exit(0);
					}

				}

				// �� �� ���ۿ� �������ʾҴٸ�
				// �ٵ� �� ������ ���� ��ġ�� �ִٸ�_������ �տ� ���� �ִ����� üũ���ְ� ������ ���� �ִ°��� ���������༭
				if (nbx == nrx && nby == nry) {
					// �����̱� ���� ���� ������ ��ġ ���

					// ���� �Ķ������̶� ���� ������ ���� x��ǥ�� �ִ� �����ε�
					if (d.bx == d.rx) {
						// ������ �������� �������� ���
						if (i == 3) {
							// ���� R B ��ġ���ٸ�
							if (d.by > d.ry) {
								nry = nry - dy[i]; // R������ ��ĭ �������� �ű��
							}
							// ���� B R ��ġ���ٸ�
							else if (d.by < d.ry) {
								nby = nby - dy[i]; // B������ ��ĭ �������� �ű��
							}
						}
						// ���� �������� �������� ���
						else if (i == 2) {
							// ���� R B ��ġ���ٸ�
							if (d.by > d.ry)
								nby = nby - dy[i]; // B������ ��ĭ ��������
							// ���� B R ��ġ���ٸ�
							else if (d.by < d.ry)
								nry = nry - dy[i]; // R������ ��ĭ ��������
						}
					}
					// ���� �Ķ������� ���� ������ ���� y��ǥ�� �ִ� ���¿�����
					else if (d.by == d.ry) {
						// ���� �������� ���
						if (i == 0) {
							/*
							 * ���� R B ������
							 */
							if (d.bx > d.rx)
								nbx = nbx - dx[i]; // B������ ��ĭ ������
							/*
							 * ���� B R ������
							 */
							else if (d.bx < d.rx)
								nrx = nrx - dx[i]; // R������ ��ĭ ������
						}
						// �Ʒ��� �������� ���
						else if (i == 1) {
							/*
							 * ���� R B ������
							 */
							if (d.bx > d.rx)
								nrx = nrx - dx[i]; // R������ ��ĭ ����
							/*
							 * ���� B R ������
							 */
							else if (d.bx < d.rx)
								nbx = nbx - dx[i]; // B������ ��ĭ ����
						}
					}
				}

				// �̹� �湮�ߴٸ�...
				if (chk[nrx][nry][nbx][nby] == true)
					continue;

				// �ƴ϶��...
				chk[nrx][nry][nbx][nby] = true;
				qu.offer(new Data(nrx, nry, nbx, nby, d.count + 1)); // �������� ����
																		// ����������
																		// �Ķ�����
																		// ��ǥ �ְ�
																		// count
																		// �ϳ� ����
			}
		}
		System.out.println(-1);
	}
}

class Data {
	int rx, ry, bx, by;
	int count;

	public Data(int rx, int ry, int bx, int by, int count) {
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.count = count;
	}
}