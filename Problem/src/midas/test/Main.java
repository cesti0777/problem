package midas.test;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static int n = 0;
	static int m = 0;
	static char[][] pair = new char[101][3];
	static LinkedList<Character> alpa = new LinkedList<Character>();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		m = in.nextInt();
		in.nextLine();
		
		//������ �Է�
		for(int i = 1; i <= m; i++){
			String line = in.nextLine();
			pair[i][1] = line.charAt(0);
			pair[i][2] = line.charAt(2);
		}
		
		//n�� ���ĺ� �Է�
		for(int i = 0; i < n; i++){
			alpa.add((char)(65+i));
		}
		
		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= m; j++){
				if(alpa.indexOf(pair[j][1]) < alpa.indexOf(pair[j][2])){
					continue;
				}else{
					alpa.remove(alpa.indexOf(pair[j][2]));
					int cnt = 1;
					while(alpa.indexOf(pair[j][1])+cnt < n-1 && alpa.get(alpa.indexOf(pair[j][1])+cnt) < pair[j][2]){
						cnt++;
					}
					alpa.add(alpa.indexOf(pair[j][1])+cnt, (char)pair[j][2]);
				}
			}
		}
		for(int i = 0; i < n; i++){
			System.out.print(alpa.get(i));
		}
	}
}
