package study;

import java.util.Scanner;

public class SEbase {

	static int testCaseCnt;//testcase 개수
	static int answer;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		testCaseCnt = in.nextInt();//testcase 개수 입력

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {
			
			execute();//실행
			
			System.out.println("#" + testCase + " " + answer);
		}
	}

	public static void execute() {
		
	}

}