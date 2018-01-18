package samsung.practice1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P14501 {
	
	static int n;//day 수
	static int[][] day = new int[15][2];//상담정보
	static int max;//최대 누적급여

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		//day 수 입력
		n = in.nextInt();
		
		//상담 정보 입력
		for(int i = 0; i < n; i++){
			day[i][0] = in.nextInt();
			day[i][1] = in.nextInt();
		}

		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < n; i++){//상담정보들 큐에 넣기
			q.add(i);//day 인덱스
			q.add(day[i][0]);//상담시간
			q.add(day[i][1]);//상담급여
			q.add(0);//총 급여
		}
		
		while(!q.isEmpty()){
			int dIdx = q.remove();
			int t = q.remove();
			int p = q.remove();
			int totalPay = q.remove();
			
			if(dIdx + t > n){//퇴사일보다 초과되는 상담 pass
				continue;
			}
			
			totalPay += p;
			
			for(int i = dIdx + t; i < n; i++){//이어서 할 수 있는 상담정보와 누적급여 큐에 넣기
				q.add(i);
				q.add(day[i][0]);
				q.add(day[i][1]);
				q.add(totalPay);

			}
			max = Math.max(max, totalPay);//최대 누적급여 갱신
		}
		System.out.println(max);
	}
}
