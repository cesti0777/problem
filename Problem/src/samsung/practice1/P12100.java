package samsung.practice1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P12100 {
	static int n;
	static int map[][] = new int[20][20];
	static boolean visited[][] = new boolean[20][20];
	static Map cloneMap;
	static int max;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();

		// 맵 입력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = in.nextInt();
			}
		}

		// print();

		Queue<Map> q = new LinkedList<Map>();
		q.add(new Map(map, visited, 0));

		while (!q.isEmpty()) {
			int tmpI = 0;
			int tmpJ = 0;

			Map m = q.remove();

			if(m.cnt == 5){
				continue;
			}
			
			// 상
			// 한 열씩 보면서 0보타 큰 수를 찾고
			// 그 수와 같은 수가 있는지 찾아서 합친다
			// 합친 후 visited표시
			cloneMap = cloneMap(m);
//			System.out.println(11111);
			for (int j = 0; j < n; j++) {
				int cnt = 0;
				for (int i = 0; i < n; i++) {
					if (cloneMap.map[i][j] > 0) {
						tmpI = i;
						tmpJ = j;
						cnt++;
						if (i < n - 1) {
							for (int k = i + 1; k < n; k++) {
								if (cloneMap.map[k][j] > 0) {
									if(visited[k][j] == true){
										i = k - 1;
										break;
									} else if (cloneMap.map[k][j] == cloneMap.map[tmpI][tmpJ]) {
										cloneMap.map[tmpI][tmpJ] *= 2;
										cloneMap.map[k][j] = 0;
										cloneMap.visited[tmpI][tmpJ] = true;
									} else{
										i = k - 1;
										break;
									}
								}
							}
						}
					}
				}
//				print(cloneMap);
//				System.out.println();
				int tmp = 0;
				boolean tmpB = false;
				for (int i = 0; i < cnt; i++) {
					for (int k = i; k < n; k++) {
						if (cloneMap.map[k][j] > 0) {
							tmp = cloneMap.map[k][j];
							cloneMap.map[k][j] = 0;
							cloneMap.map[i][j] = tmp;
							tmpB = cloneMap.visited[k][j];
							cloneMap.visited[i][j] = tmpB;
							break;
						}
					}
				}
			}
//			print(cloneMap);
			countMax(cloneMap);
			if(!isSameMap(cloneMap, m)){
				cloneMap.cnt++;
				q.add(cloneMap);
			}
			

			// 하
			cloneMap = cloneMap(m);
//			System.out.println(22222);
			for (int j = 0; j < n; j++) {
				int cnt = 0;
				for (int i = n - 1; i >= 0; i--) {
					if (cloneMap.map[i][j] > 0) {
						tmpI = i;
						tmpJ = j;
						cnt++;
						if (i > 0) {
							for (int k = i - 1; k >= 0; k--) {
								if (cloneMap.map[k][j] > 0) {
									if(visited[k][j] == true){
										i = k + 1;
										break;
									} else if (cloneMap.map[k][j] == cloneMap.map[tmpI][tmpJ]) {
										cloneMap.map[tmpI][tmpJ] *= 2;
										cloneMap.map[k][j] = 0;
										cloneMap.visited[tmpI][tmpJ] = true;
									}else{
										i = k + 1;
										break;
									}
								}
							}
						}
					}
				}
				int tmp = 0;
				boolean tmpB = false;
				for (int i = n - 1; i >= n - cnt; i--) {
					for (int k = i; k >= 0; k--) {
						if (cloneMap.map[k][j] > 0) {
							tmp = cloneMap.map[k][j];
							cloneMap.map[k][j] = 0;
							cloneMap.map[i][j] = tmp;
							tmpB = cloneMap.visited[k][j];
							cloneMap.visited[i][j] = tmpB;
							break;
						}
					}
				}
			}
//			print(cloneMap);
			countMax(cloneMap);
			if(!isSameMap(cloneMap, m)){
				cloneMap.cnt++;
				q.add(cloneMap);
			}

			// 좌
			cloneMap = cloneMap(m);
//			System.out.println(33333);
			for (int i = 0; i < n; i++) {
				int cnt = 0;
				for (int j = 0; j < n; j++) {
					if (cloneMap.map[i][j] > 0) {
						tmpI = i;
						tmpJ = j;
						cnt++;
						if (j < n - 1) {
							for (int k = j + 1; k < n; k++) {
								if (cloneMap.map[i][k] > 0) {
									if(visited[i][k] == true){
										j = k - 1;
										break;
									} else if (cloneMap.map[i][k] == cloneMap.map[tmpI][tmpJ]) {
										cloneMap.map[tmpI][tmpJ] *= 2;
										cloneMap.map[i][k] = 0;
										cloneMap.visited[tmpI][tmpJ] = true;
									} else{
										j = k - 1;
										break;
									}
								}
							}
						}
					}
				}
				int tmp = 0;
				boolean tmpB = false;
				for (int j = 0; j < cnt; j++) {
					for (int k = j; k < n; k++) {
						if (cloneMap.map[i][k] > 0) {
							tmp = cloneMap.map[i][k];
							cloneMap.map[i][k] = 0;
							cloneMap.map[i][j] = tmp;
							tmpB = cloneMap.visited[i][k];
							cloneMap.visited[i][j] = tmpB;
							break;
						}
					}
				}
			}
//			print(cloneMap);
			countMax(cloneMap);
			if(!isSameMap(cloneMap, m)){
				cloneMap.cnt++;
				q.add(cloneMap);
			}

			// 우
			cloneMap = cloneMap(m);
//			System.out.println(44444);
//			print(cloneMap);
			for (int i = 0; i < n; i++) {
				int cnt = 0;
				for (int j = n - 1; j >= 0; j--) {
					if (cloneMap.map[i][j] > 0) {
						tmpI = i;
						tmpJ = j;
						cnt++;
						if (j > 0) {
							for (int k = j - 1; k >= 0; k--) {
								if (cloneMap.map[i][k] > 0) {
									if(visited[i][k] == true){
										j = k + 1;
										break;
									} if (cloneMap.map[i][k] == cloneMap.map[tmpI][tmpJ]) {
										cloneMap.map[tmpI][tmpJ] *= 2;
										cloneMap.map[i][k] = 0;
										cloneMap.visited[tmpI][tmpJ] = true;
									} else {
										j = k + 1;
										break;
									}
								}
							}
						}
					}
				}
//				System.out.println("합치기");
//				print(cloneMap);
//				System.out.println();
				int tmp = 0;
				boolean tmpB = false;
				for (int j = n - 1; j >= n - cnt; j--) {
					for (int k = j; k >= 0; k--) {
						if (cloneMap.map[i][k] > 0) {
							tmp = cloneMap.map[i][k];
							cloneMap.map[i][k] = 0;
							cloneMap.map[i][j] = tmp;
							tmpB = cloneMap.visited[i][k];
							cloneMap.visited[i][j] = tmpB;
							break;
						}
					}
				}
			}
			countMax(cloneMap);
			if(!isSameMap(cloneMap, m)){
				cloneMap.cnt++;
				q.add(cloneMap);
			}
//			System.out.println("자리이동");
//			print(cloneMap);
			m = null;
		}
		System.out.println(max);
	}

	public static void print(Map m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(m.map[i][j]);
			}
			System.out.println();
		}
	}

	public static void countMax(Map m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, m.map[i][j]);
			}
		}

	}
	
	public static boolean isSameMap(Map m1, Map m2){
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(m1.map[i][j] != m2.map[i][j]){
					return false;
				}
			}
		}
		return true;
	}

	public static class Map {
		int[][] map = new int[20][20];
		boolean[][] visited = new boolean[20][20];
		int cnt = 0;
		public Map() {}
		public Map(int[][] map, boolean[][] visited, int cnt) {
			super();
			this.map = map;
			this.visited = visited;
			this.cnt = cnt;
		}
	}
	
	public static Map cloneMap(Map m){
		int map[][] = new int[20][20];
		boolean visited[][] = new boolean[20][20];
		int cnt = m.cnt;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = m.map[i][j];
				visited[i][j] = m.visited[i][j];
			}
		}
		
		return new Map(map, visited, cnt);
	}
}
