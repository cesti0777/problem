package study;

import java.util.Scanner;

public class SE2105 {

	final static int NE = 1;
	final static int SE = 2;
	final static int SW = 3;
	final static int NW = 4;
	final static int NOTURN = 5;
	final static int RIGHT = 6;
	final static int LEFT = 7;

	static int testCaseCnt;// testcase 개수
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static boolean[] visitedType;
	static int sR, sC;
	static int answer;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		testCaseCnt = in.nextInt();// testcase 개수 입력

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {

			n = in.nextInt();

			map = new int[n][n];
			visited = new boolean[n][n];
			visitedType = new boolean[101];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = in.nextInt();
				}
			}

			answer = 0;

			execute();// 실행

			System.out.println("#" + testCase + " " + answer);
		}
	}

	public static void execute() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 시작지점 기억
				sR = i;
				sC = j;
				// 경로 탐색 시작 (시작지점r, 시작지점c, 이동 방향, 방문 카페수, 턴 할 방향, 턴 횟수)
				search(sR, sC, 0, 0, NOTURN, 0);
			}
		}
		if (answer == 0) {// 정상 순회 못한 경우
			answer = -1;
		}
	}

	public static void search(int r, int c, int fromD, int cnt, int turn, int turnCnt) {

		if (r < 0 || c < 0 || r >= n || c >= n) {// map밖 체크
			return;
		} else if (turnCnt > 4) {// 최대 턴 횟수 체크
			return;
		} else if (turn != NOTURN && sR == r && sC == c) {// 시작점으로 돌아오면 답 갱신
			answer = Math.max(answer, cnt);
			return;
		} else if (visited[r][c] == false) {// 방문한 카페인지 체크
			if (visitedType[map[r][c]] == true) {// 먹은 디저트인지 체크
				return;
			}
			// 방문x, 먹은디저트x 인 경우
			visited[r][c] = true;// 방문한 카페로 체크
			visitedType[map[r][c]] = true;// 먹은 디저트로 체크

			if (cnt == 0) {// 출발전
				search(r - 1, c + 1, NE, cnt + 1, NOTURN, turnCnt);
				search(r + 1, c + 1, SE, cnt + 1, NOTURN, turnCnt);
				search(r + 1, c - 1, SW, cnt + 1, NOTURN, turnCnt);
				search(r - 1, c - 1, NW, cnt + 1, NOTURN, turnCnt);
			} else if (turn == NOTURN) {// 출발 후 ~ 턴하기 전, (반)시계방향 순회 결정
				if (fromD == NE) {
					search(r - 1, c + 1, NE, cnt + 1, NOTURN, turnCnt);
					search(r + 1, c + 1, SE, cnt + 1, RIGHT, turnCnt + 1);
					search(r - 1, c - 1, NW, cnt + 1, LEFT, turnCnt + 1);
				} else if (fromD == SE) {
					search(r + 1, c + 1, SE, cnt + 1, NOTURN, turnCnt);
					search(r + 1, c - 1, SW, cnt + 1, RIGHT, turnCnt + 1);
					search(r - 1, c + 1, NE, cnt + 1, LEFT, turnCnt + 1);
				} else if (fromD == SW) {
					search(r + 1, c - 1, SW, cnt + 1, NOTURN, turnCnt);
					search(r - 1, c - 1, NW, cnt + 1, RIGHT, turnCnt + 1);
					search(r + 1, c + 1, SE, cnt + 1, LEFT, turnCnt + 1);
				} else if (fromD == NW) {
					search(r - 1, c - 1, NW, cnt + 1, NOTURN, turnCnt);
					search(r - 1, c + 1, NE, cnt + 1, RIGHT, turnCnt + 1);
					search(r + 1, c - 1, SW, cnt + 1, LEFT, turnCnt + 1);
				}
			} else if (turn == RIGHT) {//턴 후, 시계방향 순회
				if (fromD == NE) {
					search(r - 1, c + 1, NE, cnt + 1, turn, turnCnt);
					search(r + 1, c + 1, SE, cnt + 1, turn, turnCnt + 1);
				} else if (fromD == SE) {
					search(r + 1, c + 1, SE, cnt + 1, turn, turnCnt);
					search(r + 1, c - 1, SW, cnt + 1, turn, turnCnt + 1);
				} else if (fromD == SW) {
					search(r + 1, c - 1, SW, cnt + 1, turn, turnCnt);
					search(r - 1, c - 1, NW, cnt + 1, turn, turnCnt + 1);
				} else if (fromD == NW) {
					search(r - 1, c - 1, NW, cnt + 1, turn, turnCnt);
					search(r - 1, c + 1, NE, cnt + 1, turn, turnCnt + 1);
				}
			} else if (turn == LEFT) {//턴 후, 반시계방향 순회
				if (fromD == NE) {
					search(r - 1, c + 1, NE, cnt + 1, turn, turnCnt);
					search(r - 1, c - 1, NW, cnt + 1, turn, turnCnt + 1);
				} else if (fromD == SE) {
					search(r + 1, c + 1, SE, cnt + 1, turn, turnCnt);
					search(r - 1, c + 1, NE, cnt + 1, turn, turnCnt + 1);
				} else if (fromD == SW) {
					search(r + 1, c - 1, SW, cnt + 1, turn, turnCnt);
					search(r + 1, c + 1, SE, cnt + 1, turn, turnCnt + 1);
				} else if (fromD == NW) {
					search(r - 1, c - 1, NW, cnt + 1, turn, turnCnt);
					search(r + 1, c - 1, SW, cnt + 1, turn, turnCnt + 1);
				}
			}
			visited[r][c] = false;// 방문한 카페 백트레킹
			visitedType[map[r][c]] = false;// 먹은 디저트 백트레킹
		}
	}
}