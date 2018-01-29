package study;

import java.util.Scanner;

public class SE1491 {

	static int testCaseCnt;// testcase ����
	static long n, a, b;
	static long answer;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		testCaseCnt = in.nextInt();// testcase ���� �Է�

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {

			n = in.nextInt();
			a = in.nextInt();
			b = in.nextInt();

			answer = Integer.MAX_VALUE;
			
			execute();// ����

			System.out.println("#" + testCase + " " + answer);
		}
	}

	public static void execute() {
		int rootN = (int)Math.sqrt(n);//���簢�� ����� ���� ��Ʈ���
		long result = 0;//��갪
		long bigAB = Math.max(a, b);//a, b �� ū�� ����
		
		for(long r = rootN ; r >= 1; r--){//���簢�� ���̿��� 1���� �ٿ�����
			for(long c = rootN ; c <= bigAB; c++){//���簢�� ���̿��� ������ �ִ�� �÷�����
				if(r * c <= n){//�� Ÿ�� ������ ���� ������
					result = a * Math.abs(r - c) + b * (n - r * c);//���
					answer = Math.min(answer, result);//�ּҰ� ����
				}else{//�� Ÿ�� ������ ������
					break;//���� row�� ���̱� ���� break
				}
			}
		}
	}
}
