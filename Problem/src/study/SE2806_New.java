package study;

import java.util.Scanner;

public class SE2806_New {

	static int testCaseCnt;// testcase 개수
	static int n;
	static int[][] map;
	static int answer;
	static int[] d1 = {-1, -1, 1, 1};
	static int[] d2 = {-1, 1, -1, 1};
	final static int fill = 0;
	final static int back = 1;

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
		
		map = new int[n][n];
		buildQeen(0);
	}
	
	public static void buildQeen(int r) {
		
		if(r == n){
			answer++;
			return;
		}else{
			for(int i = 0; i < n; i++){
				if(map[r][i] == 0){
					fillOrBack(r, i, fill);
					printMap(map);
					buildQeen(r + 1);
					fillOrBack(r, i, back);
				}
			}
		}
	}
	
	public static void fillOrBack(int r, int c, int flag) {
		
		int value1;
		int value2;
		
		if(flag == fill){
			value1 = 0;
			value2 = r + 1;
		}else{
			value1 = r + 1;
			value2 = 0;
		}
		
		for(int i = 0; i < n; i++){
			if(map[r][i] == value1){
				map[r][i] = value2;
			}
			if(map[i][c] == value1){
				map[i][c] = value2;
			}
		}
		
		for(int i = 0; i < 4; i++){
			int a = r + d1[i];
			int b = c + d2[i];
			while (a >= 0 && b >= 0 && a < n  && b < n) {
				if(map[a][b] == value1){
					map[a][b] = value2;
				}
				a += d1[i];
				b += d2[i];
			}
		}
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
