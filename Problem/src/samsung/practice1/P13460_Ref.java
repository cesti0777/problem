package samsung.practice1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//https://www.acmicpc.net/problem/13460
//째로탈출2
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

		boolean ok1, ok2; // ok1 : 파란구슬이 구멍에 들어갔는지
		// ok2 : 빨간구슬이 구멍에 들어갔는지
		int nbx = 0, nby = 0, nrx = 0, nry = 0;

		while (!qu.isEmpty()) {
			Data d = qu.remove();

			for (int i = 0; i < 4; i++) {
				int cnt = 1;
				ok1 = false;
				ok2 = false;

				// 파란공 굴리기
				while (true) {
					nbx = d.bx + dx[i] * cnt;
					nby = d.by + dy[i] * cnt;

					// 일단 굴리면서 앞에 벽이 아닌 빨간 구슬이 있는지 체크는 나중에 밑에서!
					// 한칸씩 늘어나며_cnt 굴러간 공이 벽을 만나면
					if (arr[nbx][nby] == '#') {
						// 다시 바로 전 좌표자리로 돌아가기
						nbx = nbx - dx[i];
						nby = nby - dy[i];
						break; // 그만 굴리기
					}
					// 구멍을 만나면
					else if (arr[nbx][nby] == 'O') {
						ok1 = true; // 파란구슬이 구멍으로 빠졌다!
						break;
					}

					cnt++;
				}

				cnt = 1;

				// 빨간공 굴리기
				while (true) {
					nrx = d.rx + dx[i] * cnt;
					nry = d.ry + dy[i] * cnt;

					// 일단 굴리면서 앞에 벽이 아닌 파란구슬이 있는지는 밑에서 체크!

					if (arr[nrx][nry] == '#') {
						nrx = nrx - dx[i];
						nry = nry - dy[i];
						break;
					} else if (arr[nrx][nry] == 'O') {
						ok2 = true; // 빨간공이 구멍에 빠졌다!
						break;
					}

					cnt++;
				}

				// 파란 구슬이 구멍에 빠졌다면 실패이므로 끝
				if (ok1 == true)
					continue;

				// 빨간 구슬이 구멍에 빠졌다면 성공이므로 출력 후 프로그램 종료
				if (ok2 == true) {
					if (d.count + 1 <= 10) {
						System.out.println((d.count + 1));
						System.exit(0);
					} else {
						System.out.println(-1);
						System.exit(0);
					}

				}

				// 둘 다 구멍에 빠지지않았다면
				// 근데 두 구슬이 같은 위치에 있다면_위에서 앞에 벽이 있는지만 체크해주고 구슬이 막고 있는경우는 생각안해줘서
				if (nbx == nrx && nby == nry) {
					// 움직이기 전에 원래 구슬의 위치 고려

					// 원래 파란구슬이랑 빨간 구슬이 같은 x좌표에 있는 상태인데
					if (d.bx == d.rx) {
						// 오른쪽 방향으로 움직였던 경우
						if (i == 3) {
							// 원래 R B 위치였다면
							if (d.by > d.ry) {
								nry = nry - dy[i]; // R구슬을 한칸 이전으로 옮기기
							}
							// 원래 B R 위치였다면
							else if (d.by < d.ry) {
								nby = nby - dy[i]; // B구슬을 한칸 이전으로 옮기기
							}
						}
						// 왼쪽 방향으로 움직였던 경우
						else if (i == 2) {
							// 원래 R B 위치였다면
							if (d.by > d.ry)
								nby = nby - dy[i]; // B구슬을 한칸 이전으로
							// 원래 B R 위치였다면
							else if (d.by < d.ry)
								nry = nry - dy[i]; // R구슬을 한칸 이전으로
						}
					}
					// 원래 파란구슬과 빨간 구슬이 같은 y좌표에 있는 상태였으면
					else if (d.by == d.ry) {
						// 위로 움직였던 경우
						if (i == 0) {
							/*
							 * 원래 R B 였으면
							 */
							if (d.bx > d.rx)
								nbx = nbx - dx[i]; // B구슬을 한칸 밑으로
							/*
							 * 원래 B R 였으면
							 */
							else if (d.bx < d.rx)
								nrx = nrx - dx[i]; // R구슬을 한칸 밑으로
						}
						// 아래로 움직였던 경우
						else if (i == 1) {
							/*
							 * 원래 R B 였으면
							 */
							if (d.bx > d.rx)
								nrx = nrx - dx[i]; // R구슬을 한칸 위로
							/*
							 * 원래 B R 였으면
							 */
							else if (d.bx < d.rx)
								nbx = nbx - dx[i]; // B구슬을 한칸 위로
						}
					}
				}

				// 이미 방문했다면...
				if (chk[nrx][nry][nbx][nby] == true)
					continue;

				// 아니라면...
				chk[nrx][nry][nbx][nby] = true;
				qu.offer(new Data(nrx, nry, nbx, nby, d.count + 1)); // 움직여진 현재
																		// 빨간구슬과
																		// 파란구슬
																		// 좌표 넣고
																		// count
																		// 하나 증가
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