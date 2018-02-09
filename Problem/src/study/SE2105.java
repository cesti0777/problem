package study;

import java.util.Scanner;

public class SE2105 {

	static int testCaseCnt;//testcase 개수
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int answer;
	static boolean[] usedD = new boolean[4];
	static int sR, sC;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		testCaseCnt = in.nextInt();//testcase 개수 입력

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {
			
			n = in.nextInt();
			
			map = new int[n][n];
			visited = new boolean[n][n];
			
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					map[i][j] = in.nextInt();
				}
			}
			
			answer = 0;
			
			execute();//실행
			
			System.out.println("#" + testCase + " " + answer);
		}
	}

	public static void execute() {
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				sR = i;
				sC = j;
				search(i, j, 0, 0);
			}
		}
	}
	
	public static void search(int r, int c, int cnt, int d) {

		if(r < 0 || c < 0 || r >= n || c >= n){
			return;
		}else if((usedD[0] || usedD[1] || usedD[2] || usedD[3]) && (sR == r && sC == c)){
			answer = Math.max(answer, cnt);
			return;
		}else if(visited[r][c] == false){
			if(d == 0){
				search(r + 1, c + 1, cnt + 1, 0);
				used[]
				search(r + 1, c - 1, cnt + 1, 1);
				search(r - 1, c + 1, cnt + 1, 3);
				
			}else if(d == 1){
				
			}else if(d == 2){
				
			}else{
				
			}
			
			search(r + 1, c + 1, cnt + 1, 0);
			search(r + 1, c - 1, cnt + 1, 1);
			search(r - 1, c - 1, cnt + 1, 2);
			search(r - 1, c + 1, cnt + 1, 3);
			
		}
		
	}
}