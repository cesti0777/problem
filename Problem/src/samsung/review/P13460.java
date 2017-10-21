package samsung.review;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P13460 {
	static int y;
	static int x;
	static char map[][] = new char[10][10];
	static boolean[][][][] visited = new boolean[10][10][10][10];
	static int rY, rX, bY, bX;
	static int[] dY = { -1, 1, 0, 0 };
	static int[] dX = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		y = in.nextInt();
		x = in.nextInt();
		in.nextLine();

		for (int i = 0; i < y; i++) {
			String line = in.nextLine();
			for (int j = 0; j < x; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'R') {
					rY = i;
					rX = j;
				} else if (map[i][j] == 'B') {
					bY = i;
					bX = j;
				}
			}
		}

		Queue<Data> q = new LinkedList<Data>();
		q.add(new Data(rY, rX, bY, bX, 0));
		visited[rY][rX][bY][bX] = true;
		while (!q.isEmpty()) {
			Data d = q.remove();

			for (int i = 0; i < 4; i++) {
				int rCurY = d.rY;
				int rCurX = d.rX;
				int bCurY = d.bY;
				int bCurX = d.bX;
				boolean rGole = false;
				boolean bGole = false;

				// R ������, �� ��ġ�� ��� ��� x
				while (true) {
					rCurY += dY[i];
					rCurX += dX[i];

					if (map[rCurY][rCurX] == '#') {// ���̸� ���� ��ǥ�� �����ϰ� �׸�
						rCurY -= dY[i];
						rCurX -= dX[i];
						break;
					} else if (map[rCurY][rCurX] == 'O') {// ���̸� flag �ٲٰ� �׸� ����
						rGole = true;
						break;
					}
				}

				// B ������, �� ��ġ�� ��� ��� x
				while (true) {
					bCurX += dX[i];
					bCurY += dY[i];

					if (map[bCurY][bCurX] == '#') {// ���̸� ���� ��ǥ�� �����ϰ� �׸�
						bCurY -= dY[i];
						bCurX -= dX[i];
						break;
					} else if (map[bCurY][bCurX] == 'O') {// ���̸� flag �ٲٰ� �׸� ����
						bGole = true;
						break;
					}
				}

				// B ��
				if (bGole == true) {
					continue;
				}

				// A ��
				if (rGole == true) {
					if (d.cnt + 1 <= 10) {
						System.out.println(d.cnt + 1);
						return;
					} else {
						System.out.println(-1);
						return;
					}
				}

				// R, B ��� ���� �ƴϰ� ���� ��ġ�� ������ ��
				if (rCurX == bCurX && rCurY == bCurY) {
					if (i == 0) {// ��
						if (d.rY < d.bY) {// R�� ��
							bCurY -= dY[i];
						} else if (d.rY > d.bY){// B�� ��
							rCurY -= dY[i];
						}
					} else if (i == 1) {// ��
						if (d.rY > d.bY) {// R�� ��
							bCurY -= dY[i];
						} else if (d.rY < d.bY){// B�� ��
							rCurY -= dY[i];
						}
					} else if (i == 2) {// ��
						if (d.rX < d.bX) {// R�� ��
							bCurX -= dX[i];
						} else if (d.rX > d.bX){// B�� ��
							rCurX -= dX[i];
						}
					} else if (i == 3) {// ��
						if (d.rX > d.bX) {// R�� ��
							bCurX -= dX[i];
						} else if (d.rX < d.bX){// B�� ��
							rCurX -= dX[i];
						}
					}
				}

				if (visited[rCurY][rCurX][bCurY][bCurX] != true) {
					visited[rCurY][rCurX][bCurY][bCurX] = true;
					q.add(new Data(rCurY, rCurX, bCurY, bCurX, d.cnt + 1));
				}
			}
		}
		System.out.println(-1);
	}

	public static class Data {
		int rY, rX, bY, bX, cnt;

		public Data() {
		}

		public Data(int rY, int rX, int bY, int bX, int cnt) {
			this.rY = rY;
			this.rX = rX;
			this.bY = bY;
			this.bX = bX;
			this.cnt = cnt;
		}
	}
}
