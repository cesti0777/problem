package study;

import java.util.Scanner;

public class SE1926 {
	static long n;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		n = in.nextInt();

		execute();// ����

	}

	public static void execute() {
		String s;//���� ���ڿ�ȭ �ؼ� ������ ����
		int cnt = 0;//3,6,9 ���� ���� ����
		for (int i = 1; i <= n; i++) {//�Է� ���ڸ�ŭ �ݺ�
			cnt = 0;//�Ź� 0���� �ʱ�ȭ
			s = i + "";//���� ���ڿ�ȭ
			for (int j = 0; j < s.length(); j++) {//���ڿ� ���̸�ŭ �ݺ�
				if (s.charAt(j) == '3' || s.charAt(j) == '6' || s.charAt(j) == '9') {//3,6,9 ���� ī��Ʈ
					cnt++;//ī��Ʈ ����
				}
			}
			if (cnt != 0) {//3,6,9 ī��� ������
				for (int j = 0; j < cnt; j++) {//3,6,9 ������ŭ - ���
					System.out.print("-");
				}
				System.out.print(" ");
			} else {//3,6,9 ������ ���ڿ� �״�� ���
				System.out.print(s + " ");
			}
		}
	}
}
