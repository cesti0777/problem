package study;

import java.util.Scanner;

public class SE2817 {

	static int testCaseCnt;//testcase 개수
	static int n, k;
	static int nums[] = new int[20];
	static int answer;

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		testCaseCnt = in.nextInt();//testcase 개수 입력

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {
			
			n = in.nextInt();
			k = in.nextInt();
			for(int i = 0; i < n; i++){
				nums[i] = in.nextInt();
			}
			
			answer = 0;
			
			execute();//실행
			
			System.out.println("#" + testCase + " " + answer);
		}
	}

	public static void execute() {

		int[] idxArr = new int[n];
		
		for(int i = 1; i <= n; i++){
			combination(idxArr, 0, n, i, 0);	
		}
	}
	
	public static void combination(int[] idxArr, int idx, int n, int r, int targetIdx){
		
		if(r == 0){
//			print(idxArr, idx);
			cal(idxArr, idx);
		}else if(n == targetIdx){
			return;
		}else{
			idxArr[idx] = targetIdx;
			combination(idxArr, idx + 1, n, r - 1, targetIdx + 1);
			combination(idxArr, idx, n, r, targetIdx + 1);
		}
	}
	
	public static void cal(int[] idxArr, int idx){
		
		int sum = 0;
		for(int i = 0; i < idx; i++){
			sum += nums[idxArr[i]];
		}
		if(sum == k){
			answer++;
		}
	}
	public static void print(int[] idxArr, int idx){
		
		for(int i = 0; i < idx; i++){
			System.out.print(nums[idxArr[i]] + " ");
		}
		System.out.println();
	}
}
