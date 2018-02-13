package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SE1221 {

	static int testCaseCnt;//testcase 개수
	static String num;
	static int len;
	static ArrayList<Integer> nums = new ArrayList<Integer>(); 
	static String line;
	static int answer;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		testCaseCnt = in.nextInt();//testcase 개수 입력

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {
			
			in.nextLine();
			num = in.nextLine();

			len = Integer.parseInt(num.substring(((testCase + " ").length() + 1), num.length()));
			
			line = in.nextLine();
			
			System.out.println(line);
			
			for(int i = 0; i < len; i++){
				num = "" + line.charAt(i) + "" + line.charAt(i + 1) + "" + line.charAt(i + 2);
				if(num.equals("ZRO")){
					nums.add(0);
				}else if(num.equals("ONE")){
					nums.add(1);
				}else if(num.equals("TWO")){
					nums.add(2);
				}else if(num.equals("THR")){
					nums.add(3);
				}else if(num.equals("FOR")){
					nums.add(4);
				}else if(num.equals("FIV")){
					nums.add(5);
				}else if(num.equals("SIX")){
					nums.add(6);
				}else if(num.equals("SVN")){
					nums.add(7);
				}else if(num.equals("EGT")){
					nums.add(8);
				}else if(num.equals("NIN")){
					nums.add(9);
				}
				i++;
			}
			
			Collections.sort(nums);
			
			
			System.out.print("#" + testCase);
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
		}
	}
}