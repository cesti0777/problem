package study;

import java.util.ArrayList;
import java.util.Scanner;

public class SE1289 {

	static int testCaseCnt;// testcase 개수
	static String[] nums;
	static String[] makeNum;
	static int answer;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		testCaseCnt = in.nextInt();// testcase 개수 입력

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {

			nums = in.next().split("");

			makeNum = new String[nums.length];
			
			for(int i = 0; i < makeNum.length; i++){
				makeNum[i] = "0";
			}
			
			answer = 0;

			execute();// 실행

			System.out.println("#" + testCase + " " + answer);
		}
	}

	public static void execute() {
		for(int i = 0; i < makeNum.length; i++){
			if(nums[i].equals(makeNum[i])){
				continue;
			}
			
			answer++;
			
			for(int j = i; j < makeNum.length; j++){
				makeNum[j] = nums[i];
			}
		}
	}
}