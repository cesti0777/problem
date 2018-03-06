package study;

import java.util.Scanner;

public class BJ3190_Today {
	static int[][] map;//맵
	static int n;//맵크기
	static int k;//사과개수
	static int l;//방향변환개수
	static Object[][] d;//방향 전환 정보
	static int curLen;//현재 뱀 길이
	static int[] dR = {-1, 1, 0 ,0};
	static int[] dC = {0, 0, -1 ,1};

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();//맵 크기 입력
		k = in.nextInt();//사과 개수 입력
		
		// 사과(-1) 위치 설정
		map = new int[n][n];
		for (int i = 0; i < k; i++) {
			map[in.nextInt() - 1][in.nextInt() - 1] = -1;
		}

		l = in.nextInt();//방향 전환 개수
		
		// 방향 전환 정보 저장
		d = new Object[l][2];//방향 전환 시간(초), 방향(L or D) 
		for (int i = 0; i < l; i++) {
			d[i][0] = in.nextInt();
			d[i][1] = in.next();
		}

		int curS = 0;//현재 시간
		char curD = 'R';//현재 머리 방향
		int curDCIdx = 0;//현재 방향 전환 인덱스
		int r = 0;//머리위치 행
		int c = 0;//머리위치 열
		curLen = 1;//현재 길이
		map[r][c] = 1;//머리 생성

		while (true) {
			curS++;//시간 증가
			if (curD == 'R') {
				if (c + 1 >= n || map[r][c + 1] > 0) {//벽 or몸통
					System.out.println(curS);
					return;
				} else if (map[r][c + 1] == -1) {//사과
					curLen++;//길이 늘리기
					map[r][c + 1] = curLen;//머리를 현재 길이로 표시
					c++;//머리 위치 이동
				} else {
					map[r][c + 1] = curLen;//머리를 현재 길이로 표시
					move(r, c + 1);//몸통 이동
					c++;//머리 위치 이동
				}

			} else if (curD == 'D') {
				if (r + 1 >= n || map[r + 1][c] > 0) {
					System.out.println(curS);
					return;
				} else if (map[r + 1][c] == -1) {
					curLen++;
					map[r + 1][c] = curLen;
					r++;
				} else {
					map[r + 1][c] = curLen;
					move(r + 1, c);
					r++;
				}
			} else if (curD == 'L') {
				if (c - 1 < 0 || map[r][c - 1] > 0) {
					System.out.println(curS);
					return;
				} else if (map[r][c - 1] == -1) {
					curLen++;
					map[r][c - 1] = curLen;
					c--;
				} else {
					map[r][c - 1] = curLen;
					move(r, c - 1);
					c--;
				}
			} else if (curD == 'U') {
				if (r - 1 < 0 || map[r - 1][c] > 0) {
					System.out.println(curS);
					return;
				} else if (map[r - 1][c] == -1) {
					curLen++;
					map[r - 1][c] = curLen;
					r--;
				} else {
					map[r - 1][c] = curLen;
					move(r - 1, c);
					r--;
				}
			}

			if (curDCIdx < l) {//방향 전환이 남아 있다면
				if ((int)d[curDCIdx][0] == curS) {//방향 전환 시간이 현재 시간과 같다면
					if (((String)d[curDCIdx][1]).equals("D")) {//방향 전환이 오른쪽이면
						if (curD == 'R') {//현재 머리 방향이 오른쪽이면
							curD = 'D';//아래로 변경
						} else if (curD == 'D') {
							curD = 'L';
						} else if (curD == 'L') {
							curD = 'U';
						} else if (curD == 'U') {
							curD = 'R';
						}
					} else if (((String)d[curDCIdx][1]).equals("L")) {//방향 전환이 왼쪽이면
						if (curD == 'R') {
							curD = 'U';
						} else if (curD == 'D') {
							curD = 'R';
						} else if (curD == 'L') {
							curD = 'D';
						} else if (curD == 'U') {
							curD = 'L';
						}
					}
					curDCIdx++;//다음 방향 전환 인덱스로 변경
				}
			}
		} // end while
	}// end main
	
	//제일 큰 번호가 매겨진 머리를 시작으로 
	//내림차순으로 번호를 감소시키면서 
	//몸통이 이동되는 효과를 만든다
	//ex) 12345(5) -> 1234(4)5 -> 123(3)45 -> 12(2)345 -> 1(1)2345 -> 12345
	private static void move(int r, int c) {
		for(int i =  0; i < 4; i++){//상하좌우
			int curR = r + dR[i];
			int curC = c + dC[i];
			if(curR < n && curR >= 0 && curC < n && curC >= 0){//영역체크
				if(map[r][c] == map[curR][curC]){//현재 탐색중인 몸통번호와 같은 몸통번호 발견시
					if(map[curR][curC] == 1){//꼬리발견
						map[curR][curC]--;//꼬리제거
						return;//탐색종료
					}
					map[curR][curC]--;//몸통번호 감소
					move(curR, curC);//다음 몸통 찾아서 이동
					return;
				}
			}
		}
	}
}
