package samsung.practice1;

import java.util.Scanner;

public class P13458 {
	static int n;
	static int[] a = new int[1000000];
	static int b, c;
	static long total;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		
		for(int i = 0; i < n; i++){
			a[i] = in.nextInt();
		}
		
		b = in.nextInt();
		c = in.nextInt();
		
		int cnt = 0;
		for(int i = 0; i < n; i++){
			if(b > a[i]){
				cnt = 0;
			}else{
				cnt = a[i] - b; // i시험장 총감독관 배치 후 남은 관리 대상 인원 
			}
			total += Math.ceil((float)cnt / (float)c) + 1;
		}
		System.out.println(total);
	}
}
