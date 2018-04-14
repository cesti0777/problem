package kj_ss;

import java.util.Scanner;

public class p14890 {
	static int n;
	static int l;
	static int[][] map = new int[101][101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		l = sc.nextInt();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		runHang();
	}
	public static void runHang() {
		int dr = 0; // 1이면 높아지는 방향, -1이면 낮아지는 방향
		int current = 1; // 현재 몇개째 블록인지 count
		
		for(int i=1; i<n; i++) {
			if(map[0][i] - map[0][i-1] == 1) { // 높아지는 방향이면
				dr = 1;
			} else if (map[0][i-1] - map[0][i] == 1) { // 낮아지는 방향이면
				dr = -1;
			} else if(map[0][i-1] == map[0][i]) { // 같은 높이면
				current++;
			} else { // 높이 차이가 1 이상이면 아예 리턴시키자
				return;
			}
		}
	}
}
