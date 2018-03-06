package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import samsung.review.P13460.Data;

public class BJ13460 {
	static int r;//�� ���� ����
	static int c;//�� ���� ����
	static char[][] map;//��
	static boolean[][][][] visited;//�湮 üũ �迭
	static int rR, rC, bR, bC;//ó�� R/B ��ġ
	static int[] dR = { -1, 1, 0, 0 };//���̵�
	static int[] dC = { 0, 0, -1, 1 };//���̵�

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		r = in.nextInt();
		c = in.nextInt();
		in.nextLine();
		
		map = new char[r][c];
		visited = new boolean[r][c][r][c];

		for (int i = 0; i < r; i++) {
			String line = in.nextLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'R') {
					rR = i;
					rC = j;
				} else if (map[i][j] == 'B') {
					bR = i;
					bC = j;
				}
			}
		}

		Queue<Data> q = new LinkedList<Data>();//bfs ť
		q.add(new Data(rR, rC, bR, bC, 0));//Data��ü ���� ���� ��ġ inqueue
		visited[rR][rC][bR][bC] = true;//R/B ���� ��ġ �湮 üũ
		while (!q.isEmpty()) {
			Data d = q.remove();

			for (int i = 0; i < 4; i++) {//�����¿� �ݺ�
				int rCurR = d.rR;
				int rCurC = d.rC;
				int bCurR = d.bR;
				int bCurC = d.bC;
				boolean rGole = false;//R ���� flag �ʱ�ȭ
				boolean bGole = false;//B ���� flag �ʱ�ȭ

				// R ������, �� ��ġ�� ��� ��� x
				while (true) {
					rCurR += dR[i];
					rCurC += dC[i];

					if (map[rCurR][rCurC] == '#') {// ���̸� ���� ��ǥ�� �����ϰ� �׸�
						rCurR -= dR[i];
						rCurC -= dC[i];
						break;
					} else if (map[rCurR][rCurC] == 'O') {// ���̸� flag �ٲٰ� �׸� ����
						rGole = true;
						break;
					}
				}

				// B ������, �� ��ġ�� ��� ��� x
				while (true) {
					bCurC += dC[i];
					bCurR += dR[i];

					if (map[bCurR][bCurC] == '#') {// ���̸� ���� ��ǥ�� �����ϰ� �׸�
						bCurR -= dR[i];
						bCurC -= dC[i];
						break;
					} else if (map[bCurR][bCurC] == 'O') {// ���̸� flag �ٲٰ� �׸� ����
						bGole = true;
						break;
					}
				}

				// B ��
				if (bGole == true) {//B�� �����ϸ� ����
					continue;
				}

				// A ��
				if (rGole == true) {//B�� �����ϸ�
					if (d.cnt + 1 <= 10) {//�ִ� �̵�Ƚ�� �����̸�
						System.out.println(d.cnt + 1);
						return;
					} else {//�ִ� �̵�Ƚ�� �ʰ�
						System.out.println(-1);
						return;
					}
				}

				// R, B ��� ���� �ƴϰ� ���� ��ġ�� ������ ��
				if (rCurC == bCurC && rCurR == bCurR) {
					if (i == 0) {// ��
						if (d.rR < d.bR) {// R�� ��
							bCurR -= dR[i];
						} else if (d.rR > d.bR){// B�� ��
							rCurR -= dR[i];
						}
					} else if (i == 1) {// ��
						if (d.rR > d.bR) {// R�� ��
							bCurR -= dR[i];
						} else if (d.rR < d.bR){// B�� ��
							rCurR -= dR[i];
						}
					} else if (i == 2) {// ��
						if (d.rC < d.bC) {// R�� ��
							bCurC -= dC[i];
						} else if (d.rC > d.bC){// B�� ��
							rCurC -= dC[i];
						}
					} else if (i == 3) {// ��
						if (d.rC > d.bC) {// R�� ��
							bCurC -= dC[i];
						} else if (d.rC < d.bC){// B�� ��
							rCurC -= dC[i];
						}
					}
				}

				if (visited[rCurR][rCurC][bCurR][bCurC] != true) {//�̵� �Ϸ� �� ����ġ �湮 üũ
					visited[rCurR][rCurC][bCurR][bCurC] = true;
					q.add(new Data(rCurR, rCurC, bCurR, bCurC, d.cnt + 1));
				}
			}
		}
		System.out.println(-1);//��� ��찡 �������� ��
	}

	public static class Data {
		int rR, rC, bR, bC, cnt;
		//R��, R��, B��, B��, �̵�Ƚ��
		public Data(int rR, int rC, int bR, int bC, int cnt) {
			this.rR = rR;
			this.rC = rC;
			this.bR = bR;
			this.bC = bC;
			this.cnt = cnt;
		}
	}
}
