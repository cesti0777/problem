package study;

import java.util.Scanner;

public class SE1494 {

	static int testCaseCnt;
	static int n;
	static int[][] num = new int[2][20];
	static boolean[] visited = new boolean[20];
	static long answer;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		testCaseCnt = in.nextInt();

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {
			init();

			n = in.nextInt();

			for (int i = 0; i < n; i++) {
				num[0][i] = in.nextInt();
				num[1][i] = in.nextInt();
			}

			execute(0, 0);

			System.out.println("#" + testCase + " " + answer);
		}
	}

	public static void init() {
		n = 0;
		answer = Long.MAX_VALUE;
	}

	public static void execute(int depth, int idx) {

		if (depth == n / 2) {//������ n/2���� �����ߴٸ�
			cal();//������ ���
			return;
		}

		for (int i = idx; i < n; i++) {
			if (visited[i] == false) {//���� �ȵ� �����̶��
				visited[i] = true;//visited�� ������ ������ ǥ��
				execute(depth + 1, idx + 1);//���� ������ ������ ã�Ƽ� ����
				visited[i] = false;//visited�� �����ߴ� ������ Ǯ����
			}
		}
	}

	public static void cal() {
		long[] sum = {0, 0};
		for(int i = 0; i < n; i++){
			if(visited[i] == true){
				sum[0] += num[0][i];
				sum[1] += num[1][i];
			}else{
				sum[0] -= num[0][i];
				sum[1] -= num[1][i];
			}
		}
		answer = Math.min(answer, sum[0] * sum[0] + sum[1] * sum[1]);//������ ����
	}
}



