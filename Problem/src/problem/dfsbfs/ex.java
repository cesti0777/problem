package problem.dfsbfs;

import java.util.Scanner;

public class ex {
	static int n, m, startV;
	static boolean[][] edge;
	static boolean[] visited;

	public static void dfs(int cur) {
		visited[cur] = true;
		System.out.print(cur + " ");
		for (int i = 1; i <= n; i++) {
			if (visited[i] || !edge[cur][i]) {
				continue;
			}
			dfs(i);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			n = in.nextInt();
			m = in.nextInt();
			startV = in.nextInt();
			edge = new boolean[n + 1][n + 1];
			visited = new boolean[n + 1];
			for (int i = 0; i < m; i++) {
				int u = in.nextInt();
				int v = in.nextInt();
				edge[u][v] = true;
			}
			dfs(startV);
		} finally {
			in.close();
			in = null;
		}
	}

}

// 4 5 1
// 1 2
// 1 3
// 1 4
// 2 4
// 3 4


//4 6
//110110
//110110
//111111
//111101
