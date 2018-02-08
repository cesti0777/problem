package study;

import java.util.Scanner;

public class SE3431 {
	static int testCaseCnt;//testcase 개수
	static int l, u, x;
	static int answer;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		testCaseCnt = in.nextInt();//testcase 개수 입력

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {
			
			l = in.nextInt();
			u = in.nextInt();
			x = in.nextInt();
			
			answer = 0;
			
			execute();//실행
			
			System.out.println("#" + testCase + " " + answer);
		}
	}

	public static void execute() {
		if(x > u){
			answer = -1;
		}else if(x < l){
			answer = l - x;
		}
	}
}
