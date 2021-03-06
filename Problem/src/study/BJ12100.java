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

		// 맵 입력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = in.nextInt();
			}
		}

		Queue<Map> q = new LinkedList<Map>();//bfs 큐
		q.add(new Map(map, 0));//Map class inqueue (맵,이동횟수)

		while (!q.isEmpty()) {

			Map m = q.remove();//dequeue, (m.map:현재까지 이동한 맵상태, m.cnt:현재까지 이동횟수)

			if (m.cnt == 5) {
				countMax(m);
				continue;
			}

			int tmpI = 0;//이곳에 합칠거임
			int tmpJ = 0;//이곳에 합칠거임
			
			// 상
			cloneMap = cloneMap(m);//이동전 맵상태를 복사해옴, 다른방향으로 이동할때 원상태를 써야 하므로
			for (int j = 0; j < n; j++) {//열 고정
				int cnt = 0;//합치고 남은 숫자 개수 저장
				for (int i = 0; i < n; i++) {//행 이동
					if (cloneMap.map[i][j] > 0) {//빈칸이 아니면, 숫자이면
						tmpI = i;//현재 숫자 위치 저장
						cnt++;//남게 될 숫자 이므로 개수 증가
						if (i < n - 1) {//현재 숫자가 제일 끝이 아니면
							for (int k = i + 1; k < n; k++) {//현재 숫자 다음 위치부터 끝까지
								if (cloneMap.map[k][j] > 0) {//빈칸이 아니면, 숫자이면
									if (cloneMap.map[k][j] == cloneMap.map[tmpI][j]) {//현재 숫자와 같은지 검사
										cloneMap.map[tmpI][j] *= 2;//2배 해줌  = 합침
										cloneMap.map[k][j] = 0;//이동한 숫자 제거
										i = k - 1;//탐색 안한 행으로 건너뛰기
										break;
									} else {
										i = k - 1;//탐색 안한 행으로 건너뛰기
										break;
									}
								}
							}
						}
					}
				}
				int tmp = 0;
				for (int i = 0; i < cnt; i++) {//남아있는 숫자 갯수 만큼 반복
					for (int k = i; k < n; k++) {//맨 앞 빈칸 부터 끝까지 돌면서
						if (cloneMap.map[k][j] > 0) {//빈칸이 아니면, 숫자이면
							tmp = cloneMap.map[k][j];
							cloneMap.map[k][j] = 0;//이동한 숫자 제거
							cloneMap.map[i][j] = tmp;
							break;
						}
					}
				}
			}

			cloneMap.cnt++;//이동 횟수 증가
			q.add(cloneMap);//이동 완료한 맵상태 inqueue

			// 하
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

			// 좌
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

			// 우
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