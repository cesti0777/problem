package study;

import java.util.Scanner;

public class SE1954 {

	static int testCaseCnt;// testcase ����
	static int n;
	static int[][] arr;
	static String answer;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		testCaseCnt = in.nextInt();// testcase ���� �Է�

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {

			n = in.nextInt();

			arr = new int[n][n];

			execute();// ����

			System.out.println("#" + testCase);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	public static void execute() {
		arr[0][0] = 1;//ùĭ �ʱ�ȭ
		int r = 0, c = 0;
		char d = 'R';
		int num = 1;
		while(true){
			if(d == 'R'){
				if(c + 1 < n && arr[r][c + 1] == 0){//�������� �ʹ�x, ��ĭ
					c++;//���������� �̵�
					num++;//��ȣ ����
					arr[r][c] = num;//��ȣ ���� 
				}else{//���������� �����ٸ� �Ʒ� Ȯ���غ��� �� �� ������ ����ٲٱ�
					if(r + 1 < n && arr[r + 1][c] == 0){//�Ʒ��� �ʹ�x, ��ĭ
						d = 'D';
					}else{//�Ʒ��� ������ ����
						return;
					}
				}
			}else if(d == 'D'){
				if(r + 1 < n && arr[r + 1][c] == 0){//�Ʒ��� �ʹ�x, ��ĭ
					r++;//�Ʒ��� �̵�
					num++;//��ȣ ����
					arr[r][c] = num;//��ȣ ���� 
				}else{//�Ʒ��� �����ٸ� ���� Ȯ���غ��� �� �� ������ ����ٲٱ�
					if(c - 1 >= 0 && arr[r][c - 1] == 0){//������ �ʹ�x, ��ĭ
						d = 'L';
					}else{//�������� ������ ����
						return;
					}
				}
			}else if(d == 'L'){
				if(c - 1 >= 0 && arr[r][c - 1] == 0){//������ �ʹ�x, ��ĭ
					c--;//�������� �̵�
					num++;//��ȣ ����
					arr[r][c] = num;//��ȣ ���� 
				}else{//�������� �����ٸ� �� Ȯ���غ��� �� �� ������ ����ٲٱ�
					if(r - 1 >= 0 && arr[r - 1][c] == 0){//���� �ʹ�x, ��ĭ
						d = 'U';
					}else{//���� ������ ����
						return;
					}
				}
			}else if(d == 'U'){
				if(r - 1 >= 0 && arr[r - 1][c] == 0){//���� �ʹ�x, ��ĭ
					r--;//���� �̵�
					num++;//��ȣ ����
					arr[r][c] = num;//��ȣ ���� 
				}else{//���� �����ٸ� ������ Ȯ���غ��� �� �� ������ ����ٲٱ�
					if(c + 1 < n && arr[r][c + 1] == 0){//�������� �ʹ�x, ��ĭ
						d = 'R';
					}else{//���������� ������ ����
						return;
					}
				}
			}
		}
	}
}
















