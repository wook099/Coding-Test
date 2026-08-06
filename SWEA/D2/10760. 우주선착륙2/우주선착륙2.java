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
import java.util.*;
import java.io.*;
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		        //TIP 캐럿을 강조 표시된 텍스트에 놓고 <shortcut actionId="ShowIntentionActions"/>을(를) 누르면
        // IntelliJ IDEA이(가) 수정을 제안하는 것을 확인할 수 있습니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] arr= new int[N][M];

            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++){
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }
                /*
                * 8개 구역중 착륙지점보다 낮은 구역에서 사진 찎기
                * 8개 방향 중 4방향 이상 가능한 지역 -> 예비 후보지
                * 이중 포문 돌면서 -> 8방탐색 중 4방향이상 존재시 cnt++;
                * */
            }
            int[] dx = {0,0,1,-1,1,-1,1,-1};
            int[] dy = {1,-1,0,0,1,-1,-1,1};

            int x=0;
            int y=0;
            int result=0;
            for(int i=0;i<N;i++){
                for( int j=0;j<M;j++){

//                    int dir=0;
                    x=i;
                    y=j;
                    int cnt=0;

                    for(int a=0;a<8;a++){

                        int nx=x+dx[a];
                        int ny=y+dy[a];

                        if(nx<0||ny<0||nx>=N||ny>=M)
                            continue;

                        if(arr[x][y]>arr[nx][ny])
                            cnt++;

                        if(cnt>=4) {
                            result++;
                            break;
                        }
                    }

                }
            }
            System.out.println("#"+t+" "+result);
        }
    }
}