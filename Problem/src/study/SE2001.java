package study;

import java.util.Scanner;

public class SE2001 {

	static int testCaseCnt;//testcase ����
	static int n;//mapũ��
	static int m;//�ĸ�ä ũ��
	static int[][] map = new int[15][15];//�ִ� �� ũ��� ����
	static int answer;//�ִ� �ĸ���

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		testCaseCnt = in.nextInt();//testcase ���� �Է�

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {
			
			init();//���� �ʱ�ȭ

			n = in.nextInt();//map ũ�� �Է�
			m = in.nextInt();//�ĸ�ä ũ�� �Է�

			//map �Է�
			for (int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++){
					map[i][j] = in.nextInt();
				}
			}
			
			execute();//����
			
			System.out.println("#" + testCase + " " + answer);
		}
	}

	public static void init() {
		n = 0;
		m = 0;
		answer = 0;
	}

	public static void execute() {
		//�ĸ�ä ũ�Ⱑ map ������ ������ �ʰ� �ε��� �����ϸ鼭 i, j �̵�
		for(int i = 0; i < n - m + 1; i++){
			for(int j = 0; j < n - m + 1; j++){
				int sum = 0;//�ĸ��� ����
				
				//�ĸ�ä ũ�⸸ŭ ���ϱ�
				//i, j �� ��ġ�� ������ �ĸ�ä ũ�⸸ŭ �������� ���Ѵ�
				for(int p = i; p < i + m; p++){
					for(int q = j; q < j + m; q++){
						sum += map[p][q];//�ĸ� ������
					}
				}
				
				//max �� ����
				answer = Math.max(answer, sum);
			}
		}
	}
}
