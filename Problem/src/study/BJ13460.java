package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import samsung.review.P13460.Data;

public class BJ13460 {
	static int r;//맵 세로 길이
	static int c;//맵 가로 길이
	static char[][] map;//맵
	static boolean[][][][] visited;//방문 체크 배열
	static int rR, rC, bR, bC;//처음 R/B 위치
	static int[] dR = { -1, 1, 0, 0 };//행이동
	static int[] dC = { 0, 0, -1, 1 };//열이동

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

		Queue<Data> q = new LinkedList<Data>();//bfs 큐
		q.add(new Data(rR, rC, bR, bC, 0));//Data객체 만들어서 시작 위치 inqueue
		visited[rR][rC][bR][bC] = true;//R/B 시작 위치 방문 체크
		while (!q.isEmpty()) {
			Data d = q.remove();

			for (int i = 0; i < 4; i++) {//상하좌우 반복
				int rCurR = d.rR;
				int rCurC = d.rC;
				int bCurR = d.bR;
				int bCurC = d.bC;
				boolean rGole = false;//R 골인 flag 초기화
				boolean bGole = false;//B 골인 flag 초기화

				// R 굴리기, 공 겹치는 경우 고려 x
				while (true) {
					rCurR += dR[i];
					rCurC += dC[i];

					if (map[rCurR][rCurC] == '#') {// 벽이면 이전 좌표로 복귀하고 그만
						rCurR -= dR[i];
						rCurC -= dC[i];
						break;
					} else if (map[rCurR][rCurC] == 'O') {// 골이면 flag 바꾸고 그만 굴려
						rGole = true;
						break;
					}
				}

				// B 굴리기, 공 겹치는 경우 고려 x
				while (true) {
					bCurC += dC[i];
					bCurR += dR[i];

					if (map[bCurR][bCurC] == '#') {// 벽이면 이전 좌표로 복귀하고 그만
						bCurR -= dR[i];
						bCurC -= dC[i];
						break;
					} else if (map[bCurR][bCurC] == 'O') {// 골이면 flag 바꾸고 그만 굴려
						bGole = true;
						break;
					}
				}

				// B 골
				if (bGole == true) {//B가 골인하면 실패
					continue;
				}

				// A 골
				if (rGole == true) {//B가 골인하면
					if (d.cnt + 1 <= 10) {//최대 이동횟수 이하이면
						System.out.println(d.cnt + 1);
						return;
					} else {//최대 이동횟수 초과
						System.out.println(-1);
						return;
					}
				}

				// R, B 모두 골이 아니고 같은 위치에 존재할 때
				if (rCurC == bCurC && rCurR == bCurR) {
					if (i == 0) {// 상
						if (d.rR < d.bR) {// R이 상
							bCurR -= dR[i];
						} else if (d.rR > d.bR){// B가 하
							rCurR -= dR[i];
						}
					} else if (i == 1) {// 하
						if (d.rR > d.bR) {// R이 하
							bCurR -= dR[i];
						} else if (d.rR < d.bR){// B가 하
							rCurR -= dR[i];
						}
					} else if (i == 2) {// 좌
						if (d.rC < d.bC) {// R이 좌
							bCurC -= dC[i];
						} else if (d.rC > d.bC){// B가 좌
							rCurC -= dC[i];
						}
					} else if (i == 3) {// 우
						if (d.rC > d.bC) {// R이 우
							bCurC -= dC[i];
						} else if (d.rC < d.bC){// B가 우
							rCurC -= dC[i];
						}
					}
				}

				if (visited[rCurR][rCurC][bCurR][bCurC] != true) {//이동 완료 후 현위치 방문 체크
					visited[rCurR][rCurC][bCurR][bCurC] = true;
					q.add(new Data(rCurR, rCurC, bCurR, bCurC, d.cnt + 1));
				}
			}
		}
		System.out.println(-1);//모든 경우가 실패했을 시
	}

	public static class Data {
		int rR, rC, bR, bC, cnt;
		//R행, R열, B행, B열, 이동횟수
		public Data(int rR, int rC, int bR, int bC, int cnt) {
			this.rR = rR;
			this.rC = rC;
			this.bR = bR;
			this.bC = bC;
			this.cnt = cnt;
		}
	}
}
