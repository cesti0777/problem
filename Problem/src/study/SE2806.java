package study;

import java.util.Scanner;

public class SE2806 {

	static int testCaseCnt;// testcase ����
	static int n;
	static int answer;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		testCaseCnt = in.nextInt();// testcase ���� �Է�

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {

			n = in.nextInt();

			answer = 0;
			
			execute();// ����

			System.out.println("#" + testCase + " " + answer);
		}
	}

	public static void execute() {
		
		if(n == 1){
			answer = 1;
			return;
		}

		// nCr���� ������ ǥ���� �迭, �� �迭�� ���ʺ��� ä��鼭 ���ջ���
		// �� ������ ������ ��ȣ�� map�迭�� �ε����� ����
		int[] comArr = new int[n * n];

		// nC1 ~ nCr ������ ���� ���
		// ex)4C3 -> 4C1, 4C2, 4C3
		combination(comArr, 0, n * n, n, 0);
	}

	public static void combination(int[] comArr, int idx, int n, int r, int targetNum) {

		if (r == 0) {// ��� ���� �� �̾�����
			// print(comArr, idx);
			cal(comArr, idx);// ���
		} else if (n == targetNum) {// ����� ���� �ٴڳ� ����
			return;
		} else {
			comArr[idx] = targetNum;
			combination(comArr, idx + 1, n, r - 1, targetNum + 1);
			combination(comArr, idx, n, r, targetNum + 1);
		}
	}

	public static void cal(int[] comArr, int idx) {
		int[][] map = new int[n][n];

		// ���� �ʿ� �����
		for (int i = 0; i < idx; i++) {
			map[comArr[i] / n][comArr[i] % n] = 1;
		}

//		printMap(map);
		
		// ���� ���ɿ��� ���
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					// i���˻�
					for (int k = 0; k < n; k++) {
						if(i == k){
							continue;
						}
						if (map[k][j] == 1) {
							return;
						}
					}

					// j��˻�
					for (int k = 0; k < n; k++) {
						if (j == k) {
							continue;
						}else{
							return;
						}
					}

					// �밢�˻�1
					int a = i;
					int b = j;
					while(a >= 0 && b >= 0){//�»�
						if(a == i && b == j){
							continue;
						}
						if(map[a][b] == 1){
							return;
						}
						a--;
						b--;
					}
					a = i;
					b = j;
					while(a < n && a < n){//����
						if(a == i && b == j){
							continue;
						}
						if(map[a][b] == 1){
							return;
						}
						i++;
						j++;
					}

					// �밢�˻�2
					a = i;
					b = j;
					while(i >= 0 && j < n){//���
						if(a == i && b == j){
							continue;
						}
						if(map[a][b] == 1){
							return;
						}
						i--;
						j++;
					}
					a = i;
					b = j;
					while(i < n && j >= 0){//����
						if(a == i && b == j){
							continue;
						}
						if(map[a][b] == 1){
							return;
						}
						i++;
						j--;
					}
				}
			}
		}
		answer++;
	}

	static boolean collisionCheck(int collision) {
		if (collision > 1) {
			return true;
		} else {
			return false;
		}
	}

	public static void print(int[] comArr, int idx) {

		for (int i = 0; i < idx; i++) {
			System.out.print(comArr[i] + " ");
		}
		System.out.println();
	}

	public static void printMap(int[][] map) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}