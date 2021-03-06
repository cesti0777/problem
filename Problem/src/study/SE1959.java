package study;

import java.util.Scanner;

public class SE1959 {

	static int testCaseCnt;//testcase 개수
	static int n;
	static int m;
	static int[] a;
	static int[] b;
	static int answer;
	static int big, small;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		testCaseCnt = in.nextInt();//testcase 개수 입력

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {
			
			n = in.nextInt();
			m = in.nextInt();
			
			big = Math.max(n, m);
			small = Math.min(n, m);
			
			a = new int[big];//긴거 받을 배열
			b = new int[big];//짧은거 받을 배열
			
			if(n > m){
				for(int i = 0; i < n; i++){
					a[i] = in.nextInt();
				}
				for(int i = 0; i < m; i++){
					b[i] = in.nextInt();
				}
			}else{
				for(int i = 0; i < n; i++){
					b[i] = in.nextInt();
				}
				for(int i = 0; i < m; i++){
					a[i] = in.nextInt();
				}
			}
			
			answer = 0;
			
			execute();//실행
			
			System.out.println("#" + testCase + " " + answer);
		}
	}

	public static void execute() {
		for(int i = 0; i < big - small + 1; i++){
			move(i);
			
			//계산
			int cnt = 0;
			int result = 0;
			int idx = 0;
			while(cnt < small){
				result += a[i + idx] * b[i + idx];
				cnt++;
				idx++;
			}
				
			answer = Math.max(result, answer);
		}
	}
	
	public static void move(int i){
		if(i == 0){
			return;
		}else{
			//배열 맨 끝 찾기
			int tail = i + small - 2;
			
			for(int j = 0; j < small; j++){
				b[tail + 1] = b[tail];
				b[tail] = 0;
				tail--;
			}
		}
	}

}