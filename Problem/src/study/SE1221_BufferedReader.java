package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SE1221_BufferedReader {

	static int testCaseCnt;//testcase 개수
	static ArrayList<Integer> nums = new ArrayList<Integer>(); 
	static String[] line1;
	static String[] line2;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		testCaseCnt = Integer.parseInt(in.readLine());//testcase 개수 입력

		for (int testCase = 1; testCase <= testCaseCnt; testCase++) {
			
			line1 = in.readLine().split(" ");
			line2 = in.readLine().split(" ");
			
			for(int i = 0; i < line2.length; i++){
				
				if(line2[i].equals("ZRO")){
					nums.add(0);
				}else if(line2[i].equals("ONE")){
					nums.add(1);
				}else if(line2[i].equals("TWO")){
					nums.add(2);
				}else if(line2[i].equals("THR")){
					nums.add(3);
				}else if(line2[i].equals("FOR")){
					nums.add(4);
				}else if(line2[i].equals("FIV")){
					nums.add(5);
				}else if(line2[i].equals("SIX")){
					nums.add(6);
				}else if(line2[i].equals("SVN")){
					nums.add(7);
				}else if(line2[i].equals("EGT")){
					nums.add(8);
				}else if(line2[i].equals("NIN")){
					nums.add(9);
				}
			}
			
			Collections.sort(nums);
			
			System.out.println(line1[0]);
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