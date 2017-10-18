package samsung.practice1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P14501 {
	
	static int n;
	static int[][] day = new int[15][2];
	static int max;

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		//day 갯수 입력
		n = in.nextInt();
		
		//day 정보 입력
		for(int i = 0; i < n; i++){
			day[i][0] = in.nextInt();
			day[i][1] = in.nextInt();
		}

		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < n; i++){
			q.add(i); q.add(day[i][0]); q.add(day[i][1]);  q.add(0);
		}
		
		while(!q.isEmpty()){
			int dNum = q.remove();
			int t = q.remove();
			int p = q.remove();
			int totalPay = q.remove();
			
			if(dNum + t > n){
				continue;
			}
			
			totalPay += p;
			
			for(int i = dNum + t; i < n; i++){
				q.add(i); q.add(day[i][0]); q.add(day[i][1]); q.add(totalPay);
			}
			max = Math.max(max, totalPay);
		}
		System.out.println(max);
	}
}
