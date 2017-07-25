package problem.if_;

import java.util.Scanner;

public class p4344 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		try{
			int c = in.nextInt();
			in.nextLine();
			String[][] s = new String[c][];
			for(int i = 0 ; i < c ; i++){
				s[i] = in.nextLine().split(" ");
			}
			for(int i = 0 ; i < c ; i++){
				float result = 0;
				for(int j = 0; j < Integer.parseInt(s[i][0]) ; j++){
					result += Float.parseFloat(s[i][j+1]);
				}
				result /= Float.parseFloat(s[i][0]);
				float cnt = 0;
				for(int j = 0; j < Integer.parseInt(s[i][0]) ; j++){
					if(Float.parseFloat(s[i][j+1]) > result){
						cnt++;
					}
				}
				System.out.println(String.format("%.3f" ,cnt/Float.parseFloat(s[i][0])*100)+"%");
			}
		}finally {
			in.close();
			in = null;
		}
	}
}
//5
//5 50 50 70 80 100
//7 100 95 90 80 70 60 50
//3 70 90 80
//3 70 90 81
//9 100 99 98 97 96 95 94 93 91

//40.000%
//57.143%
//33.333%
//66.667%
//55.556%