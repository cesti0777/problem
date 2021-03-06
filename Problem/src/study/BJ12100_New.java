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

		Queue<Object> q = new LinkedList<Object>();//bfs 큐
		q.add(map);
		q.add(0);
		
		while (!q.isEmpty()) {
			curMap = (int[][]) q.remove();
			totalCnt = (int) q.remove();

			if (totalCnt == 5) {//탈출 조건, 이동 5회 했으면
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if(curMap[i][j] != 0){
							answer = Math.max(answer, curMap[i][j]);//제일 큰 값으로 답 갱신
						}
					}
				}
				continue;
			}
			

			// 상
			cloneMap = cloneMap(curMap);////이동전 맵상태 복사, 다른방향으로 이동할 때 원상태를 써야 하므로
			for (int j = 0; j < n; j++) {// 열 순회, 고정
				// 합치기
				for (int i = 0; i < n - 1; i++) {// 행 순회
					if (cloneMap[i][j] == 0) {//빈칸 건너 뛰기
						continue;
					}
					//숫자 발견하면 위치 기억
					curR = i;
					for (int k = i + 1; k < n; k++) {// 다음 행 탐색
						if (cloneMap[k][j] != 0) {// 수 발견
							if (cloneMap[curR][j] == cloneMap[k][j]) {// 같은 수
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
				
				// 밀기
				full = 0;// 현재 빈 인덱스
				tmp = 0;
				for (int i = 0; i < n; i++) {// 행 순회
					if (cloneMap[i][j] != 0) {// 수 발견
						tmp = cloneMap[i][j];
						cloneMap[i][j] = 0;
						cloneMap[full][j] = tmp;
						full++;
					}
				}
			}
			q.add(cloneMap);
			q.add(totalCnt + 1);

			// 하
			cloneMap = cloneMap(curMap);
			for (int j = 0; j < n; j++) {// 열 순회
				// 합치기
				for (int i = n - 1; i > 0; i--) {// 행 순회
					if (cloneMap[i][j] == 0) {
						continue;
					}
					//숫자 발견하면 위치 기억
					curR = i;
					for (int k = i - 1; k >= 0; k--) {// 다음 행 탐색
						if (cloneMap[k][j] != 0) {// 수 발견
							if (cloneMap[curR][j] == cloneMap[k][j]) {// 같은 수
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
				// 밀기
				full = n - 1;// 현재 빈 인덱스
				tmp = 0;
				for (int i = n - 1; i >= 0; i--) {// 행 순회
					if (cloneMap[i][j] != 0) {// 수 발견
						tmp = cloneMap[i][j];
						cloneMap[i][j] = 0;
						cloneMap[full][j] = tmp;
						full--;
					}
				}
			}
			q.add(cloneMap);
			q.add(totalCnt + 1);

			// 좌
			cloneMap = cloneMap(curMap);
			for (int i = 0; i < n; i++) {// 행 순회
				// 합치기
				for (int j = 0; j < n - 1; j++) {// 열 순회
					if (cloneMap[i][j] == 0) {
						continue;
					}
					//숫자 발견하면 위치 기억
					curC = j;
					for (int k = j + 1; k < n; k++) {// 다음 열 탐색
						if (cloneMap[i][k] != 0) {// 수 발견
							if (cloneMap[i][curC] == cloneMap[i][k]) {// 같은  수
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
				// 밀기
				full = 0;// 현재 빈 인덱스
				tmp = 0;
				for (int j = 0; j < n; j++) {// 열 순회
					if (cloneMap[i][j] != 0) {// 수 발견
						tmp = cloneMap[i][j];
						cloneMap[i][j] = 0;
						cloneMap[i][full] = tmp;
						full++;
					}
				}
			}
			q.add(cloneMap);
			q.add(totalCnt + 1);

			// 우
			cloneMap = cloneMap(curMap);
			for (int i = 0; i < n; i++) {// 행 순회
				// 합치기
				for (int j = n - 1; j > 0; j--) {// 열 순회
					if (cloneMap[i][j] == 0) {
						continue;
					}
					//숫자 발견하면 위치 기억
					curC = j;
					for (int k = j - 1; k >= 0; k--) {// 다음 열 탐색
						if (cloneMap[i][k] != 0) {// 수 발견
							if (cloneMap[i][curC] == cloneMap[i][k]) {// 같은 수
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
				// 밀기
				full = n - 1;// 현재 빈 인덱스
				tmp = 0;
				for (int j = n - 1; j >= 0; j--) {// 열 순회
					if (cloneMap[i][j] != 0) {// 수 발견
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
