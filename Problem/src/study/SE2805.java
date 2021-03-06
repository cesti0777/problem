package study;

import java.util.Scanner;

public class SE2805 {

	static int testCaseCnt;//testcase 개수
	static int n;
	static int[][] map;
	static int answer;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		testCaseCnt = in.nextInt();//testcase 개수 입력

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {
			
			n = in.nextInt();
			
			in.nextLine();
			
			map = new int[n][n];

			String line;
			for(int i = 0; i < n; i++){
				line = in.nextLine();
				for(int j = 0; j < n; j++){
					map[i][j] = Integer.parseInt(line.charAt(j) + "");
				}
			}
			
			answer = 0;
			
			execute();//실행
			
			System.out.println("#" + testCase + " " + answer);
		}
	}

	public static void execute() {
		for(int i = 0; i < n; i++){//row만큼 반복
			if(i <= n / 2){//증가하는 row
				for(int j = 0; j < i * 2 + 1; j++){
					answer += map[i][n / 2 - i + j];
				}
			}else{//감소하는 row
				for(int j = 0 ; j < n - 2 * (i - n / 2)  ; j++){
					answer += map[i][i - n / 2 + j];
				}
			}
		}
	}
}