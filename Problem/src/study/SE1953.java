package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SE1953 {

	final static int UP = 100;
	final static int DOWN = 101;
	final static int LEFT = 102;
	final static int RIGHT = 103;

	static int testCaseCnt;// testcase 개수
	static int n, m, r, c, l;
	static int[][] map;
	static int answer;
	static int[] dR = {-1, 1, 0, 0};
	static int[] dC = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		testCaseCnt = in.nextInt();// testcase 개수 입력

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {

			n = in.nextInt();
			m = in.nextInt();
			r = in.nextInt();
			c = in.nextInt();
			l = in.nextInt();

			map = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] = in.nextInt();
				}
			}

			answer = 0;

			execute(1);// 실행

			System.out.println("#" + testCase + " " + answer);
		}
	}

	public static void execute(int h) {
		Queue<Data> q = new LinkedList<>();//bfs 큐
		q.add(new Data(r, c, h));
		
		while(!q.isEmpty()){
			Data data = q.remove();
			int curR = data.r;
			int curC = data.c;
			int curH = data.h;
			
			if (curH > l) {// 탈출 조건
				return;
			}
			
			if(map[curR][curC] == -1){//방문 검사
				continue;
			}

			int curPipe = map[curR][curC];// 현재 위치 파이프 종류 저장
			map[curR][curC] = -1;// 현재 위치 방문 체크
			answer++;//답 증가
			
			for(int i = 0; i < 4; i++){
				int mR = curR + dR[i];
				int mC = curC + dC[i];
				if(mR >= 0 && mR < n && mC >= 0 && mC < m){//맵 영역 체크
					if (map[mR][mC] != 0 && isPossible(curPipe, map[mR][mC], UP + i)) {
						q.add(new Data(mR, mC, curH + 1));
					}
				}		
			}
		}//end while
	}//end execute
	
	//현재 통로 타입, 이동후 통로 타입, 이동 방향에 따른 이동 가능 여부를 반환해 주는 함수
	public static boolean isPossible(int curPipe, int afterPipe, int d) {
		if (curPipe == 1) {// 상하좌우
			if (d == UP && (afterPipe == 1 || afterPipe == 2 || afterPipe == 5 || afterPipe == 6)) {
				return true;
			} else if (d == DOWN && (afterPipe == 1 || afterPipe == 2 || afterPipe == 4 || afterPipe == 7)) {
				return true;
			} else if (d == LEFT && (afterPipe == 1 || afterPipe == 3 || afterPipe == 4 || afterPipe == 5)) {
				return true;
			} else if (d == RIGHT && (afterPipe == 1 || afterPipe == 3 || afterPipe == 6 || afterPipe == 7)) {
				return true;
			}
		} else if (curPipe == 2) {// 상하
			if (d == UP && (afterPipe == 1 || afterPipe == 2 || afterPipe == 5 || afterPipe == 6)) {
				return true;
			} else if (d == DOWN && (afterPipe == 1 || afterPipe == 2 || afterPipe == 4 || afterPipe == 7)) {
				return true;
			}
		} else if (curPipe == 3) {// 좌우
			if (d == LEFT && (afterPipe == 1 || afterPipe == 3 || afterPipe == 4 || afterPipe == 5)) {
				return true;
			} else if (d == RIGHT && (afterPipe == 1 || afterPipe == 3 || afterPipe == 6 || afterPipe == 7)) {
				return true;
			}
		} else if (curPipe == 4) {// 상우
			if (d == UP && (afterPipe == 1 || afterPipe == 2 || afterPipe == 5 || afterPipe == 6)) {
				return true;
			}else if (d == RIGHT && (afterPipe == 1 || afterPipe == 3 || afterPipe == 6 || afterPipe == 7)) {
				return true;
			}
		} else if (curPipe == 5) {// 하우
			if (d == DOWN && (afterPipe == 1 || afterPipe == 2 || afterPipe == 4 || afterPipe == 7)) {
				return true;
			}else if (d == RIGHT && (afterPipe == 1 || afterPipe == 3 || afterPipe == 6 || afterPipe == 7)) {
				return true;
			}
		} else if (curPipe == 6) {// 하좌
			if (d == DOWN && (afterPipe == 1 || afterPipe == 2 || afterPipe == 4 || afterPipe == 7)) {
				return true;
			} else if (d == LEFT && (afterPipe == 1 || afterPipe == 3 || afterPipe == 4 || afterPipe == 5)) {
				return true;
			}
		} else {// 상좌
			if (d == UP && (afterPipe == 1 || afterPipe == 2 || afterPipe == 5 || afterPipe == 6)) {
				return true;
			}else if (d == LEFT && (afterPipe == 1 || afterPipe == 3 || afterPipe == 4 || afterPipe == 5)) {
				return true;
			}
		}
		return false;
	}
	
	public static class Data{
		int r;
		int c;
		int h;
		
		public Data(int r, int c, int h) {
			this.r = r;
			this.c = c;
			this.h = h;
		}
	}
}