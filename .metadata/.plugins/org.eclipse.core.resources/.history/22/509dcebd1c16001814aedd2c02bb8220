package study;

import java.util.ArrayList;
import java.util.Scanner;
 
public class SE1952_Today {
 
	static int testCaseCnt;
    static int[] costs;//이용권 가격
    static ArrayList<Integer> month;//월별 이용횟수
    static int answer;
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        testCaseCnt = in.nextInt();
        
        for (int testCase = 1; testCase <= testCaseCnt; testCase++) {
            costs = new int[4];
            for (int j = 0; j < 4; j++) {//이용권 가격 입력
                costs[j] = in.nextInt();
            }
            
            month = new ArrayList<>();
            for (int j = 0; j < 12; j++) {//월별 이용횟수 입력
                month.add(in.nextInt());
            }
            
            while (month.get(0) == 0) {//앞 이용 안하는 달 제거
                month.remove(0);
            }
            
            while (month.get(month.size() - 1) == 0) {//뒤 이용 안하는 달 제거
                month.remove(month.size() - 1);
            }
            
            answer = costs[3];//1년짜리 이용권이 제일 비쌈
            execute(0, 0);//이용하는 달 인덱스, 누적 합
            System.out.println("#" + testCase + " " + answer);
        }
    }
  
    public static void execute(int day, int totalCost) {
        if(day >= month.size()){//최대 이용하는 달 이상
            answer = Math.min(answer, totalCost);//min값 갱신
            return;
        }
        execute(day + 1, totalCost + month.get(day) * costs[0]);//일별 계산
        execute(day + 1, totalCost + costs[1]);//1달 계산
        execute(day + 3, totalCost + costs[2]);//3달 계산
    }
}