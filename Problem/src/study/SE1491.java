package study;

import java.util.Scanner;

public class SE1491 {

	static int testCaseCnt;// testcase 개수
	static long n, a, b;
	static long answer;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		testCaseCnt = in.nextInt();// testcase 개수 입력

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {

			n = in.nextInt();
			a = in.nextInt();
			b = in.nextInt();

			answer = Integer.MAX_VALUE;
			
			execute();// 실행

			System.out.println("#" + testCase + " " + answer);
		}
	}

	public static void execute() {
		int rootN = (int)Math.sqrt(n);//정사각형 계산을 위한 루트계산
		long result = 0;//계산값
		long bigAB = Math.max(a, b);//a, b 중 큰거 선택
		
		for(long r = rootN ; r >= 1; r--){//정사각형 길이에서 1까지 줄여보기
			for(long c = rootN ; c <= bigAB; c++){//정사각형 길이에서 가능한 최대로 늘려보기
				if(r * c <= n){//총 타일 개수를 넘지 않으면
					result = a * Math.abs(r - c) + b * (n - r * c);//계산
					answer = Math.min(answer, result);//최소값 갱신
				}else{//총 타일 개수를 넘으면
					break;//다음 row를 줄이기 위해 break
				}
			}
		}
	}
}
