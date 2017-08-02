package problem.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1260 {
	static boolean edgeDFS[][];
	static boolean visitedDFS[];
	static boolean edgeBFS[][];
	static boolean visitedBFS[];
	static int n;
	static int m;
	static int startV;
	
	public static void dfs(int cur){
		visitedDFS[cur] = true;
		System.out.print(cur + " ");
		for(int i = 1; i <= n; i++){
			if(visitedDFS[i] || !edgeDFS[cur][i]){
				continue;
			}
			dfs(i);
		}
	}
	public static void bfs(int cur){
		Queue<Integer> q = new LinkedList<>();
		visitedBFS[cur] = true;
		q.add(cur);
		while(!q.isEmpty()){
			int here = q.remove();
			System.out.print(here + " ");
			for(int i = 1; i <= n ; i++){
				if(visitedBFS[i] || !edgeBFS[here][i]){
					continue;
				}
				visitedBFS[i] = true;
				q.add(i);
			}
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			n = in.nextInt();
			m = in.nextInt();
			startV = in.nextInt();
			edgeDFS = new boolean[2*n + 1][2*n + 1];
			visitedDFS = new boolean[n + 1];
			edgeBFS = new boolean[2*n + 1][2*n + 1];
			visitedBFS = new boolean[n + 1];
			for (int i = 0; i < m; i++) {
				int u = in.nextInt();
				int v = in.nextInt();
				edgeDFS[u][v] = true;
				edgeDFS[v][u] = true;
				edgeBFS[u][v] = true;
				edgeBFS[v][u] = true;
			}
			dfs(startV);
			System.out.println();
			bfs(startV);
		}finally {
			in.close();
			in = null;
		}
	}
}
// 문제
// 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
// 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
// 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
//
// 입력
// 첫째 줄에 정점의 개수 N(1≤N≤1,000), 간선의 개수 M(1≤M≤10,000),
// 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가
// 주어진다. 한 간선이 여러 번 주어질 수도 있는데, 간선이 하나만 있는 것으로 생각하면 된다.
// 입력으로 주어지는 간선은 양방향이다.
//
// 출력
// 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다.
// V부터 방문된 점을 순서대로 출력하면 된다.
//
// 예제 입력 복사
// 4 5 1
// 1 2
// 1 3
// 1 4
// 2 4
// 3 4
// 예제 출력 복사
// 1 2 4 3
// 1 2 3 4