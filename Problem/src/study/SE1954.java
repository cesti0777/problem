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

			System.out.println("#" + testCase);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	public static void execute() {
		arr[0][0] = 1;//첫칸 초기화
		int r = 0, c = 0;
		char d = 'R';
		int num = 1;
		while(true){
			if(d == 'R'){
				if(c + 1 < n && arr[r][c + 1] == 0){//오른쪽이 맵밖x, 빈칸
					c++;//오른쪽으로 이동
					num++;//번호 증가
					arr[r][c] = num;//번호 기입 
				}else{//오른쪽으로 못간다면 아래 확인해보고 갈 수 있으면 방향바꾸기
					if(r + 1 < n && arr[r + 1][c] == 0){//아래가 맵밖x, 빈칸
						d = 'D';
					}else{//아래로 못가면 종료
						return;
					}
				}
			}else if(d == 'D'){
				if(r + 1 < n && arr[r + 1][c] == 0){//아래가 맵밖x, 빈칸
					r++;//아래로 이동
					num++;//번호 증가
					arr[r][c] = num;//번호 기입 
				}else{//아래로 못간다면 왼쪽 확인해보고 갈 수 있으면 방향바꾸기
					if(c - 1 >= 0 && arr[r][c - 1] == 0){//왼쪽이 맵밖x, 빈칸
						d = 'L';
					}else{//왼쪽으로 못가면 종료
						return;
					}
				}
			}else if(d == 'L'){
				if(c - 1 >= 0 && arr[r][c - 1] == 0){//왼쪽이 맵밖x, 빈칸
					c--;//왼쪽으로 이동
					num++;//번호 증가
					arr[r][c] = num;//번호 기입 
				}else{//왼쪽으로 못간다면 위 확인해보고 갈 수 있으면 방향바꾸기
					if(r - 1 >= 0 && arr[r - 1][c] == 0){//위가 맵밖x, 빈칸
						d = 'U';
					}else{//위로 못가면 종료
						return;
					}
				}
			}else if(d == 'U'){
				if(r - 1 >= 0 && arr[r - 1][c] == 0){//위가 맵밖x, 빈칸
					r--;//위로 이동
					num++;//번호 증가
					arr[r][c] = num;//번호 기입 
				}else{//위로 못간다면 오른쪽 확인해보고 갈 수 있으면 방향바꾸기
					if(c + 1 < n && arr[r][c + 1] == 0){//오른쪽이 맵밖x, 빈칸
						d = 'R';
					}else{//오른쪽으로 못가면 종료
						return;
					}
				}
			}
		}
	}
}

















