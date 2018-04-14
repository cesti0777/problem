package kj_ss;

import java.util.Scanner;

public class p14890 {
	static int n;
	static int l;
	static int[][] map = new int[101][101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		l = sc.nextInt();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		runHang();
	}
	public static void runHang() {
		int dr = 0; // 1�̸� �������� ����, -1�̸� �������� ����
		int current = 1; // ���� �° ������� count
		
		for(int i=1; i<n; i++) {
			if(map[0][i] - map[0][i-1] == 1) { // �������� �����̸�
				dr = 1;
			} else if (map[0][i-1] - map[0][i] == 1) { // �������� �����̸�
				dr = -1;
			} else if(map[0][i-1] == map[0][i]) { // ���� ���̸�
				current++;
			} else { // ���� ���̰� 1 �̻��̸� �ƿ� ���Ͻ�Ű��
				return;
			}
		}
	}
}
