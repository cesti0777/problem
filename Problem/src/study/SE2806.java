package study;

import java.util.Scanner;

public class SE2806 {

	static int testCaseCnt;// testcase 개수
	static int N;
	static int answer;
	static int[][] map;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		testCaseCnt = in.nextInt();// testcase 개수 입력

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {

			N = in.nextInt();

			answer = 0;

			execute();// 실행

			System.out.println("#" + testCase + " " + answer);
		}
	}

	public static void execute() {

		if (N == 1) {
			answer = 1;
			return;
		}

		// nCr개의 조합을 표현할 배열, 빈 배열에 앞쪽부터 채우면서 조합생성
		// 각 조합이 포함한 번호는 map배열의 인덱스로 쓰임
		int[] comArr = new int[N * N];

		// nC1 ~ nCr 까지의 조합 계산
		// ex)4C3 -> 4C1, 4C2, 4C3
		combination(comArr, 0, N * N, N, 0);
	}

	public static void combination(int[] comArr, int idx, int n, int r, int targetNum) {

		if (idx != 0 && isCollision(comArr, idx)) {
			return;
		} else if (r == 0) {// 모든 수를 다 뽑았으면
			answer++;
			// print(comArr, idx);
			// cal(comArr, idx);// 계산
		} else if (n == targetNum) {// 사용할 수가 바닥난 상태
			return;
		} else {
			comArr[idx] = targetNum;
			combination(comArr, idx + 1, n, r - 1, targetNum + 1);
			combination(comArr, idx, n, r, targetNum + 1);
		}
	}

	public static boolean isCollision(int[] comArr, int idx) {
		map = new int[N][N];

		// 퀸을 맵에 세운다
		for (int i = 0; i < idx; i++) {
			map[comArr[i] / N][comArr[i] % N] = 1;
		}
		
		//마지막에 세운 퀸 계산
		int i = comArr[idx - 1] / N;
		int j = comArr[idx - 1] % N;

		// 공격 가능여부 계산
		if (map[i][j] == 1) {
			// i열검사
			for (int k = 0; k < N; k++) {
				if (i == k) {
					continue;
				}
				if (map[k][j] == 1) {
					return true;
				}
			}

			// j행검사
			for (int k = 0; k < N; k++) {
				if (j == k) {
					continue;
				}
				if (map[i][k] == 1) {
					return true;
				}
			}

			// 대각검사1
			int a = i - 1;
			int b = j - 1;
			while (a >= 0 && b >= 0) {// 좌상
				if (map[a][b] == 1) {
					return true;
				}
				a--;
				b--;
			}
			a = i + 1;
			b = j + 1;
			while (a < N && b < N) {// 우하
				if (map[a][b] == 1) {
					return true;
				}
				a++;
				b++;
			}

			// 대각검사2
			a = i - 1;
			b = j + 1;
			while (a >= 0 && b < N) {// 우상
				if (map[a][b] == 1) {
					return true;
				}
				a--;
				b++;
			}
			a = i + 1;
			b = j - 1;
			while (a < N && b >= 0) {// 좌하
				if (map[a][b] == 1) {
					return true;
				}
				a++;
				b--;
			}
		}
		// answer++;
		return false;
	}

	public static void print(int[] comArr, int idx) {

		for (int i = 0; i < idx; i++) {
			System.out.print(comArr[i] + " ");
		}
		System.out.println();
	}

	public static void printMap(int[][] map) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
