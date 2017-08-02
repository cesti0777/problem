package problem.dfsbfs;

import java.util.Scanner;

public class P2178 {
	static int n, m, nodeCnt = 0;
	static boolean[][] map;
	static boolean[][][][] edge;
	static boolean[][] visited;
	static Scanner in = new Scanner(System.in);

	public static void makeEdge(int x, int y) {
		visited[x][y] = true;
		if (x == n && y == m){
			return;
		}
			
		if (x + 1 <= n && y <= m && (map[x + 1][y] || !visited[x + 1][y])) {// 하
			edge[x][y][x + 1][y] = true;
			makeEdge(x + 1, y);
		}
		if (x <= n && y + 1 <= m && (map[x][y + 1] || !visited[x][y + 1])) {// 우
			edge[x][y][x][y + 1] = true;
			makeEdge(x, y + 1);
		}
		if (x - 1 <= n && y <= m && (map[x - 1][y] || !visited[x - 1][y])) {// 상
			edge[x][y][x - 1][y] = true;
			makeEdge(x - 1, y);
		}
		if (x <= n && y - 1 <= m && (map[x][y - 1] || !visited[x][y - 1])) {// 좌
			edge[x][y][x][y - 1] = true;
			makeEdge(x, y - 1);
		}
	}

	public static void main(String[] args) {
		try {
			n = in.nextInt();
			m = in.nextInt();
			map = new boolean[n + 1][m + 1];
			visited = new boolean[n + 1][m + 1];
			edge = new boolean[n + 1][m + 1][n + 1][m + 1];
			in.nextLine();
			for (int i = 1; i <= n; i++) {
				String line = in.nextLine();
				for (int j = 1; j <= m; j++) {
					if (line.charAt(j - 1) == '1') {
						map[i][j] = true;
						nodeCnt++;
					}
				}
			}
			// for(int i = 1 ; i <= n; i++){
			// for(int j = 1 ; j <= m; j++){
			// if(map[i][j]){
			// System.out.print(1);
			// }else{
			// System.out.print(0);
			// }
			// }
			// System.out.println();
			// }
			makeEdge(1, 1);
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (visited[i][j]) {
						System.out.print(1);
					} else {
						System.out.print(0);
					}
				}
				System.out.println();
			}
		} finally {
			in.close();
			in = null;
		}
	}

}

// 예제 입력 복사
// 4 6
// 101111
// 101010
// 101011
// 111011
// 예제 출력 복사
// 15
// 예제 입력 2 복사
// 4 6
// 110110
// 110110
// 111111
// 111101
// 예제 출력 2 복사
// 9