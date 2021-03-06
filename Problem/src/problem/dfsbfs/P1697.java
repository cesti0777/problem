package problem.dfsbfs;

import java.util.Scanner;

public class P1697 {
	static boolean[] visited = new boolean[100001];
	static int n;
	static int k;
	static int second = 100000;
	

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		n = scanner.nextInt();
		k = scanner.nextInt();
		
		dfs(n, 0, visited);
		
		System.out.println(second);
	}

	public static void dfs(int cur, int sec, boolean[] visited) {
		visited[cur] = true;
		boolean[] cloneVisited = visited.clone(); 
		
		if(cur == k){
			second = Math.min(second, sec);
			return;
		}
		
		if(cur + 1 < 100001 && cur < k && !cloneVisited[cur + 1]){
			dfs(cur + 1, sec + 1, cloneVisited);
		}
		if(cur - 1 > 0 && cur > k && !cloneVisited[cur - 1]){
			dfs(cur - 1, sec + 1, cloneVisited);
		}
		if(cur * 2 < 100001 && cur < k && !cloneVisited[cur * 2]){
			dfs(cur * 2, sec + 1, cloneVisited);
		}
	}
}
