package samsung.practice1;

import java.util.Scanner;

public class P9328 {
	static int tCnt;
	static int[][] r = new int[100][1];
	static int[][] c = new int[100][1];
	static char[][][] map = new char[100][104][104]; 
	static String[][] key = new String[100][1];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		tCnt = in.nextInt();
		//�� ����
		for(int m = 0; m < tCnt; m++){
			r[m][0] = in.nextInt();
			c[m][0] = in.nextInt();
			//�ܺ� �����
			for(int i = 0; i < r[m][0] + 4; i++){
				for(int j = 0; j < c[m][0] + 4; j++){
					if(i == 0 || i == r[m][0] + 3 || j == 0 || j == c[m][0] + 3){
						map[m][i][j] = '*';
					}
					if(i == 1 && j != 0 && j != c[m][0] + 3 ||
					   i == r[m][0] + 2 && j != 0 && j != c[m][0] + 3  || 
					   j == 1 && i != 0 && i != r[m][0] + 3 || 
					   j == c[m][0] + 2 && i != 0 && i != r[m][0] + 3 ){
						map[m][i][j] = '.';
					}
				}
			}
			
			//�� �Է�
			in.nextLine();
			for(int i = 2; i < r[m][0] + 2; i++){
				String line = in.nextLine();
				for(int j = 2; j < c[m][0] + 2; j++){
					map[m][i][j] = line.charAt(j - 2);
				}
			}
			key[m][0] = in.nextLine();
		}
		
		
		
		//print();
		
		
		
	}

	
	public static void print(){
		for(int m = 0; m < tCnt; m++){
			for(int i = 0; i < r[m][0] + 4; i++){
				for(int j = 0; j < c[m][0] + 4; j++){
					System.out.print(map[m][i][j]);
				}
				System.out.println();
			}
			for(int i = 0; i < key[m][0].length(); i++){
				System.out.print(key[m][0].charAt(i));
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
