package problem.cal;

import java.util.Scanner;

public class P2839 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			int n = in.nextInt();
			int oriN = n;
			int cnt = 0;
			int add5 = 0;
			
			if(n%5 != 0){
				cnt = n/5;
				add5 = n%5;
				if(add5%3 != 0){
					while(true){
						add5=add5+5;
						cnt--;
						if(add5>oriN){
							cnt = -1;
							break;
						}
						if(add5%3 == 0){
							cnt += add5/3;
							break;
						}
					}
				}else{
					cnt += add5/3;
				}
			}else{
				cnt = n/5;
			}
			System.out.println(cnt);
		}finally {
			in.close();
			in = null;
		}
	}
}
