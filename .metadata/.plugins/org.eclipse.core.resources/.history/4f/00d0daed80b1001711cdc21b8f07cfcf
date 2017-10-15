//package samsung.practice1;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class P13460DFS {
//	static char[][] map = new char[101][101];
//	static boolean visited[][][][] = new boolean[11][11][11][11];
//	static int n = 0;
//	static int m = 0;
//	static int[] locationR = new int[2];
//	static int[] locationB = new int[2];
//	static int[] locationO = new int[2];
//
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		n = in.nextInt();
//		m = in.nextInt();
//		in.nextLine();
//
//		// map 입력
//		for (int i = 1; i <= n; i++) {
//			String line = in.nextLine();
//			for (int j = 1; j <= m; j++) {
//				map[i][j] = line.charAt(j - 1);
//			}
//		}
//
//		// R,B,O 초기 좌표 저장
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= m; j++) {
//				if (map[i][j] == 'R') {
//					locationR[0] = j;
//					locationR[1] = i;
//				} else if (map[i][j] == 'B') {
//					locationB[0] = j;
//					locationB[1] = i;
//				} else if (map[i][j] == 'O') {
//					locationO[0] = j;
//					locationO[1] = i;
//				}
//			}
//		}
//
//		dfs(locationR[0], locationR[1], locationB[0], locationB[1], 0);
//
//	}
//
//	public static void dfs(int curXR, int curYR, int curXB, int curYB, int cnt) {
//		visited[curXR][curYR][curXB][curYB] = true;
//		for (int i = 1; i <= 4; i++) {
//			if (!visited[curXR][curYR][curXB][curYB]) {
//				switch (i) {
//				case 1:// 상
//					if (curXR == curXB) {// RB 같은 열에 있으면
//						if (curYR < curYB) {// R이 위에 있으면
//							// R 상방 확인
//							int skip = 0;
//							int tmpR = 0;
//							int xR = 0, yR = 0, xB = 0, yB = 0;
//							while (true) {
//								tmpR++;
//								if(curYR - tmpR > 1){ // 상벽에 닿는지 확인
//									if (map[curYR - tmpR][curXR] == '#') {
//										xR = curXR;
//										yR = curYR - tmpR + 1;
//										break;
//									} else if(map[curYR - tmpR][curXR] == '.'){
//										continue;
//									} else if(map[curYR - tmpR][curXR] == 'O'){// 골이면
//										int checkB = 0;
//										while(true){
//											checkB++;
//											if (map[curYR + checkB][curXR] == '#') {
//												System.out.println(cnt + 1);
//												return;
//											} else if(map[curYR + checkB][curXR] == '.'){
//												continue;
//											} else if(curYR + checkB == curYB){
//												skip = 1;
//												break;
//											}
//										}
//										break;
//									}
//								}else{
//									xR = curXR;
//									yR = curYR - tmpR + 1;
//									break;
//								}
//							}
//							// B 상방 확인
//							if(skip == 0){
//								int tmpB = 0;
//								while (true) {
//									tmpB++;
//									if(curYB - tmpB > 1){ // 상벽에 닿는지 확인
//										if (map[curYB - tmpB][curXB] == '#' ) {
//											xB = curXB;
//											yB = curYB - tmpB + 1;
//											break;
//										} else if(curYB - tmpB == curYR - tmpR + 1){
//											xB = curYR - tmpR + 2;
//											yB = curYB;
//											break;
//										} else if(map[curYB - tmpB][curXB] == '.'){
//											continue;
//										} else if(map[curYB - tmpB][curXB] == 'O'){// 골이면
//											break;
//										}
//									}
//								}
//								dfs(xR, yR, xB, yB, cnt + 1);
//							}
//						} else {// B가 위에 있으면
//							// B 상방 확인
//							int tmpB = 0;
//							int xR = 0, yR = 0, xB = 0, yB = 0;
//							while (true) {
//								tmpB++;
//								if(curYB - tmpB > 1){ // 상벽에 닿는지 확인
//									if (map[curYB - tmpB][curXB] == '#') {
//										xB = curXB;
//										yB = curYB - tmpB + 1;
//										break;
//									} else if(map[curYB - tmpB][curXB] == '.'){
//										continue;
//									} else if(map[curYB - tmpB][curXB] == 'O'){// 골이면
//										break;
//									}
//								}else{
//									break;
//								}
//							}
//							// R 상방 확인
//							int tmpR = 0;
//							while (true) {
//								tmpR++;
//								if(curYR - tmpR > 1){ // 상벽에 닿는지 확인
//									if (map[curYR - tmpR][curXR] == '#') {
//										q.add(curXR);
//										q.add(curYR - tmpR + 1);
//										break;
//									} else if(curYR - tmpR == curYB - tmpB + 1){
//										q.add(curYB - tmpB + 2);
//										q.add(curYB);
//										break;
//									} else if(map[curYR - tmpR][curXR] == '.'){
//										continue;
//									} else if(map[curYR - tmpR][curXR] == 'O'){// 골이면
//										System.out.println(cnt + 1);
//										return;
//									}
//								}
//							}
//							q.add(cnt + 1);
//						}
//					} else {// RB 같은 열에 없으면
//						// R 상방 확인
//						int tmpR = 0;
//						while (true) {
//							tmpR++;
//							if(curYR - tmpR > 1){ // 상벽에 닿는지 확인
//								if (map[curYR - tmpR][curXR] == '#') {
//									q.add(curXR);
//									q.add(curYR - tmpR + 1);
//									break;
//								} else if(map[curYR - tmpR][curXR] == '.'){
//									continue;
//								} else if(map[curYR - tmpR][curXR] == 'O'){// 골이면
//									System.out.println(cnt + 1);
//									return;
//								}
//							}else{
//								q.add(curXR);
//								q.add(curYR - tmpR + 1);
//								break;
//							}
//						}
//						// B 상방 확인
//						int tmpB = 0;
//						while (true) {
//							tmpB++;
//							if(curYB - tmpB > 1){ // 상벽에 닿는지 확인
//								if (map[curYB - tmpB][curXB] == '#') {
//									q.add(curXB);
//									q.add(curYB - tmpB + 1);
//									break;
//								} else if(map[curYB - tmpB][curXB] == '.'){
//									continue;
//								} else if(map[curYB - tmpB][curXB] == 'O'){// 골이면
//									
//									break;
//								}
//							}else{
//								q.add(curXB);
//								q.add(curYB - tmpB + 1);
//								break;
//							}
//						}
//						q.add(cnt + 1);
//					}
//				case 2:// 하
//
//				case 3:// 좌
//
//				case 4:// 우
//
//				}
//			}
//		}
//	}
//
//}
