package study;

import java.util.Scanner;

public class SE1493 {

	static int testCaseCnt;//testcase 개수
	static int answer;
	static int n;
	static int p, q;
	static int[][] map = new int[501][501];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		testCaseCnt = in.nextInt();//testcase 개수 입력

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {
			
			p = in.nextInt();
			q = in.nextInt();
			
            answer = 0;
            
			execute(testCase);//실행
			
			System.out.println("#" + testCase + " " + answer);
		}
	}
	
	public static void execute(int testCase) {
		
		//수열 생성
		int rS = 0;
		int cS = 0;
		int rD = 1;
		int cD = 1;
		int[] pStep1 = new int[2];
		int[] qStep1 = new int[2];
		for(int i = 1; i <= 500; i++){
			rS += rD;
			cS = rS;
			cD = rD;
			for(int j = 1; j <= 500; j++){
				if(cS == p){
					pStep1[0] = i;
					pStep1[1] = j;
				}
				if(cS == q){
					qStep1[0] = i;
					qStep1[1] = j;
				}
				map[i][j] = cS;
				cS += cD;
				cD++;
			}
			cD = 0;
			rD++;
		}
		
		//계산	
		answer = map[pStep1[0] + qStep1[0]][pStep1[1] + qStep1[1]];
	}
}