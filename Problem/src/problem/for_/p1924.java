package problem.for_;

import java.util.Scanner;

public class p1924 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String result = null;
		try{
			int m = in.nextInt();
			int d = in.nextInt();
			int end = 0;
			for(int i = 1; i < m; i++){
				switch(i){
				case 1 : 
				case 3 : 
				case 5 : 
				case 7 : 
				case 8 : 
				case 10 : 
				case 12 :
					end += 31;
					break;
				case 4 : 
				case 6 : 
				case 9 : 
				case 11 : 
					end += 30;
					break;
				case 2 :
					end += 28;
					break;
				}
			}
			end += d;
			end %= 7;
			
			switch(end){
			case 1 : 
				result = "MON";
				break;
			case 2 : 
				result = "TUE";
				break;
			case 3 : 
				result = "WED";
				break;
			case 4 : 
				result = "THU";
				break;
			case 5 :
				result = "FRI";
				break;
			case 6 :
				result = "SAT";
				break;
			case 0 :
				result = "SUN";
				break;
			
			}
			System.out.println(result);
		}finally {
			in.close();
			in = null;
		}
	}

}
