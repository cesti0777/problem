package samsung.SWtest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2477 {
	static int n;// ���� â�� ����
	static int m;// ���� â�� ����
	static int k;// �湮 ���� ��
	static int a;// Ÿ���� ���� â�� ��ȣ
	static int b;// Ÿ���� ���� â�� ��ȣ
	static int[] aT = new int[10];
	static int[] bT = new int[10];
	static int[] kT = new int[1001];
	static int t;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		m = in.nextInt();
		k = in.nextInt();
		a = in.nextInt();
		b = in.nextInt();

		for (int i = 1; i <= n; i++) {
			aT[i] = in.nextInt();
		}
		for (int i = 1; i <= m; i++) {
			bT[i] = in.nextInt();
		}
		for (int i = 1; i <= k; i++) {
			kT[i] = in.nextInt();
		}

		Queue<Customer> q = new LinkedList<Customer>();

		Customer[] aState = new Customer[n + 1];
		Queue<Customer> aWaitQ = new LinkedList<Customer>();
		Customer[] bState = new Customer[m + 1];
		Queue<Customer> bWaitQ = new LinkedList<Customer>();
		Customer c = null;

		// ���� ����
		while (true) {
			// ���� â�� ó��
			// ���� â�� ��� �մ� ó��
			int aIsFull = 0; // 0�̸� full
			while (!aWaitQ.isEmpty()) {// ����â�� ���մ� ������
				// ����â�� ���ڸ� Ȯ��
				for (int i = 1; i <= n; i++) {
					if (aState[i] == null) {// ���ڸ� ������
						aIsFull = i;
						break;
					}
				}
				if (aIsFull != 0) {// ���ڸ� ������
					aState[aIsFull] = aWaitQ.remove();
				} else {// ���ڸ� ������
					break;
				}
			}

			// ���� â�� ��� �մ� ó��
			// ���� â�� ���ڸ� Ȯ��
			int bIsFull = 0;
			for (int i = 1; i <= m; i++) {
				if (bState[i] == null) {// ���ڸ� ������
					bIsFull = i;
					break;
				}
			}
			while (!bWaitQ.isEmpty()) {// ���� â�� ���մ� ������
				if (bIsFull != 0) {// ���ڸ� ������
					bState[aIsFull] = bWaitQ.remove();
				} else {// ���ڸ� ������
					break;
				}
			}

			// ���� ���� ���� â�� ó�� (t = 0)
			for (int i = 1; i <= k; i++) {
				if (kT[i] == 0) {
					q.add(new Customer());
				}
			}
			while (!q.isEmpty()) {// ���� ���� ������
				// ����â�� ���ڸ� Ȯ��
				for (int i = 1; i <= n; i++) {
					if (aState[i] == null) {// ���ڸ� ������
						aIsFull = i;
						break;
					}
				}
				if (aIsFull == 0) { // ���� â�� ���ڸ� ������
					aWaitQ.add(q.remove());
				} else {// ���� â�� ���ڸ� ������
					aState[aIsFull] = q.remove();
				}
			}
			
			
			

			for (int i = 0; i < k; i++) {
				if (kT[i] == 0) {
					q.add(new Customer());
				}
			}
			boolean isFull = false;
			for (int i = 1; i <= n; i++) {
				if (aState[i] == null) {
					break;
				}
			}

			// ���մ� ó��
			while (!aWaitQ.isEmpty()) {

			}

			// ���ο� ���� ��ġ
			while (!q.isEmpty()) {
				c = q.remove();
				for (int i = 1; i <= n; i++) {
					if (aState[i] == null) {
						aState[i] = c;
					}
				}
				aWaitQ.add(c);

			}
		}
	}

	public static class Customer {
		int cNum;
		int aNum;
		int bNum;

	}
}

// 7 10
// 2 2 6 1 2
// 3 2
// 4 2
// 0 0 1 2 3 4
// �� ��° �׽�Ʈ ���̽�, N=2, M=2, K=6, A=1, B=2,��������
// a1=3, a2=2
// b1=4, b2=2
// t1=0, t2=0, t3=1, t4=2, t5=3, t6=4