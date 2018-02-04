package study;

import java.util.Scanner;

public class SE2806 {

	static int testCaseCnt;// testcase 개수
	static int n;
	static int answer;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		testCaseCnt = in.nextInt();// testcase 개수 입력

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {

			n = in.nextInt();

			answer = 0;
			
			execute();// 실행

			System.out.println("#" + testCase + " " + answer);
		}
	}

	public static void execute() {
		
		if(n == 1){
			answer = 1;
			return;
		}

		// nCr개의 조합을 표현할 배열, 빈 배열에 앞쪽부터 채우면서 조합생성
		// 각 조합이 포함한 번호는 map배열의 인덱스로 쓰임
		int[] comArr = new int[n * n];

		// nC1 ~ nCr 까지의 조합 계산
		// ex)4C3 -> 4C1, 4C2, 4C3
		combination(comArr, 0, n * n, n, 0);
	}

	public static void combination(int[] comArr, int idx, int n, int r, int targetNum) {

		if (r == 0) {// 모든 수를 다 뽑았으면
			// print(comArr, idx);
			cal(comArr, idx);// 계산
		} else if (n == targetNum) {// 사용할 수가 바닥난 상태
			return;
		} else {
			comArr[idx] = targetNum;
			combination(comArr, idx + 1, n, r - 1, targetNum + 1);
			combination(comArr, idx, n, r, targetNum + 1);
		}
	}

	public static void cal(int[] comArr, int idx) {
		int[][] map = new int[n][n];

		// 퀸을 맵에 세운다
		for (int i = 0; i < idx; i++) {
			map[comArr[i] / n][comArr[i] % n] = 1;
		}

//		printMap(map);
		
		// 공격 가능여부 계산
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					// i열검사
					for (int k = 0; k < n; k++) {
						if(i == k){
							continue;
						}
						if (map[k][j] == 1) {
							return;
						}
					}

					// j행검사
					for (int k = 0; k < n; k++) {
						if (j == k) {
							continue;
						}else{
							return;
						}
					}

					// 대각검사1
					int a = i;
					int b = j;
					while(a >= 0 && b >= 0){//좌상
						if(a == i && b == j){
							continue;
						}
						if(map[a][b] == 1){
							return;
						}
						a--;
						b--;
					}
					a = i;
					b = j;
					while(a < n && a < n){//우하
						if(a == i && b == j){
							continue;
						}
						if(map[a][b] == 1){
							return;
						}
						i++;
						j++;
					}

					// 대각검사2
					a = i;
					b = j;
					while(i >= 0 && j < n){//우상
						if(a == i && b == j){
							continue;
						}
						if(map[a][b] == 1){
							return;
						}
						i--;
						j++;
					}
					a = i;
					b = j;
					while(i < n && j >= 0){//좌하
						if(a == i && b == j){
							continue;
						}
						if(map[a][b] == 1){
							return;
						}
						i++;
						j--;
					}
				}
			}
		}
		answer++;
	}

	static boolean collisionCheck(int collision) {
		if (collision > 1) {
			return true;
		} else {
			return false;
		}
	}

	public static void print(int[] comArr, int idx) {

		for (int i = 0; i < idx; i++) {
			System.out.print(comArr[i] + " ");
		}
		System.out.println();
	}

	public static void printMap(int[][] map) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
