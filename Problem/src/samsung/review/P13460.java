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

				// R 굴리기, 공 겹치는 경우 고려 x
				while (true) {
					rCurY += dY[i];
					rCurX += dX[i];

					if (map[rCurY][rCurX] == '#') {// 벽이면 이전 좌표로 복귀하고 그만
						rCurY -= dY[i];
						rCurX -= dX[i];
						break;
					} else if (map[rCurY][rCurX] == 'O') {// 골이면 flag 바꾸고 그만 굴려
						rGole = true;
						break;
					}
				}

				// B 굴리기, 공 겹치는 경우 고려 x
				while (true) {
					bCurX += dX[i];
					bCurY += dY[i];

					if (map[bCurY][bCurX] == '#') {// 벽이면 이전 좌표로 복귀하고 그만
						bCurY -= dY[i];
						bCurX -= dX[i];
						break;
					} else if (map[bCurY][bCurX] == 'O') {// 골이면 flag 바꾸고 그만 굴려
						bGole = true;
						break;
					}
				}

				// B 골
				if (bGole == true) {
					continue;
				}

				// A 골
				if (rGole == true) {
					if (d.cnt + 1 <= 10) {
						System.out.println(d.cnt + 1);
						return;
					} else {
						System.out.println(-1);
						return;
					}
				}

				// R, B 모두 골이 아니고 같은 위치에 존재할 때
				if (rCurX == bCurX && rCurY == bCurY) {
					if (i == 0) {// 상
						if (d.rY < d.bY) {// R이 상
							bCurY -= dY[i];
						} else if (d.rY > d.bY){// B가 하
							rCurY -= dY[i];
						}
					} else if (i == 1) {// 하
						if (d.rY > d.bY) {// R이 하
							bCurY -= dY[i];
						} else if (d.rY < d.bY){// B가 하
							rCurY -= dY[i];
						}
					} else if (i == 2) {// 좌
						if (d.rX < d.bX) {// R이 좌
							bCurX -= dX[i];
						} else if (d.rX > d.bX){// B가 좌
							rCurX -= dX[i];
						}
					} else if (i == 3) {// 우
						if (d.rX > d.bX) {// R이 우
							bCurX -= dX[i];
						} else if (d.rX < d.bX){// B가 우
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
