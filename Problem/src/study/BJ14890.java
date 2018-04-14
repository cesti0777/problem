package study;

import java.util.Scanner;

public class BJ14890 {

	static int n;
	static int l;
	static int[][] map;
	static boolean[] visited;
	static int answer;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		l = in.nextInt();

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = in.nextInt();
			}
		}

		execute();
		
		System.out.println(answer);
	}

	public static void execute() {
		
		boolean fail = false;

		for (int i = 0; i < n; i++) {
			// ���ΰ˻�
			visited = new boolean[n];
			for (int j = 0; j < n; j++) {
				if (j + 1 < n) {
					if (map[i][j] - 1 == map[i][j + 1]) {//�������ʿ�
						for(int a = 1; a <= l; a++){//������ lĭ �˻�
							if(j + a >= n || visited[j + a] || map[i][j + a] != map[i][j] - 1){
								//�ʹ�üũ, ����üũ, ����üũ
								fail = true;
								break;
							}
							visited[j + a] = true;//���� üũ
						}
						j += l - 1;//���� ���� ��ŭ ����
					}else if(map[i][j] + 1 == map[i][j + 1]){//�������ʿ�
						for(int a = 0; a < l; a++){//�ڷ� lĭ �˻�
							if(j - a < 0 || visited[j - a] || map[i][j - a] != map[i][j]){
								fail = true;
								break;
							}
							visited[j - a] = true;//���� üũ
						}
					}else if(map[i][j] != map[i][j + 1]){
						fail = true;
						break;
					}
					
					if(fail == true){
						break;
					}
				}
			}
			if(fail == false){
				answer++;
			}else{
				fail = false;
			}
			
			// ���ΰ˻�
			visited = new boolean[n];
			for (int j = 0; j < n; j++) {
				if (j + 1 < n) {
					if (map[j][i] - 1 == map[j + 1][i]) {//�������ʿ�
						for(int a = 1; a <= l; a++){//lĭ �˻�
							if(j + a >= n || visited[j + a] || map[j + a][i] != map[j][i] - 1){
								fail = true;
								break;
							}
							visited[j + a] = true;
						}
						j += l - 1;
					}else if(map[j][i] + 1 == map[j + 1][i]){//�������ʿ�
						for(int a = 0; a < l; a++){//lĭ �˻�
							if(j - a < 0 || visited[j - a] || map[j - a][i] != map[j][i]){
								fail = true;
								break;
							}
							visited[j - a] = true;
						}
					}else if(map[j][i] != map[j + 1][i]){
						fail = true;
						break;
					}
					
					if(fail == true){
						break;
					}
				}
			}
			
			if(fail == false){
				answer++;
			}else{
				fail = false;
			}
		}

	}

}