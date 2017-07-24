package problem.if_;

import java.util.Scanner;

public class p10871 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		try{
			int n = in.nextInt();
			int x = in.nextInt();
			int[] array = new int[n];
			for(int i = 0; i < n; i++){
				array[i] = in.nextInt();
			}
			
			for(int i = 0; i < array.length ; i++){
				if(array[i] < x){
					System.out.print(array[i]+" ");
				}
			}
		}finally {
			in.close();
			in = null;
		}
	}

}
