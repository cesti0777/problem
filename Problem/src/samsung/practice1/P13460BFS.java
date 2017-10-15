package samsung.practice1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P13460BFS {
	static char[][] map = new char[101][101];
	static boolean visited[][][][] = new boolean[11][11][11][11];
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

		// map �Է�
		for (int i = 1; i <= n; i++) {
			String line = in.nextLine();
			for (int j = 1; j <= m; j++) {
				map[i][j] = line.charAt(j - 1);
			}
		}

		// R,B,O �ʱ� ��ǥ ����
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[i][j] == 'R') {
					locationR[0] = j;
					locationR[1] = i;
				} else if (map[i][j] == 'B') {
					locationB[0] = j;
					locationB[1] = i;
				} else if (map[i][j] == 'O') {
					locationO[0] = j;
					locationO[1] = i;
				}
			}
		}

		bfs(locationR[0], locationR[1], locationB[0], locationB[1], 0);

	}

	static void printMap() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	static void bfs(int curXR, int curYR, int curXB, int curYB, int cnt) {
		Queue<Integer> q = new LinkedList<>();
		int xR, yR, xB, yB;
		int bGoal;
		int tmpR, tmpB;
		q.add(curXR);
		q.add(curYR);
		q.add(curXB);
		q.add(curYB);
		q.add(cnt);

		while (!q.isEmpty()) {
			curXR = q.remove();
			curYR = q.remove();
			curXB = q.remove();
			curYB = q.remove();
			cnt = q.remove();

//			System.out.print(curXR);
//			System.out.print(curYR);
//			System.out.print(curXB);
//			System.out.print(curYB);
//			System.out.print(cnt);
//			System.out.println();

			// ī��Ʈ �ʰ�
			if (cnt == 10) {
				System.out.println(-1);
				return;
			}
			if (visited[curXR][curYR][curXB][curYB] != true) {
				visited[curXR][curYR][curXB][curYB] = true;
				// ��
				if (curXR == curXB) {//RB ���� ���� ������
					if (curYR < curYB) {//R�� ���� ������
						//R ��� Ȯ��
						xR = yR = xB = yB = bGoal = tmpR = tmpB = 0;
						while (true) {
							tmpR++;
							if (map[curYR - tmpR][curXR] == '#') {//�󺮿� ������
								xR = curXR;
								yR = curYR - tmpR + 1;
								break;
							} else if (map[curYR - tmpR][curXR] == '.') {//���� ������
								continue;
							} else if (map[curYR - tmpR][curXR] == 'O') {//���̸�
								int checkB = 0;
								while (true) {//B�� ���� ������ üũ
									checkB++;
									if (map[curYR + checkB][curXR] == '#') {//R�� ��
										System.out.println(cnt + 1);
										return;
									} else if (map[curYR + checkB][curXR] == '.') {//R�� B���̿� ���� ������
										continue;
									} else if (curYR + checkB == curYB) {//B�� ���� ��
										bGoal = 1;
										break;
									}
								}
								break;
							}
						}
						//B ��� Ȯ��
						if (bGoal == 0) {//B�� ���� �ƴϸ�
							while (true) {
								tmpB++;
								if (map[curYB - tmpB][curXB] == '#') {//�󺮿� ������
									xB = curXB;
									yB = curYB - tmpB + 1;
									break;
								} else if (curYB - tmpB == curYR - tmpR + 1) {//R�� ������
									xB = curXB;
									yB = curYR - tmpR + 2;
									break;
								} else if (map[curYB - tmpB][curXB] == '.') {//���� ������
									continue;
								} else if (map[curYB - tmpB][curXB] == 'O') {//���̸�
									bGoal = 1;
									break;
								}
							}
							if (bGoal == 0) {// B�� ���� �ƴϸ� ť�� Ǫ��
								q.add(xR); q.add(yR); q.add(xB); q.add(yB); q.add(cnt + 1);
							}
						}
					} else {// B�� ���� ������
						// B ��� Ȯ��
						xR = yR = xB = yB = bGoal = tmpR = tmpB = 0;
						while (true) {
							tmpB++;
							if (map[curYB - tmpB][curXB] == '#') {// �󺮿� ������
								xB = curXB;
								yB = curYB - tmpB + 1;
								break;
							} else if (map[curYB - tmpB][curXB] == '.') {// ���� ������
								continue;
							} else if (map[curYB - tmpB][curXB] == 'O') {// ���̸�
								bGoal = 1;
								break;
							}
						}
						// R ��� Ȯ��
						if(bGoal == 0){ // B�� ���� �ƴϸ�
							while (true) {
								tmpR++;
								if (map[curYR - tmpR][curXR] == '#') {// �󺮿� ������
									xR = curXR;
									yR = curYR - tmpR + 1;
									break;
								} else if (curYR - tmpR == curYB - tmpB + 1) {//B�� ������
									xR = curXR;
									yR = curYB - tmpB + 2;
									break;
								} else if (map[curYR - tmpR][curXR] == '.') {// ���� ������
									continue;
								} else if (map[curYR - tmpR][curXR] == 'O') {// ���̸�
									System.out.println(cnt + 1);
									return;
								}
							}
						}
						if (bGoal == 0) {// B�� ���� �ƴϸ� ť�� Ǫ��
							q.add(xR); q.add(yR); q.add(xB); q.add(yB); q.add(cnt + 1);
						}
					}
				} else {// RB ���� ���� ������
					// R ��� Ȯ��
					xR = yR = xB = yB = bGoal = tmpR = tmpB = 0;
					while (true) {
						tmpR++;
						if (map[curYR - tmpR][curXR] == '#') {
							xR = curXR;
							yR = curYR - tmpR + 1;
							break;
						} else if (map[curYR - tmpR][curXR] == '.') {
							continue;
						} else if (map[curYR - tmpR][curXR] == 'O') {// ���̸�
							System.out.println(cnt + 1);
							return;
						}
					}
					// B ��� Ȯ��
					while (true) {
						tmpB++;
						if (map[curYB - tmpB][curXB] == '#') {
							xB = curXB;
							yB = curYB - tmpB + 1;
							break;
						} else if (map[curYB - tmpB][curXB] == '.') {
							continue;
						} else if (map[curYB - tmpB][curXB] == 'O') {// ���̸�
							bGoal = 1;
							break;
						}
					}
					if (bGoal == 0) {// B�� ���� �ƴϸ� ť�� Ǫ��
						q.add(xR); q.add(yR); q.add(xB); q.add(yB); q.add(cnt + 1);
					}
				}

				// ��
				if (curXR == curXB) {//RB ���� ���� ������
					if (curYR > curYB) {//R�� �Ʒ��� ������
						//R �Ϲ� Ȯ��
						xR = yR = xB = yB = bGoal = tmpR = tmpB = 0;
						while (true) {
							tmpR++;
							if (map[curYR + tmpR][curXR] == '#') {//�Ϻ��� ������
								xR = curXR;
								yR = curYR + tmpR - 1;
								break;
							} else if (map[curYR + tmpR][curXR] == '.') {//���� ������
								continue;
							} else if (map[curYR + tmpR][curXR] == 'O') {//���̸�
								int checkB = 0;
								while (true) {//B�� ���� ������ üũ
									checkB++;
									if (map[curYR - checkB][curXR] == '#') {//R�� ��
										System.out.println(cnt + 1);
										return;
									} else if (map[curYR - checkB][curXR] == '.') {//R�� B���̿� ���� ������
										continue;
									} else if (curYR - checkB == curYB) {//B�� ���� ��
										bGoal = 1;
										break;
									}
								}
								break;
							}
						}
						//B �Ϲ� Ȯ��
						if (bGoal == 0) {//B�� ���� �ƴϸ�
							while (true) {
								tmpB++;
								if (map[curYB + tmpB][curXB] == '#') {//�Ϻ��� ������
									xB = curXB;
									yB = curYB + tmpB - 1;
									break;
								} else if (curYB + tmpB == curYR + tmpR - 1) {//R�� ������
									xB = curXB;
									yB = curYR + tmpR - 2;
									break;
								} else if (map[curYB + tmpB][curXB] == '.') {//���� ������
									continue;
								} else if (map[curYB + tmpB][curXB] == 'O') {//���̸�
									bGoal = 1;
									break;
								}
							}
							if (bGoal == 0) {// B�� ���� �ƴϸ� ť�� Ǫ��
								q.add(xR); q.add(yR); q.add(xB); q.add(yB); q.add(cnt + 1);
							}
						}
					} else {// B�� �Ʒ��� ������
						// B �Ϲ� Ȯ��
						xR = yR = xB = yB = bGoal = tmpR = tmpB = 0;
						while (true) {
							tmpB++;
							if (map[curYB + tmpB][curXB] == '#') {// �Ϻ��� ������
								xB = curXB;
								yB = curYB + tmpB - 1;
								break;
							} else if (map[curYB + tmpB][curXB] == '.') {// ���� ������
								continue;
							} else if (map[curYB + tmpB][curXB] == 'O') {// ���̸�
								bGoal = 1;
								break;
							}
						}
						// R �Ϲ� Ȯ��
						if(bGoal == 0){ // B�� ���� �ƴϸ�
							while (true) {
								tmpR++;
								if (map[curYR + tmpR][curXR] == '#') {// �Ϻ��� ������
									xR = curXR;
									yR = curYR + tmpR - 1;
									break;
								} else if (curYR + tmpR == curYB + tmpB - 1) {//B�� ������
									xR = curXR;
									yR = curYB + tmpB - 2;
									break;
								} else if (map[curYR + tmpR][curXR] == '.') {// ���� ������
									continue;
								} else if (map[curYR + tmpR][curXR] == 'O') {// ���̸�
									System.out.println(cnt + 1);
									return;
								}
							}
						}
						if (bGoal == 0) {// B�� ���� �ƴϸ� ť�� Ǫ��
							q.add(xR); q.add(yR); q.add(xB); q.add(yB); q.add(cnt + 1);
						}
					}
				} else {// RB ���� ���� ������
					// R �Ϲ� Ȯ��
					xR = yR = xB = yB = bGoal = tmpR = tmpB = 0;
					while (true) {
						tmpR++;
						if (map[curYR + tmpR][curXR] == '#') {
							xR = curXR;
							yR = curYR + tmpR - 1;
							break;
						} else if (map[curYR + tmpR][curXR] == '.') {
							continue;
						} else if (map[curYR + tmpR][curXR] == 'O') {// ���̸�
							System.out.println(cnt + 1);
							return;
						}
					}
					// B �Ϲ� Ȯ��
					while (true) {
						tmpB++;
						if (map[curYB + tmpB][curXB] == '#') {
							xB = curXB;
							yB = curYB + tmpB - 1;
							break;
						} else if (map[curYB + tmpB][curXB] == '.') {
							continue;
						} else if (map[curYB + tmpB][curXB] == 'O') {// ���̸�
							bGoal = 1;
							break;
						}
					}
					if (bGoal == 0) {// B�� ���� �ƴϸ� ť�� Ǫ��
						q.add(xR); q.add(yR); q.add(xB); q.add(yB); q.add(cnt + 1);
					}
				}
				// ��
				if (curYR == curYB) {//RB ���� �࿡ ������
					if (curXR < curXB) {//R�� ���ʿ� ������
						//R �¹� Ȯ��
						xR = yR = xB = yB = bGoal = tmpR = tmpB = 0;
						while (true) {
							tmpR++;
							if (map[curYR][curXR - tmpR] == '#') {//�º��� ������
								xR = curXR - tmpR + 1;
								yR = curYR;
								break;
							} else if (map[curYR][curXR - tmpR] == '.') {//���� ������
								continue;
							} else if (map[curYR][curXR - tmpR] == 'O') {//���̸�
								int checkB = 0;
								while (true) {//B�� ���� ������ üũ
									checkB++;
									if (map[curYR][curXR + checkB] == '#') {//R�� ��
										System.out.println(cnt + 1);
										return;
									} else if (map[curYR][curXR + checkB] == '.') {//R�� B���̿� ���� ������
										continue;
									} else if (curXR + checkB == curXB) {//B�� ���� ��
										bGoal = 1;
										break;
									}
								}
								break;
							}
						}
						//B �¹� Ȯ��
						if (bGoal == 0) {//B�� ���� �ƴϸ�
							while (true) {
								tmpB++;
								if (map[curYB][curXB - tmpB] == '#') {//�º��� ������
									xB = curXB - tmpB + 1;
									yB = curYB;
									break;
								} else if (curXB - tmpB == curXR - tmpR + 1) {//R�� ������
									xB = curXR - tmpR + 2;
									yB = curYB;
									break;
								} else if (map[curYB][curXB - tmpB] == '.') {//���� ������
									continue;
								} else if (map[curYB][curXB - tmpB] == 'O') {//���̸�
									bGoal = 1;
									break;
								}
							}
							if (bGoal == 0) {// B�� ���� �ƴϸ� ť�� Ǫ��
								q.add(xR); q.add(yR); q.add(xB); q.add(yB); q.add(cnt + 1);
							}
						}
					} else {// B�� ���ʿ� ������
						// B �¹� Ȯ��
						xR = yR = xB = yB = bGoal = tmpR = tmpB = 0;
						while (true) {
							tmpB++;
							if (map[curYB][curXB - tmpB] == '#') {// �Ϻ��� ������
								xB = curXB - tmpB + 1;
								yB = curYB;
								break;
							} else if (map[curYB][curXB - tmpB] == '.') {// ���� ������
								continue;
							} else if (map[curYB][curXB - tmpB] == 'O') {// ���̸�
								bGoal = 1;
								break;
							}
						}
						// R �¹� Ȯ��
						if(bGoal == 0){ // B�� ���� �ƴϸ�
							while (true) {
								tmpR++;
								if (map[curYR][curXR - tmpR] == '#') {// �º��� ������
									xR = curXR - tmpR + 1;
									yR = curYR;
									break;
								} else if (curXR - tmpR == curXB - tmpB + 1) {//B�� ������
									xR = curXB - tmpB + 2;
									yR = curYB;
									break;
								} else if (map[curYR][curXR - tmpR] == '.') {// ���� ������
									continue;
								} else if (map[curYR][curXR - tmpR] == 'O') {// ���̸�
									System.out.println(cnt + 1);
									return;
								}
							}
						}
						if (bGoal == 0) {// B�� ���� �ƴϸ� ť�� Ǫ��
							q.add(xR); q.add(yR); q.add(xB); q.add(yB); q.add(cnt + 1);
						}
					}
				} else {// RB ���� ���� ������
					// R �¹� Ȯ��
					xR = yR = xB = yB = bGoal = tmpR = tmpB = 0;
					while (true) {
						tmpR++;
						if (map[curYR][curXR - tmpR] == '#') {
							xR = curXR - tmpR + 1;
							yR = curYR;
							break;
						} else if (map[curYR][curXR - tmpR] == '.') {
							continue;
						} else if (map[curYR][curXR - tmpR] == 'O') {// ���̸�
							System.out.println(cnt + 1);
							return;
						}
					}
					// B �¹� Ȯ��
					while (true) {
						tmpB++;
						if (map[curYB][curXB - tmpB] == '#') {
							xB = curXB - tmpB + 1;
							yB = curYB;
							break;
						} else if (map[curYB][curXB - tmpB] == '.') {
							continue;
						} else if (map[curYB][curXB - tmpB] == 'O') {// ���̸�
							bGoal = 1;
							break;
						}
					}
					if (bGoal == 0) {// B�� ���� �ƴϸ� ť�� Ǫ��
						q.add(xR); q.add(yR); q.add(xB); q.add(yB); q.add(cnt + 1);
					}
				}

				// ��
				if (curYR == curYB) {//RB ���� �࿡ ������
					if (curXR > curXB) {//R�� �����ʿ� ������
						//R ��� Ȯ��
						xR = yR = xB = yB = bGoal = tmpR = tmpB = 0;
						while (true) {
							tmpR++;
							if (map[curYR][curXR + tmpR] == '#') {//�캮�� ������
								xR = curXR + tmpR - 1;
								yR = curYR;
								break;
							} else if (map[curYR][curXR + tmpR] == '.') {//���� ������
								continue;
							} else if (map[curYR][curXR + tmpR] == 'O') {//���̸�
								int checkB = 0;
								while (true) {//B�� ���� ������ üũ
									checkB++;
									if (map[curYR][curXR - checkB] == '#') {//R�� ��
										System.out.println(cnt + 1);
										return;
									} else if (map[curYR][curXR - checkB] == '.') {//R�� B���̿� ���� ������
										continue;
									} else if (curXR - checkB == curXB) {//B�� ���� ��
										bGoal = 1;
										break;
									}
								}
								break;
							}
						}
						//B ��� Ȯ��
						if (bGoal == 0) {//B�� ���� �ƴϸ�
							while (true) {
								tmpB++;
								if (map[curYB][curXB + tmpB] == '#') {//�캮�� ������
									xB = curXB + tmpB - 1;
									yB = curYB;
									break;
								} else if (curXB + tmpB == curXR + tmpR - 1) {//R�� ������
									xB = curXR + tmpR - 2;
									yB = curYB;
									break;
								} else if (map[curYB][curXB + tmpB] == '.') {//���� ������
									continue;
								} else if (map[curYB][curXB + tmpB] == 'O') {//���̸�
									bGoal = 1;
									break;
								}
							}
							if (bGoal == 0) {// B�� ���� �ƴϸ� ť�� Ǫ��
								q.add(xR); q.add(yR); q.add(xB); q.add(yB); q.add(cnt + 1);
							}
						}
					} else {// B�� �����ʿ� ������
						// B ��� Ȯ��
						xR = yR = xB = yB = bGoal = tmpR = tmpB = 0;
						while (true) {
							tmpB++;
							if (map[curYB][curXB + tmpB] == '#') {// �캮�� ������
								xB = curXB + tmpB - 1;
								yB = curYB;
								break;
							} else if (map[curYB][curXB + tmpB] == '.') {// ���� ������
								continue;
							} else if (map[curYB][curXB + tmpB] == 'O') {// ���̸�
								bGoal = 1;
								break;
							}
						}
						// R ��� Ȯ��
						if(bGoal == 0){ // B�� ���� �ƴϸ�
							while (true) {
								tmpR++;
								if (map[curYR][curXR + tmpR] == '#') {// �캮�� ������
									xR = curXR + tmpR - 1;
									yR = curYR;
									break;
								} else if (curXR + tmpR == curXB + tmpB - 1) {//B�� ������
									xR = curXB + tmpB - 2;
									yR = curYB;
									break;
								} else if (map[curYR][curXR + tmpR] == '.') {// ���� ������
									continue;
								} else if (map[curYR][curXR + tmpR] == 'O') {// ���̸�
									System.out.println(cnt + 1);
									return;
								}
							}
						}
						if (bGoal == 0) {// B�� ���� �ƴϸ� ť�� Ǫ��
							q.add(xR); q.add(yR); q.add(xB); q.add(yB); q.add(cnt + 1);
						}
					}
				} else {// RB ���� ���� ������
					// R ��� Ȯ��
					xR = yR = xB = yB = bGoal = tmpR = tmpB = 0;
					while (true) {
						tmpR++;
						if (map[curYR][curXR + tmpR] == '#') {
							xR = curXR + tmpR - 1;
							yR = curYR;
							break;
						} else if (map[curYR][curXR + tmpR] == '.') {
							continue;
						} else if (map[curYR][curXR + tmpR] == 'O') {// ���̸�
							System.out.println(cnt + 1);
							return;
						}
					}
					// B ��� Ȯ��
					while (true) {
						tmpB++;
						if (map[curYB][curXB + tmpB] == '#') {
							xB = curXB + tmpB - 1;
							yB = curYB;
							break;
						} else if (map[curYB][curXB + tmpB] == '.') {
							continue;
						} else if (map[curYB][curXB + tmpB] == 'O') {// ���̸�
							bGoal = 1;
							break;
						}
					}
					if (bGoal == 0) {// B�� ���� �ƴϸ� ť�� Ǫ��
						q.add(xR); q.add(yR); q.add(xB); q.add(yB); q.add(cnt + 1);
					}
				}
			}
		}
		System.out.println(-1); // ���� ��� ť�� �ƹ��͵� ������
	}
}