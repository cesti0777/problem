package problem.if_;

import java.util.Scanner;

public class p10817 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		try{
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			
			if(a >= b){
				if(a >= c){
					if(b >= c){
						System.out.println(b);
					}else{
						System.out.println(c);
					}
				}else{
					System.out.println(a);
				}
			}else{
				if(b >= c){
					if(a >= c){
						System.out.println(a);
					}else{
						System.out.println(c);
					}
				}else{
					System.out.println(b);
				}
			}
		}finally {
			in.close();
			in = null;
		}
	}
}
