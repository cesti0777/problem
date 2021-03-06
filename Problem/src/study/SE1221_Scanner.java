package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SE1221_Scanner {

	static int testCaseCnt;//testcase 개수
	static ArrayList<Integer> nums = new ArrayList<Integer>(); 
	static String num;
	static int len;
	static String word;
	
	static String[] line2;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		testCaseCnt = in.nextInt();//testcase 개수 입력

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {
			
			num = in.next();
			len = in.nextInt();
			
			for(int i = 0; i < len; i++){
				word = in.next();
				
				if(word.equals("ZRO")){
					nums.add(0);
				}else if(word.equals("ONE")){
					nums.add(1);
				}else if(word.equals("TWO")){
					nums.add(2);
				}else if(word.equals("THR")){
					nums.add(3);
				}else if(word.equals("FOR")){
					nums.add(4);
				}else if(word.equals("FIV")){
					nums.add(5);
				}else if(word.equals("SIX")){
					nums.add(6);
				}else if(word.equals("SVN")){
					nums.add(7);
				}else if(word.equals("EGT")){
					nums.add(8);
				}else if(word.equals("NIN")){
					nums.add(9);
				}
			}
			
			Collections.sort(nums);
			
			System.out.print(num + " ");
			for(int i = 0; i < nums.size(); i++){
				if(nums.get(i) == 0){
					System.out.print("ZRO" + " ");
				}else if(nums.get(i) == 1){
					System.out.print("ONE" + " ");
				}else if(nums.get(i) == 2){
					System.out.print("TWO" + " ");
				}else if(nums.get(i) == 3){
					System.out.print("THR" + " ");
				}else if(nums.get(i) == 4){
					System.out.print("FOR" + " ");
				}else if(nums.get(i) == 5){
					System.out.print("FIV" + " ");
				}else if(nums.get(i) == 6){
					System.out.print("SIX" + " ");
				}else if(nums.get(i) == 7){
					System.out.print("SVN" + " ");
				}else if(nums.get(i) == 8){
					System.out.print("EGT" + " ");
				}else if(nums.get(i) == 9){
					System.out.print("NIN" + " ");
				}
			}
			System.out.println();
			
			nums.clear();
		}
	}
}