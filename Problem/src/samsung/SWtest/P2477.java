package samsung.SWtest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2477 {
	static int n;// 접수 창구 개수
	static int m;// 정비 창구 개수
	static int k;// 방문 고객 수
	static int a;// 타겟의 접수 창구 번호
	static int b;// 타겟의 정비 창구 번호
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

		// 매초 실행
		while (true) {
			// 접수 창구 처리
			// 접수 창구 대기 손님 처리
			int aIsFull = 0; // 0이면 full
			while (!aWaitQ.isEmpty()) {// 접수창구 대기손님 있으면
				// 접수창구 빈자리 확인
				for (int i = 1; i <= n; i++) {
					if (aState[i] == null) {// 빈자리 있으면
						aIsFull = i;
						break;
					}
				}
				if (aIsFull != 0) {// 빈자리 있으면
					aState[aIsFull] = aWaitQ.remove();
				} else {// 빈자리 없으면
					break;
				}
			}

			// 정비 창구 대기 손님 처리
			// 정비 창구 빈자리 확인
			int bIsFull = 0;
			for (int i = 1; i <= m; i++) {
				if (bState[i] == null) {// 빈자리 있으면
					bIsFull = i;
					break;
				}
			}
			while (!bWaitQ.isEmpty()) {// 정비 창구 대기손님 있으면
				if (bIsFull != 0) {// 빈자리 있으면
					bState[aIsFull] = bWaitQ.remove();
				} else {// 빈자리 없으면
					break;
				}
			}

			// 도착 고객 접수 창구 처리 (t = 0)
			for (int i = 1; i <= k; i++) {
				if (kT[i] == 0) {
					q.add(new Customer());
				}
			}
			while (!q.isEmpty()) {// 도착 고객 있으면
				// 접수창구 빈자리 확인
				for (int i = 1; i <= n; i++) {
					if (aState[i] == null) {// 빈자리 있으면
						aIsFull = i;
						break;
					}
				}
				if (aIsFull == 0) { // 접수 창구 빈자리 없으면
					aWaitQ.add(q.remove());
				} else {// 접수 창구 빈자리 있으면
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

			// 대기손님 처리
			while (!aWaitQ.isEmpty()) {

			}

			// 새로온 고객 배치
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
// 두 번째 테스트 케이스, N=2, M=2, K=6, A=1, B=2,본문예제
// a1=3, a2=2
// b1=4, b2=2
// t1=0, t2=0, t3=1, t4=2, t5=3, t6=4
