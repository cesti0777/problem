package study;

import java.util.Scanner;

public class BJ3190_Today {
	static int[][] map;//��
	static int n;//��ũ��
	static int k;//�������
	static int l;//���⺯ȯ����
	static Object[][] d;//���� ��ȯ ����
	static int curLen;//���� �� ����
	static int[] dR = {-1, 1, 0 ,0};
	static int[] dC = {0, 0, -1 ,1};

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();//�� ũ�� �Է�
		k = in.nextInt();//��� ���� �Է�
		
		// ���(-1) ��ġ ����
		map = new int[n][n];
		for (int i = 0; i < k; i++) {
			map[in.nextInt() - 1][in.nextInt() - 1] = -1;
		}

		l = in.nextInt();//���� ��ȯ ����
		
		// ���� ��ȯ ���� ����
		d = new Object[l][2];//���� ��ȯ �ð�(��), ����(L or D) 
		for (int i = 0; i < l; i++) {
			d[i][0] = in.nextInt();
			d[i][1] = in.next();
		}

		int curS = 0;//���� �ð�
		char curD = 'R';//���� �Ӹ� ����
		int curDCIdx = 0;//���� ���� ��ȯ �ε���
		int r = 0;//�Ӹ���ġ ��
		int c = 0;//�Ӹ���ġ ��
		curLen = 1;//���� ����
		map[r][c] = 1;//�Ӹ� ����

		while (true) {
			curS++;//�ð� ����
			if (curD == 'R') {
				if (c + 1 >= n || map[r][c + 1] > 0) {//�� or����
					System.out.println(curS);
					return;
				} else if (map[r][c + 1] == -1) {//���
					curLen++;//���� �ø���
					map[r][c + 1] = curLen;//�Ӹ��� ���� ���̷� ǥ��
					c++;//�Ӹ� ��ġ �̵�
				} else {
					map[r][c + 1] = curLen;//�Ӹ��� ���� ���̷� ǥ��
					move(r, c + 1);//���� �̵�
					c++;//�Ӹ� ��ġ �̵�
				}

			} else if (curD == 'D') {
				if (r + 1 >= n || map[r + 1][c] > 0) {
					System.out.println(curS);
					return;
				} else if (map[r + 1][c] == -1) {
					curLen++;
					map[r + 1][c] = curLen;
					r++;
				} else {
					map[r + 1][c] = curLen;
					move(r + 1, c);
					r++;
				}
			} else if (curD == 'L') {
				if (c - 1 < 0 || map[r][c - 1] > 0) {
					System.out.println(curS);
					return;
				} else if (map[r][c - 1] == -1) {
					curLen++;
					map[r][c - 1] = curLen;
					c--;
				} else {
					map[r][c - 1] = curLen;
					move(r, c - 1);
					c--;
				}
			} else if (curD == 'U') {
				if (r - 1 < 0 || map[r - 1][c] > 0) {
					System.out.println(curS);
					return;
				} else if (map[r - 1][c] == -1) {
					curLen++;
					map[r - 1][c] = curLen;
					r--;
				} else {
					map[r - 1][c] = curLen;
					move(r - 1, c);
					r--;
				}
			}

			if (curDCIdx < l) {//���� ��ȯ�� ���� �ִٸ�
				if ((int)d[curDCIdx][0] == curS) {//���� ��ȯ �ð��� ���� �ð��� ���ٸ�
					if (((String)d[curDCIdx][1]).equals("D")) {//���� ��ȯ�� �������̸�
						if (curD == 'R') {//���� �Ӹ� ������ �������̸�
							curD = 'D';//�Ʒ��� ����
						} else if (curD == 'D') {
							curD = 'L';
						} else if (curD == 'L') {
							curD = 'U';
						} else if (curD == 'U') {
							curD = 'R';
						}
					} else if (((String)d[curDCIdx][1]).equals("L")) {//���� ��ȯ�� �����̸�
						if (curD == 'R') {
							curD = 'U';
						} else if (curD == 'D') {
							curD = 'R';
						} else if (curD == 'L') {
							curD = 'D';
						} else if (curD == 'U') {
							curD = 'L';
						}
					}
					curDCIdx++;//���� ���� ��ȯ �ε����� ����
				}
			}
		} // end while
	}// end main
	
	//���� ū ��ȣ�� �Ű��� �Ӹ��� �������� 
	//������������ ��ȣ�� ���ҽ�Ű�鼭 
	//������ �̵��Ǵ� ȿ���� �����
	//ex) 12345(5) -> 1234(4)5 -> 123(3)45 -> 12(2)345 -> 1(1)2345 -> 12345
	private static void move(int r, int c) {
		for(int i =  0; i < 4; i++){//�����¿�
			int curR = r + dR[i];
			int curC = c + dC[i];
			if(curR < n && curR >= 0 && curC < n && curC >= 0){//����üũ
				if(map[r][c] == map[curR][curC]){//���� Ž������ �����ȣ�� ���� �����ȣ �߽߰�
					if(map[curR][curC] == 1){//�����߰�
						map[curR][curC]--;//��������
						return;//Ž������
					}
					map[curR][curC]--;//�����ȣ ����
					move(curR, curC);//���� ���� ã�Ƽ� �̵�
					return;
				}
			}
		}
	}
}
