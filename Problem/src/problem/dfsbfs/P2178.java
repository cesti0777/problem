package problem.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2178 {
	static int low, col;
	static int[][] map;
	static Queue<Integer> q;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	public static void bfs(int curX, int curY, int length) {
		q.add(curX);
		q.add(curY);
		q.add(length);
		while (!q.isEmpty()) {
			curX = q.remove();
			curY = q.remove();
			length = q.remove();
			if(curX == col && curY == low){
				System.out.println(length);
				return;
			}
			for(int i = 0; i < 4; i++){
				int x = curX + dx[i];
				int y = curY + dy[i];
				if (x <= col && y <= low && !visited[y][x] && map[y][x] == 1){
					visited[y][x] = true;
					q.add(x);
					q.add(y);
					q.add(length + 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			low = in.nextInt();
			col = in.nextInt();
			map = new int[low + 1][col + 1];
			visited = new boolean[low + 1][col + 1];
			q = new LinkedList<>();
			in.nextLine();
			for (int i = 1; i <= low; i++) {
				String line = in.nextLine();
				for (int j = 1; j <= col; j++) {
					map[i][j] = Character.getNumericValue(line.charAt(j - 1));
				}
			}
			bfs(1, 1, 1);
		} finally {
			in.close();
			in = null;
		}
	}
}

// 예제 입력 복사
//4 6
//101111
//101010
//101011
//111011
// 예제 출력 복사
// 15
// 예제 입력 2 복사
//4 6
//110110
//110110
//111111
//111101
// 예제 출력 2 복사
// 9