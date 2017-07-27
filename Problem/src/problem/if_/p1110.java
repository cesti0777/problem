package problem.if_;

import java.util.Scanner;

import javax.print.attribute.standard.MediaSize.NA;

public class p1110 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			int n = in.nextInt();
			int nn = n;
			int cnt = 0;
			int[] nArray = new int[2];
			int meddleResult = 0;
			int[] newArray = new int[2];
			while(true){
				if(nn < 10){
					nArray[0] = 0;
					nArray[1] = nn;
				}else{
					nArray[0] = nn/10;
					nArray[1] = nn%10;
				}
				meddleResult = nArray[0] + nArray[1];
				
				if(meddleResult < 10){
					newArray[0] = 0;
					newArray[1] = meddleResult;
				}else{
					newArray[0] = meddleResult/10;
					newArray[1] = meddleResult%10;
				}
				nArray[0] = nArray[1]; 
				nArray[1] =	newArray[1];
				cnt++;
				nn = nArray[0] * 10 + nArray[1];
				if(nArray[0] * 10 + nArray[1] == n){
					break;
				}
			}
			System.out.println(cnt);
		}finally {
			in.close();
			in = null;
		}
	}
}