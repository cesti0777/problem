package samsung.practice1;


import java.util.Scanner;
 
 
public class p14503_2 {
   
    static int N; //세로길이
    static int M; //가로길이
    static int r; //x좌표
    static int c; //y좌료
    static int d; //방향
    static int[][] map; // 입력값
    static int[] dx = {-1,0,1,0}; //d=0일때 북쪽 1일때 동쪽 2일때 남쪽 3일때 서쪽
    static int[] dy = {0,1,0,-1};
   
    static int[] dd = {3,0,1,2}; //왼쪽용도
    static int left_x; //왼쪽 x값
    static int left_y; //왼쪽 y값
 
 
 
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        N = sc.nextInt(); //세로길이 입력
        M = sc.nextInt(); //가로길이 입력
       
        r = sc.nextInt(); //청소기 x좌표 입력
        c = sc.nextInt(); //청소기 y좌료 입력
        d = sc.nextInt(); //방향 입력
       
        map = new int[N][M];
   
       
        for(int i=0;i<N;i++){  //벽하고 방 입력
            for(int j=0;j<M;j++){
                map[i][j] = sc.nextInt();
            }
        }
        robot(r,c); //robot메소드 호출
        for(int i=0;i<N;i++){  //벽하고 방 입력
            for(int j=0;j<M;j++){
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    }
    public static void robot(int x, int y){
       
        map[x][y] = 2; //1. 현재위치 청소
       
        while(true){
            if(x>=0 && x<N && y>=0 && y<M){ //가로길이 세로길이가 3부터 50이하이니깐
               
                left_x = x + dx[dd[d]]; //d의 값에따라 왼쪽 값 매칭
                left_y = y + dy[dd[d]];
               
                if(map[left_x][left_y]==0){ //왼쪽방향에 청소하지 않은 공간이 존재한다면
                	print();
                    d = dd[d]; //왼쪽방향으로 회전
                    x = left_x; //왼쪽으로 1칸이동한값으로 x,y값 변경
                    y = left_y;
                    map[x][y] = 2; //x,y에서 청소
                    continue; //다시 while문으로 돌아간다.
                }
                else if(map[left_x][left_y] == 2 || map[left_x][left_y] == 1){ //왼쪽방향에 청소할공간이 없다면
                	print();
                	d = dd[d]; //왼쪽방향으로 회전
                    continue; //while문으로 돌아간다.
                }
                else if(map[x-1][y]!=0 && map[x+1][y]!=0 && map[x][y-1]!=0 && map[x][y+1]!=0) {
                       
                    x = x - dx[d]; //한칸뒤로 후진한다.
                    y = y - dy[d];
                    if(map[x][y]==1) //만약 뒤쪽방향이 벽이라서 후진도 할수없다면
                        break; //while문 종료
                    continue;//while문으로 돌아간다.
                   
                }
            }
        }
    }
    
    public static void print(){
    	for(int i=0;i<N;i++){  //벽하고 방 입력
            for(int j=0;j<M;j++){
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    	System.out.println();
    }
}