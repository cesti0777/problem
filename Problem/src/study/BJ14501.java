package study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ14501 {
	
	static int n;//day ��
	static int[][] day = new int[15][2];//�������
	static int max;//�ִ� �����޿�

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		//day �� �Է�
		n = in.nextInt();
		
		//��� ���� �Է�
		for(int i = 0; i < n; i++){
			day[i][0] = in.nextInt();
			day[i][1] = in.nextInt();
		}

		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < n; i++){//��������� ť�� �ֱ�
			q.add(i);//day �ε���
			q.add(day[i][0]);//���ð�
			q.add(day[i][1]);//���޿�
			q.add(0);//�� �޿�
		}
		
		while(!q.isEmpty()){
			int dIdx = q.remove();
			int t = q.remove();
			int p = q.remove();
			int totalPay = q.remove();
			
			if(dIdx + t > n){//����Ϻ��� �ʰ��Ǵ� ��� pass
				continue;
			}
			
			totalPay += p;
			
			for(int i = dIdx + t; i < n; i++){//�̾ �� �� �ִ� ��������� �����޿� ť�� �ֱ�
				q.add(i);
				q.add(day[i][0]);
				q.add(day[i][1]);
				q.add(totalPay);
			}
			max = Math.max(max, totalPay);//�ִ� �����޿� ����
		}
		System.out.println(max);
	}
}