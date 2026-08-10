/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];
            for (int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for (int j=0;j<N;j++){
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            int[] dx = {1,-1,0,0};
            int[] dy = {0,0,1,-1};

            //출발은 어디서나 가능함
            //상하 좌우 중 가장 낮은 영여긍로 이동
            // 더 낮은 영역이 없다면 이동 x
            // 가장 긴 등산로

            int result=0;
            int cnt=0;

            for (int i=0;i<N;i++){
                for(int j=0;j<N;j++){

                    int x=i;
                    int y=j;

                    cnt=1;
                    while(true){
                        int mx=-1;
                        int my=-1;
                        int temp=arr[x][y];

                        for (int a=0;a<4;a++){

                            int nx=x+dx[a];
                            int ny=y+dy[a];

                            if(nx<0||ny<0||nx>=N||ny>=N){
                                continue;
                            }

                            if (temp>arr[nx][ny]){
                                temp=arr[nx][ny];
                                mx=nx;
                                my=ny;
                            }
                        }

                        if(mx==-1)
                            break;
                        x=mx;
                        y=my;

                        cnt++;

                    }
                    result=Math.max(result,cnt);

                }
            }
            System.out.println("#" + t + " "+result);

        }
    }
}
