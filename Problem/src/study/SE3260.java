package study;

import java.math.BigInteger;
import java.util.Scanner;

public class SE3260 {

	static int testCaseCnt;//testcase 개수
//	static BigInteger a, b;
//	static BigInteger answer;
	static double a, b;
	static String answer;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		testCaseCnt = in.nextInt();//testcase 개수 입력

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {
			
			a = in.nextDouble();
			b = in.nextDouble();
			answer = Double.toString(a + b);
			
			System.out.println("#" + testCase + " " + answer);
		}
	}
}