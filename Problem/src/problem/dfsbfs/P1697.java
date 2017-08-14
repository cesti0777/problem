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

// 걷기 x +1,-1
// 순간이동 x*2
// 경우는 3가지 x+1, x-1, x*2

// 문제
// 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고,
// 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다.
// 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
// 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
//
// 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
//
// 입력
// 첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다.
//
// 출력
// 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
//
// 예제 입력 복사
// 5 17
// 예제 출력 복사
// 4
// 힌트
// 수빈이가 5-10-9-18-17 순으로 가면 4초만에 동생을 찾을 수 있다.