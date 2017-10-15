package samsung.practice1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P14502 {
	static int[][] map = new int[8][8];
	static int[][] copyMap = new int[8][8];
	static int[] selectedWall = new int[64];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int n;
	static int m;
	static int max = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		in.nextLine();

		// 맵 저장
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = in.nextInt();
			}
		}

		// 벽 세울 3자리 뽑는 루프
		for (int i = 0; i < n * m - 2; i++) {
			for (int j = i + 1; j < n * m - 1; j++) {
				for (int k = j + 1; k < n * m; k++) {

					// selectedWall 초기화
					for (int a = 0; a < 64; a++) {
						selectedWall[a] = 0;
					}

					selectedWall[i] = 1;
					selectedWall[j] = 1;
					selectedWall[k] = 1;

					// 맵 복사
					for (int a = 0; a < n; a++) {
						for (int b = 0; b < m; b++) {
							copyMap[a][b] = map[a][b];
						}
					}
					
					// 벽 세우기
					int cnt = 0;
					for (int a = 0; a < n; a++) {
						for (int b = 0; b < m; b++) {
							if (map[a][b] == 0 && selectedWall[a * m + b] == 1) {//
								copyMap[a][b] = 1;
								cnt++;
							}
						}
					}

					// 벽 3개를 못 세웠으면 continue
					if (cnt != 3) {
						continue;
					}

					// 바이러스 위치 큐에 푸시
					Queue<Integer> q = new LinkedList<Integer>();
					for (int a = 0; a < n; a++) {
						for (int b = 0; b < m; b++) {
							if (copyMap[a][b] == 2) {
								q.add(a);
								q.add(b);
							}
						}
					}

					// 바이러스 확산
					while (!q.isEmpty()) {
						int r = q.remove();
						int c = q.remove();

						// 4방향 확인 후 감염
						for (int a = 0; a < 4; a++) {
							if (r + dr[a] >= 0 && r + dr[a] < n && c + dc[a] >= 0 && c + dc[a] < m) {
								if (copyMap[r + dr[a]][c + dc[a]] == 0) {
									copyMap[r + dr[a]][c + dc[a]] = 2;
									q.add(r + dr[a]);
									q.add(c + dc[a]);
								}
							}
						}
					}

					// 안전지역 카운트
					int safe = 0;
					for (int a = 0; a < n; a++) {
						for (int b = 0; b < m; b++) {
							if (copyMap[a][b] == 0) {
								safe++;
							}
						}
					}

					// 안전지역 최대값 갱신
					max = Math.max(max, safe);

				} // end k for loop
			} // end j for loop
		} // end i for loop

		// 결과값 출력
		System.out.println(max);

	}// end main()
}
