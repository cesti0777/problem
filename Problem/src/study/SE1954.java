package study;

import java.util.Scanner;

public class SE1954 {

	static int testCaseCnt;// testcase 개수
	static int n;
	static int[][] arr;
	static String answer;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		testCaseCnt = in.nextInt();// testcase 개수 입력

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {

			n = in.nextInt();

			arr = new int[n][n];

			execute();// 실행

			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	public static void execute() {
		char d = 'R';
		int c = 0;
		int r = 0;
		int curNum = 1;
		arr[r][c] = curNum;
		
		while(true){
			curNum++;
			
			if(d == 'R'){//오른쪽이고
				if(c + 1 < n){
					if(arr[r][c + 1] == 0){//오른쪽칸이 빈칸이면
						c++;//오른쪽으로 이동
						arr[r][c] = curNum;//숫자 기입
					}else{//오른쪽칸이 빈칸이 아니면
						if(arr[r + 1][c] != 0){//아래가 빈칸이 아니면 종료
							return;
						}
						d = 'D';//아래로 방향 전환
						continue;
					}
				}else{
					d = 'D';//아래로 방향 전환
					continue;
				}
			}else if(d == 'D'){//아래이고
				if(r + 1 < n){
					if(arr[r + 1][c] == 0){//아래가 빈칸이면
						r++;//아래로 이동
						arr[r][c] = curNum;//숫자 기입
					}else{//아래가 빈칸이 아니면
						if(arr[r][c - 1] != 0){//왼쪽이 빈칸이 아니면 종료
							return;
						}
						d = 'L';//아래로 방향 전환
						continue;
					}
				}else{
					d = 'L';//아래로 방향 전환
					continue;
				}
			}else if(d == 'L'){//왼쪽이고 
				if(c - 1 > -1){
					if(arr[r][c + 1] == 0){//왼쪽이 빈칸이면
						c--;//왼쪽으로 이동
						arr[r][c] = curNum;//숫자 기입
					}else{//왼쪽이 빈칸이 아니면
						if(arr[r][c - 1] != 0){//위쪽이 빈칸이 아니면 종료
							return;
						}
						d = 'U';//아래로 방향 전환continue;
					}
				}else{
					d = 'U';//아래로 방향 전환
					continue;
				}
			}else if(d == 'U'){//위쪽이고 
				if(r - 1 > -1){
					if(arr[r - 1][c] == 0){//위가 빈칸이면
						r--;//위로 이동
						arr[r][c] = curNum;//숫자 기입
					}else{//위가 빈칸이 아니면
						if(arr[r][c + 1] != 0){//오른쪽이 빈칸이 아니면 종료
							return;
						}
						d = 'R';//아래로 방향 전환
						continue;
					}
				}
				else{
					d = 'R';//아래로 방향 전환
					continue;
				}
			}
		}
	}
}
