package samsung.practice1;


import java.util.Scanner;
 
 
public class p14503_2 {
   
    static int N; //���α���
    static int M; //���α���
    static int r; //x��ǥ
    static int c; //y�·�
    static int d; //����
    static int[][] map; // �Է°�
    static int[] dx = {-1,0,1,0}; //d=0�϶� ���� 1�϶� ���� 2�϶� ���� 3�϶� ����
    static int[] dy = {0,1,0,-1};
   
    static int[] dd = {3,0,1,2}; //���ʿ뵵
    static int left_x; //���� x��
    static int left_y; //���� y��
 
 
 
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        N = sc.nextInt(); //���α��� �Է�
        M = sc.nextInt(); //���α��� �Է�
       
        r = sc.nextInt(); //û�ұ� x��ǥ �Է�
        c = sc.nextInt(); //û�ұ� y�·� �Է�
        d = sc.nextInt(); //���� �Է�
       
        map = new int[N][M];
   
       
        for(int i=0;i<N;i++){  //���ϰ� �� �Է�
            for(int j=0;j<M;j++){
                map[i][j] = sc.nextInt();
            }
        }
        robot(r,c); //robot�޼ҵ� ȣ��
        for(int i=0;i<N;i++){  //���ϰ� �� �Է�
            for(int j=0;j<M;j++){
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    }
    public static void robot(int x, int y){
       
        map[x][y] = 2; //1. ������ġ û��
       
        while(true){
            if(x>=0 && x<N && y>=0 && y<M){ //���α��� ���α��̰� 3���� 50�����̴ϱ�
               
                left_x = x + dx[dd[d]]; //d�� �������� ���� �� ��Ī
                left_y = y + dy[dd[d]];
               
                if(map[left_x][left_y]==0){ //���ʹ��⿡ û������ ���� ������ �����Ѵٸ�
                	print();
                    d = dd[d]; //���ʹ������� ȸ��
                    x = left_x; //�������� 1ĭ�̵��Ѱ����� x,y�� ����
                    y = left_y;
                    map[x][y] = 2; //x,y���� û��
                    continue; //�ٽ� while������ ���ư���.
                }
                else if(map[left_x][left_y] == 2 || map[left_x][left_y] == 1){ //���ʹ��⿡ û���Ұ����� ���ٸ�
                	print();
                	d = dd[d]; //���ʹ������� ȸ��
                    continue; //while������ ���ư���.
                }
                else if(map[x-1][y]!=0 && map[x+1][y]!=0 && map[x][y-1]!=0 && map[x][y+1]!=0) {
                       
                    x = x - dx[d]; //��ĭ�ڷ� �����Ѵ�.
                    y = y - dy[d];
                    if(map[x][y]==1) //���� ���ʹ����� ���̶� ������ �Ҽ����ٸ�
                        break; //while�� ����
                    continue;//while������ ���ư���.
                   
                }
            }
        }
    }
    
    public static void print(){
    	for(int i=0;i<N;i++){  //���ϰ� �� �Է�
            for(int j=0;j<M;j++){
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    	System.out.println();
    }
}