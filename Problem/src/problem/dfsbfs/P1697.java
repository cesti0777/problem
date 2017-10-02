package problem.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1697 {
	static int n, k;
	static int time;
	static boolean[] visited;

	public static void bfs(int cur, int t) {
		Queue<Integer> q = new LinkedList<>();
		visited[cur] = true;
		q.add(cur);
		q.add(t);
		while (!q.isEmpty()) {
			int here = q.remove();
			int time = q.remove();
			if (here == k) {
				System.out.println(time);
				return;
			}
			if (here + 1 <= 100000 && !visited[here + 1]) {
				visited[here + 1] = true;
				q.add(here + 1);
				q.add(time + 1);
			}
			if (here - 1 >= 0 && !visited[here - 1]) {
				visited[here - 1] = true;
				q.add(here - 1);
				q.add(time + 1);
			}
			if (here * 2 <= 100000 && !visited[here * 2]) {
				visited[here * 2] = true;
				q.add(here * 2);
				q.add(time + 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			n = in.nextInt();
			k = in.nextInt();
			visited = new boolean[100001];
			bfs(n, 0);
		} finally {
			in.close();
			in = null;
		}
	}
}

// �ȱ� x +1,-1
// �����̵� x*2
// ���� 3���� x+1, x-1, x*2

// ����
// �����̴� ������ ���ٲ����� �ϰ� �ִ�. �����̴� ���� �� N(0 �� N �� 100,000)�� �ְ�,
// ������ �� K(0 �� K �� 100,000)�� �ִ�. �����̴� �Ȱų� �����̵��� �� �� �ִ�.
// ����, �������� ��ġ�� X�� �� �ȴ´ٸ� 1�� �Ŀ� X-1 �Ǵ� X+1�� �̵��ϰ� �ȴ�.
// �����̵��� �ϴ� ��쿡�� 1�� �Ŀ� 2*X�� ��ġ�� �̵��ϰ� �ȴ�.
//
// �����̿� ������ ��ġ�� �־����� ��, �����̰� ������ ã�� �� �ִ� ���� ���� �ð��� �� �� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
//
// �Է�
// ù ��° �ٿ� �����̰� �ִ� ��ġ N�� ������ �ִ� ��ġ K�� �־�����.
//
// ���
// �����̰� ������ ã�� ���� ���� �ð��� ����Ѵ�.
//
// ���� �Է� ����
// 5 17
// ���� ��� ����
// 4
// ��Ʈ
// �����̰� 5-10-9-18-17 ������ ���� 4�ʸ��� ������ ã�� �� �ִ�.