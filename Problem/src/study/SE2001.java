package study;

import java.util.Scanner;

public class SE2001 {

	static int testCaseCnt;//testcase 개수
	static int n;//map크기
	static int m;//파리채 크기
	static int[][] map = new int[15][15];//최대 맵 크기로 고정
	static int answer;//최대 파리합

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		testCaseCnt = in.nextInt();//testcase 개수 입력

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {
			
			init();//변수 초기화

			n = in.nextInt();//map 크기 입력
			m = in.nextInt();//파리채 크기 입력

			//map 입력
			for (int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++){
					map[i][j] = in.nextInt();
				}
			}
			
			execute();//실행
			
			System.out.println("#" + testCase + " " + answer);
		}
	}

	public static void init() {
		n = 0;
		m = 0;
		answer = 0;
	}

	public static void execute() {
		//파리채 크기가 map 밖으로 나가지 않게 인덱스 조절하면서 i, j 이동
		for(int i = 0; i < n - m + 1; i++){
			for(int j = 0; j < n - m + 1; j++){
				int sum = 0;//파리합 변수
				
				//파리채 크기만큼 더하기
				//i, j 가 위치한 곳에서 파리채 크기만큼 누적합을 구한다
				for(int p = i; p < i + m; p++){
					for(int q = j; q < j + m; q++){
						sum += map[p][q];//파리 누적합
					}
				}
				
				//max 값 갱신
				answer = Math.max(answer, sum);
			}
		}
	}
}
