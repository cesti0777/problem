package problem.dfsbfs;

import java.util.Scanner;

public class P11403 {
	static int[][] edge;
	static boolean[] visited;
	static int[][] ans;
	static int n;

	public static void dfs(int cur) {
		for (int i = 1; i <= n; i++) {
			if (!visited[i] && edge[cur][i] == 1) {
				visited[i] = true;
				dfs(i);
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			n = in.nextInt();
			edge = new int[n + 1][n + 1];
			ans = new int[n + 1][n + 1];
			visited = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					edge[i][j] = in.nextInt();
				}
			}
			for (int i = 1; i <= n; i++) {
				dfs(i);
				for (int j = 1; j <= n; j++) {
					if (visited[j] == true) {
						ans[i][j] = 1;
						visited[j] = false;
					}
				}
			}
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					System.out.print(ans[i][j] + " ");
				}
				System.out.println();
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(ans[i][j]);
					System.out.print(" ");
				}
				System.out.println("");
			}
		} finally {
			in.close();
			in = null;
		}
	}
}
// ����
// ����ġ ���� ���� �׷��� G�� �־����� ��, ��� ���� (i, j)�� ���ؼ�,
// i���� j�� ���� ��ΰ� �ִ��� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
//
// �Է�
// ù° �ٿ� ������ ���� N (1 �� N �� 100)�� �־�����.
// ��° �ٺ��� N�� �ٿ��� �׷����� ���� ����� �־�����.
// i��° ���� j��° ���ڰ� 1�� ��쿡�� i���� j�� ���� ������ �����Ѵٴ� ���̰�, 0�� ���� ���ٴ� ���̴�.
// i��° ���� i��° ���ڴ� �׻� 0�̴�.
//
// ���
// �� N���� �ٿ� ���ļ� ������ ������ ������� �������� ����Ѵ�.
// ���� i���� j�� ���� ��ΰ� ������ i��° ���� j��° ���ڸ� 1��, ������ 0���� ����ؾ� �Ѵ�.
//
// ���� �Է� ����
// 3
// 0 1 0
// 0 0 1
// 1 0 0
// ���� ��� ����
// 1 1 1
// 1 1 1
// 1 1 1
// ���� �Է� 2 ����
// 7
// 0 0 0 1 0 0 0
// 0 0 0 0 0 0 1
// 0 0 0 0 0 0 0
// 0 0 0 0 1 1 0
// 1 0 0 0 0 0 0
// 0 0 0 0 0 0 1
// 0 0 1 0 0 0 0
// ���� ��� 2 ����
// 1 0 1 1 1 1 1
// 0 0 1 0 0 0 1
// 0 0 0 0 0 0 0
// 1 0 1 1 1 1 1
// 1 0 1 1 1 1 1
// 0 0 1 0 0 0 1
// 0 0 1 0 0 0 0