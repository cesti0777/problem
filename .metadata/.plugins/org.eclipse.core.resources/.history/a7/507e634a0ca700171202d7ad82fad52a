package samsung.practice1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P13460 {
	static char[][] map = new char[101][101];
	static boolean visited[][] = new boolean[101][101];
	static int n = 0;
	static int m = 0;
	static int[] locationR = new int[2];
	static int[] locationB = new int[2];
	static int[] locationO = new int[2];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		in.nextLine();

		// map 입력
		for (int i = 1; i <= n; i++) {
			String line = in.nextLine();
			for (int j = 1; j <= m; j++) {
				map[i][j] = line.charAt(j - 1);
			}
		}

		// R,B,O 초기 좌표 저장
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[i][j] == 'R') {
					locationR[0] = i;
					locationR[1] = j;
				} else if (map[i][j] == 'B') {
					locationB[0] = i;
					locationB[1] = j;
				} else if (map[i][j] == 'O') {
					locationO[0] = i;
					locationO[1] = j;
				}
			}
		}

		bfs(locationR[0], locationR[1], locationB[0], locationB[1], 0);

		// for (int i = 1; i <= n; i++) {
		// for (int j = 1; j <= m; j++) {
		// System.out.print(map[i][j]);
		// }
		// System.out.println();
		// }
	}

	static void bfs(int curXR, int curYR, int curXB, int curYB, int cnt) {
		Queue<Integer> q = new LinkedList<>();
		q.add(curXR);
		q.add(curYR);
		q.add(curXB);
		q.add(curYB);
		q.add(cnt);
		visited[curYR][curXR] = true;
		visited[curXB][curYB] = true;

		while (!q.isEmpty()) {
			curXR = q.remove();
			curYR = q.remove();
			curXB = q.remove();
			curYB = q.remove();
			cnt = q.remove();

			// R,B 골인
			if (cnt == 11) {
				System.out.println(-1);
				return;
			}
			
			//상
			if (curYR == curYB) {// RB 같은 열에 있으면
				if (curYR < curYB) {// R이 위에 있으면
					int tmp = 0;
					//R 상방향에 골이 있는지 확인
					while(true){
						tmp++;
						if(map[curYR-tmp][curXR] != 'O'){
							continue;
						}else{
							
						}
						
					}

					//R 상방향으로 갈 수 있는 끝지점으로 이동
					
					while(true){
						tmp++;
						if(map[curYR-tmp][curXR] != '#'){
							continue;
						}else{
							
						}
						
					}
				} else {// B가 위에 있으면
					//B 상방향으로 갈 수 있는 끝지점으로 이동
				}
			} else {// RB 같은 열에 없으면

			}
			//하
			
			//좌
			
			//우
			



			// int xR = curXR + dX[i];
			// int yR = curYR + dY[i];
			// int xB = curXR + dX[i];
			// int yB = curYR + dY[i];
			//
			// //벽검사
			// if ( && !visited[y][x] && map[y][x] == 1){
			// visited[y][x] = true;
			// q.add(x);
			// q.add(y);
			// q.add(length + 1);
			// }
		}

		// while (!q.isEmpty()) {
		// int here = q.remove();
		// System.out.print(String.valueOf(here) + ' ');
		// for (int there = 1; there <= n; there++) {
		// if (visited[there] || (!edge[here][there]))
		// continue;
		// visited[there] = true;
		// q.add(there);
		// }
		// }
	}
}
