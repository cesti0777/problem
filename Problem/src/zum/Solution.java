package zum;

public class Solution {

	public String solution(int N, String S, String T) {
		String answer = null;
		int[][] map = new int[N + 1][N + 1];
		String[] ships = null;

		ships = S.split(",");
		int[] shipCnt = new int[ships.length + 1];

		String shipStart = null;
		String shipEnd = null;
		int rS = 0;
		int cS = 0;
		int rE = 0;
		int cE = 0;
		for (int i = 1; i <= ships.length; i++) {
			shipStart = ships[i - 1].split(" ")[0];
			shipEnd = ships[i - 1].split(" ")[1];

			for (int j = 0; j < 2; j++) {
				if (j == 0) {
					rS = Integer.parseInt(shipStart.substring(0, shipStart.length() - 1));
				} else {
					if (shipStart.charAt(shipStart.length() - 1) == 'A') {
						cS = 1;
					} else if (shipStart.charAt(shipStart.length() - 1) == 'B') {
						cS = 2;
					} else if (shipStart.charAt(shipStart.length() - 1) == 'C') {
						cS = 3;
					} else if (shipStart.charAt(shipStart.length() - 1) == 'D') {
						cS = 4;
					} else if (shipStart.charAt(shipStart.length() - 1) == 'E') {
						cS = 5;
					} else if (shipStart.charAt(shipStart.length() - 1) == 'F') {
						cS = 6;
					} else if (shipStart.charAt(shipStart.length() - 1) == 'G') {
						cS = 7;
					} else if (shipStart.charAt(shipStart.length() - 1) == 'H') {
						cS = 8;
					} else if (shipStart.charAt(shipStart.length() - 1) == 'I') {
						cS = 9;
					} else if (shipStart.charAt(shipStart.length() - 1) == 'J') {
						cS = 10;
					} else if (shipStart.charAt(shipStart.length() - 1) == 'K') {
						cS = 11;
					} else if (shipStart.charAt(shipStart.length() - 1) == 'L') {
						cS = 12;
					} else if (shipStart.charAt(shipStart.length() - 1) == 'M') {
						cS = 13;
					} else if (shipStart.charAt(shipStart.length() - 1) == 'N') {
						cS = 14;
					} else if (shipStart.charAt(shipStart.length() - 1) == 'O') {
						cS = 15;
					} else if (shipStart.charAt(shipStart.length() - 1) == 'P') {
						cS = 16;
					} else if (shipStart.charAt(shipStart.length() - 1) == 'Q') {
						cS = 17;
					} else if (shipStart.charAt(shipStart.length() - 1) == 'R') {
						cS = 18;
					} else if (shipStart.charAt(shipStart.length() - 1) == 'S') {
						cS = 19;
					} else if (shipStart.charAt(shipStart.length() - 1) == 'T') {
						cS = 20;
					} else if (shipStart.charAt(shipStart.length() - 1) == 'U') {
						cS = 21;
					} else if (shipStart.charAt(shipStart.length() - 1) == 'V') {
						cS = 22;
					} else if (shipStart.charAt(shipStart.length() - 1) == 'W') {
						cS = 23;
					} else if (shipStart.charAt(shipStart.length() - 1) == 'X') {
						cS = 24;
					} else if (shipStart.charAt(shipStart.length() - 1) == 'Y') {
						cS = 25;
					} else if (shipStart.charAt(shipStart.length() - 1) == 'Z') {
						cS = 26;
					}
				}
			}

			for (int j = 0; j < 2; j++) {
				if (j == 0) {
					rE = Integer.parseInt(shipEnd.substring(0, shipEnd.length() - 1));
				} else {
					if (shipEnd.charAt(shipEnd.length() - 1) == 'A') {
						cE = 1;
					} else if (shipEnd.charAt(shipEnd.length() - 1) == 'B') {
						cE = 2;
					} else if (shipEnd.charAt(shipEnd.length() - 1) == 'C') {
						cE = 3;
					} else if (shipEnd.charAt(shipEnd.length() - 1) == 'D') {
						cE = 4;
					} else if (shipEnd.charAt(shipEnd.length() - 1) == 'E') {
						cE = 5;
					} else if (shipEnd.charAt(shipEnd.length() - 1) == 'F') {
						cE = 6;
					} else if (shipEnd.charAt(shipEnd.length() - 1) == 'G') {
						cE = 7;
					} else if (shipEnd.charAt(shipEnd.length() - 1) == 'H') {
						cE = 8;
					} else if (shipEnd.charAt(shipEnd.length() - 1) == 'I') {
						cE = 9;
					} else if (shipEnd.charAt(shipEnd.length() - 1) == 'J') {
						cE = 10;
					} else if (shipEnd.charAt(shipEnd.length() - 1) == 'K') {
						cE = 11;
					} else if (shipEnd.charAt(shipEnd.length() - 1) == 'L') {
						cE = 12;
					} else if (shipEnd.charAt(shipEnd.length() - 1) == 'M') {
						cE = 13;
					} else if (shipEnd.charAt(shipEnd.length() - 1) == 'N') {
						cE = 14;
					} else if (shipEnd.charAt(shipEnd.length() - 1) == 'O') {
						cE = 15;
					} else if (shipEnd.charAt(shipEnd.length() - 1) == 'P') {
						cE = 16;
					} else if (shipEnd.charAt(shipEnd.length() - 1) == 'Q') {
						cE = 17;
					} else if (shipEnd.charAt(shipEnd.length() - 1) == 'R') {
						cE = 18;
					} else if (shipEnd.charAt(shipEnd.length() - 1) == 'S') {
						cE = 19;
					} else if (shipEnd.charAt(shipEnd.length() - 1) == 'T') {
						cE = 20;
					} else if (shipEnd.charAt(shipEnd.length() - 1) == 'U') {
						cE = 21;
					} else if (shipEnd.charAt(shipEnd.length() - 1) == 'V') {
						cE = 22;
					} else if (shipEnd.charAt(shipEnd.length() - 1) == 'W') {
						cE = 23;
					} else if (shipEnd.charAt(shipEnd.length() - 1) == 'X') {
						cE = 24;
					} else if (shipEnd.charAt(shipEnd.length() - 1) == 'Y') {
						cE = 25;
					} else if (shipEnd.charAt(shipEnd.length() - 1) == 'Z') {
						cE = 26;
					}
				}

			}
			for (int j = rS; j <= rE; j++) {
				for (int k = cS; k <= cE; k++) {
					map[j][k] = i;
					shipCnt[i]++;
				}
			}
		}

		String[] t = T.split(" ");
		int rT = 0;
		int cT = 0;
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < 2; j++) {
				if (j == 0) {
					rT = Integer.parseInt(t[i].substring(0, t[i].length() - 1));
				} else {
					if (t[i].charAt(t[i].length() - 1) == 'A') {
						cT = 1;
					} else if (t[i].charAt(t[i].length() - 1) == 'B') {
						cT = 2;
					} else if (t[i].charAt(t[i].length() - 1) == 'C') {
						cT = 3;
					} else if (t[i].charAt(t[i].length() - 1) == 'D') {
						cT = 4;
					} else if (t[i].charAt(t[i].length() - 1) == 'E') {
						cT = 5;
					} else if (t[i].charAt(t[i].length() - 1) == 'F') {
						cT = 6;
					} else if (t[i].charAt(t[i].length() - 1) == 'G') {
						cT = 7;
					} else if (t[i].charAt(t[i].length() - 1) == 'H') {
						cT = 8;
					} else if (t[i].charAt(t[i].length() - 1) == 'I') {
						cT = 9;
					} else if (t[i].charAt(t[i].length() - 1) == 'J') {
						cT = 10;
					} else if (t[i].charAt(t[i].length() - 1) == 'K') {
						cT = 11;
					} else if (t[i].charAt(t[i].length() - 1) == 'L') {
						cT = 12;
					} else if (t[i].charAt(t[i].length() - 1) == 'M') {
						cT = 13;
					} else if (t[i].charAt(t[i].length() - 1) == 'N') {
						cT = 14;
					} else if (t[i].charAt(t[i].length() - 1) == 'O') {
						cT = 15;
					} else if (t[i].charAt(t[i].length() - 1) == 'P') {
						cT = 16;
					} else if (t[i].charAt(t[i].length() - 1) == 'Q') {
						cT = 17;
					} else if (t[i].charAt(t[i].length() - 1) == 'R') {
						cT = 18;
					} else if (t[i].charAt(t[i].length() - 1) == 'S') {
						cT = 19;
					} else if (t[i].charAt(t[i].length() - 1) == 'T') {
						cT = 20;
					} else if (t[i].charAt(t[i].length() - 1) == 'U') {
						cT = 21;
					} else if (t[i].charAt(t[i].length() - 1) == 'V') {
						cT = 22;
					} else if (t[i].charAt(t[i].length() - 1) == 'W') {
						cT = 23;
					} else if (t[i].charAt(t[i].length() - 1) == 'X') {
						cT = 24;
					} else if (t[i].charAt(t[i].length() - 1) == 'Y') {
						cT = 25;
					} else if (t[i].charAt(t[i].length() - 1) == 'Z') {
						cT = 26;
					}
				}
			}
			map[rT][cT] = -1;
		}

		int life = 0;
		int sunkOk = 0;
		int sunkNo = 0;
		for (int i = 1; i <= ships.length; i++) {
			life = 0;
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					if (map[j][k] == i) {
						life++;
					}
				}
			}
			if (life == 0) {
				sunkOk++;
			} else if (life != shipCnt[i]) {
				sunkNo++;
			}
		}

		answer = sunkOk + "," + sunkNo;

		return answer;
	}

	public static void main(String[] args) {
		Solution o = new Solution();
		System.out.println(o.solution(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A"));
		System.out.println(o.solution(3, "1A 1B,2C 2C", "1B"));
		System.out.println(o.solution(12, "1A 2A,12A 12A", "12A"));

	}

}
