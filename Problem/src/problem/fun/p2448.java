package problem.fun;

import java.util.Arrays;
import java.util.Scanner;

public class p2448 {
	static char starArr[][] = null;
	
	public static void printStar(int n, int x, int y){
		if(n == 3){
			starArr[x][y] = '*';
			starArr[x+1][y-1] = '*';
			starArr[x+1][y+1] = '*';
			starArr[x+2][y] = '*';
			starArr[x+2][y-1] = '*';
			starArr[x+2][y+1] = '*';
			starArr[x+2][y-2] = '*';
			starArr[x+2][y+2] = '*';
			return;
		}
		int tmp = n/2;
		printStar(tmp, x, y);
		printStar(tmp, x+tmp, y-tmp);
		printStar(tmp, x+tmp, y+tmp);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		try {
			int n = in.nextInt();
			starArr= new char[n][n*2];
			for(int i = 0 ; i<n ; i++){
				Arrays.fill(starArr[i], ' ');
			}
			printStar(n, 0, n-1);
			
			for (int i = 0; i < n; i++) {
	            sb.append(starArr[i]).append("\n");
	        }
	        System.out.println(sb.toString());
		} finally {
			in.close();
			in = null;
		}
	}
}
//문제
//예제를 보고 별찍는 규칙을 유추한 뒤에 별을 찍어 보세요.
//입력
//첫째 줄에 N이 주어진다. N은 항상 3*2^k 수이다. (3, 6, 12, 24, 48, ...) (k<=10)
//출력
//첫째 줄부터 N번째 줄까지 별을 출력한다.
//예제 입력  복사
//24
//예제 출력  복사
//                       *                        
//                      * *                       
//                     *****                      
//                    *     *                     
//                   * *   * *                    
//                  ***** *****                   
//                 *           *                  
//                * *         * *                 
//               *****       *****                
//              *     *     *     *               
//             * *   * *   * *   * *              
//            ***** ***** ***** *****             
//           *                       *            
//          * *                     * *           
//         *****                   *****          
//        *     *                 *     *         
//       * *   * *               * *   * *        
//      ***** *****             ***** *****       
//     *           *           *           *      
//    * *         * *         * *         * *     
//   *****       *****       *****       *****    
//  *     *     *     *     *     *     *     *   
// * *   * *   * *   * *   * *   * *   * *   * *  
//***** ***** ***** ***** ***** ***** ***** *****
//  *                           
// * *                         
//***** 
//     *                        
//    * *                       
//   *****                      
//  *     *                     
// * *   * *                    
//***** ***** 

//           *                        
//          * *                       
//         *****                      
//        *     *                     
//       * *   * *                    
//      ***** *****                   
//     *           *                  
//    * *         * *                 
//   *****       *****                
//  *     *     *     *               
// * *   * *   * *   * *              
//***** ***** ***** *****