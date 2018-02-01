package study;

import java.util.Scanner;

public class SE1926 {
	static long n;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		n = in.nextInt();

		execute();// 실행

	}

	public static void execute() {
		String s;//숫자 문자열화 해서 저장할 변수
		int cnt = 0;//3,6,9 개수 저장 변수
		for (int i = 1; i <= n; i++) {//입력 숫자만큼 반복
			cnt = 0;//매번 0으로 초기화
			s = i + "";//숫자 문자열화
			for (int j = 0; j < s.length(); j++) {//문자열 길이만큼 반복
				if (s.charAt(j) == '3' || s.charAt(j) == '6' || s.charAt(j) == '9') {//3,6,9 개수 카운트
					cnt++;//카운트 증가
				}
			}
			if (cnt != 0) {//3,6,9 카운딩 됐으면
				for (int j = 0; j < cnt; j++) {//3,6,9 개수만큼 - 출력
					System.out.print("-");
				}
				System.out.print(" ");
			} else {//3,6,9 없으면 문자열 그대로 출력
				System.out.print(s + " ");
			}
		}
	}
}
