package study;

import java.util.Scanner;

public class SEbase {

	static int testCaseCnt;//testcase ����
	static int answer;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		testCaseCnt = in.nextInt();//testcase ���� �Է�

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {
			
			execute();//����
			
			System.out.println("#" + testCase + " " + answer);
		}
	}

	public static void execute() {
		
	}

}