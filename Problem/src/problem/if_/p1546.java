package problem.if_;

import java.util.Scanner;

public class p1546 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		try{
			int n = in.nextInt();
			int[] score = new int[n];
			for(int i = 0; i < n; i++){
				score[i] = in.nextInt();
			}
			int max = score[0];
			for(int i = 1; i < n; i++){
				if(max < score[i]){
					max = score[i];
				}
			}
			float sum = 0;
			for(int i = 0; i < n; i++){
				sum += (float)score[i]/(float)max*100;
			}
			System.out.println(String.format("%.2f" , sum/(float)n));
		}finally {
			in.close();
			in = null;
		}
	}
}