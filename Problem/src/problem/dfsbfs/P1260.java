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
// ����
// �׷����� DFS�� Ž���� ����� BFS�� Ž���� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
// ��, �湮�� �� �ִ� ������ ���� ���� ��쿡�� ���� ��ȣ�� ���� ���� ���� �湮�ϰ�,
// �� �̻� �湮�� �� �ִ� ���� ���� ��� �����Ѵ�.
//
// �Է�
// ù° �ٿ� ������ ���� N(1��N��1,000), ������ ���� M(1��M��10,000),
// Ž���� ������ ������ ��ȣ V�� �־�����. ���� M���� �ٿ��� ������ �����ϴ� �� ������ ��ȣ��
// �־�����. �� ������ ���� �� �־��� ���� �ִµ�, ������ �ϳ��� �ִ� ������ �����ϸ� �ȴ�.
// �Է����� �־����� ������ ������̴�.
//
// ���
// ù° �ٿ� DFS�� ������ �����, �� ���� �ٿ��� BFS�� ������ ����� ����Ѵ�.
// V���� �湮�� ���� ������� ����ϸ� �ȴ�.
//
// ���� �Է� ����
// 4 5 1
// 1 2
// 1 3
// 1 4
// 2 4
// 3 4
// ���� ��� ����
// 1 2 4 3
// 1 2 3 4