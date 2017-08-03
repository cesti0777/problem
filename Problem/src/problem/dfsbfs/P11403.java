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
// 문제
// 가중치 없는 방향 그래프 G가 주어졌을 때, 모든 정점 (i, j)에 대해서,
// i에서 j로 가는 경로가 있는지 없는지 구하는 프로그램을 작성하시오.
//
// 입력
// 첫째 줄에 정점의 개수 N (1 ≤ N ≤ 100)이 주어진다.
// 둘째 줄부터 N개 줄에는 그래프의 인접 행렬이 주어진다.
// i번째 줄의 j번째 숫자가 1인 경우에는 i에서 j로 가는 간선이 존재한다는 뜻이고, 0인 경우는 없다는 뜻이다.
// i번째 줄의 i번째 숫자는 항상 0이다.
//
// 출력
// 총 N개의 줄에 걸쳐서 문제의 정답을 인접행렬 형식으로 출력한다.
// 정점 i에서 j로 가는 경로가 있으면 i번째 줄의 j번째 숫자를 1로, 없으면 0으로 출력해야 한다.
//
// 예제 입력 복사
// 3
// 0 1 0
// 0 0 1
// 1 0 0
// 예제 출력 복사
// 1 1 1
// 1 1 1
// 1 1 1
// 예제 입력 2 복사
// 7
// 0 0 0 1 0 0 0
// 0 0 0 0 0 0 1
// 0 0 0 0 0 0 0
// 0 0 0 0 1 1 0
// 1 0 0 0 0 0 0
// 0 0 0 0 0 0 1
// 0 0 1 0 0 0 0
// 예제 출력 2 복사
// 1 0 1 1 1 1 1
// 0 0 1 0 0 0 1
// 0 0 0 0 0 0 0
// 1 0 1 1 1 1 1
// 1 0 1 1 1 1 1
// 0 0 1 0 0 0 1
// 0 0 1 0 0 0 0