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
//����
//������ ���� ����� ��Ģ�� ������ �ڿ� ���� ��� ������.
//�Է�
//ù° �ٿ� N�� �־�����. N�� �׻� 3*2^k ���̴�. (3, 6, 12, 24, 48, ...) (k<=10)
//���
//ù° �ٺ��� N��° �ٱ��� ���� ����Ѵ�.
//���� �Է�  ����
//24
//���� ���  ����
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