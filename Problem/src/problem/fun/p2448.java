package problem.fun;

import java.util.Scanner;

public class p2448 {
	
	public static void printStar(int n){
		printStar(n);
		for(int i = 0; i<n-1 ; i++){
			System.out.print(" ");
		}
		n = n/2;
		System.out.println("*");
		for(int i = 0; i<n-2 ; i++){
			System.out.print(" ");
		}
		System.out.print("*");
		System.out.print(" ");
		System.out.println("*");
		for(int i = 0; i<n-3 ; i++){
			System.out.print(" ");
		}
		System.out.println("*****");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		try {
			int n = in.nextInt();
			printStar(n);
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

//     *                        
//    * *                       
//   *****                      
//  *     *                     
// * *   * *                    
//***** ***** 