package samsung.practice1;

import java.util.Scanner;

public class P14499 {
	static int n;
	static int m;
	static int r;
	static int c;
	static int k;
	static int map[][] = new int[20][20];
	static int order[] = new int[1000];
	static int diceT, diceB, diceU, diceD, diceL, diceR;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		m = in.nextInt();
		r = in.nextInt();
		c = in.nextInt();
		k = in.nextInt();
		
		//¸Ê ÀúÀå
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				map[i][j] = in.nextInt();
			}
		}
		
		//order ÀúÀå
		for(int i = 0; i < k; i++){
			order[i] = in.nextInt();
		}
		
		int top = 1;
		int bottom = 6;
		int tmpT = diceT;
		int tmpB = diceB;
		int tmpU = diceU;
		int tmpD = diceD;
		int tmpL = diceL;
		int tmpR = diceR;
		for(int i = 0; i < k; i++){
			/*¿ì
			 * 		T -> R
			 * 		B -> L
			 * 		U -> U
			 * 		D -> D
			 * 		L -> T
			 * 		R -> B
			 */
			if(order[i] == 1){//¿ì(µ¿)
				if(c + 1 < m){
					c++;
					tmpT = diceT;
					tmpB = diceB;
					tmpU = diceU;
					tmpD = diceD;
					tmpL = diceL;
					tmpR = diceR;
					diceR = tmpT;
					diceL = tmpB;
					diceU = tmpU;
					diceD = tmpD;
					diceT = tmpL;
					diceB = tmpR;
					if(map[r][c] == 0){
						map[r][c] = diceB;
					}else{
						diceB = map[r][c];
						map[r][c] = 0;
					}
//					System.out.println("T : " + diceT + "\n" +
//							   "B : " + diceB + "\n" +
//							   "U : " + diceU + "\n" +
//							   "D : " + diceD + "\n" +
//							   "L : " + diceL + "\n" +
//							   "R : " + diceR);
					System.out.println(diceT);
				}
				
			}
			/*ÁÂ
			 * 		T -> L
			 * 		B -> R
			 * 		U -> U
			 * 		D -> D
			 * 		L -> B
			 * 		R -> T
			 */
			else if(order[i] == 2){//ÁÂ(¼­)
				if(c - 1 >= 0){
					c--;
					tmpT = diceT;
					tmpB = diceB;
					tmpU = diceU;
					tmpD = diceD;
					tmpL = diceL;
					tmpR = diceR;
					diceL = tmpT;
					diceR = tmpB;
					diceU = tmpU;
					diceD = tmpD;
					diceB = tmpL;
					diceT = tmpR;
					if(map[r][c] == 0){
						map[r][c] = diceB;
					}else{
						diceB = map[r][c];
						map[r][c] = 0;
					}
//					System.out.println("T : " + diceT + "\n" +
//							   "B : " + diceB + "\n" +
//							   "U : " + diceU + "\n" +
//							   "D : " + diceD + "\n" +
//							   "L : " + diceL + "\n" +
//							   "R : " + diceR);
					System.out.println(diceT);
				}
			}
			/*»ó
			 * 		T -> U
			 * 		B -> D
			 * 		U -> B
			 * 		D -> T
			 * 		L -> L
			 * 		R -> R
			 */
			else if(order[i] == 3){//»ó(ºÏ)
				if(r - 1 >= 0){
					r--;
					tmpT = diceT;
					tmpB = diceB;
					tmpU = diceU;
					tmpD = diceD;
					tmpL = diceL;
					tmpR = diceR;
					diceU = tmpT;
					diceD = tmpB;
					diceB = tmpU;
					diceT = tmpD;
					diceL = tmpL;
					diceR = tmpR;
					if(map[r][c] == 0){
						map[r][c] = diceB;
					}else{
						diceB = map[r][c];
						map[r][c] = 0;
					}
//					System.out.println("T : " + diceT + "\n" +
//							   "B : " + diceB + "\n" +
//							   "U : " + diceU + "\n" +
//							   "D : " + diceD + "\n" +
//							   "L : " + diceL + "\n" +
//							   "R : " + diceR );
					System.out.println(diceT);
				}
			}
			/*ÇÏ
			 * 		T -> D
			 * 		B -> U
			 * 		U -> T
			 * 		D -> B
			 * 		L -> L
			 * 		R -> R
			 */
			else if(order[i] == 4){//ÇÏ(³²)
				if(r + 1 < n){
					r++;
					tmpT = diceT;
					tmpB = diceB;
					tmpU = diceU;
					tmpD = diceD;
					tmpL = diceL;
					tmpR = diceR;
					diceD = tmpT;
					diceU = tmpB;
					diceT = tmpU;
					diceB = tmpD;
					diceL = tmpL;
					diceR = tmpR;
					if(map[r][c] == 0){
						map[r][c] = diceB;
					}else{
						diceB = map[r][c];
						map[r][c] = 0;
					}
//					System.out.println("T : " + diceT + "\n" +
//									   "B : " + diceB + "\n" +
//									   "U : " + diceU + "\n" +
//									   "D : " + diceD + "\n" +
//									   "L : " + diceL + "\n" +
//									   "R : " + diceR);
					System.out.println(diceT);
				}
			}
		}
		
		
		
//		System.out.println();
//		for(int i = 0; i < n; i++){
//			for(int j = 0; j < m; j++){
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
//		for(int i = 0; i < k; i++){
//			System.out.print(order[i] + " ");
//		}
		
	}
}
