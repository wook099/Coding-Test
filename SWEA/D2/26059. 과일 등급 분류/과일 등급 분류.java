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
import java.io.InputStreamReader;
import java.util.Arrays;
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


        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int t=1;t<=T;t++){

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int lo = Integer.parseInt(st.nextToken());
            int hi = Integer.parseInt(st.nextToken());


            int[] arr= new int[N];
            st=new StringTokenizer(br.readLine());
            for (int i=0;i<N;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
                             //3 1 4 5 5
            Arrays.sort(arr);//1 3 4 5 5


            int diff=Integer.MAX_VALUE;
            boolean flag=false;


            for (int i=1;i<N-1;i++){
                for (int j=i+1;j<N;j++){

                    if (arr[i-1]==arr[i]||arr[j-1]==arr[j])
                        continue;

                    int l=i;
                    int m=j-i;
                    int h=N-j;

                    if (lo > l && lo > m && lo > h && hi < l && hi < m && hi < h)
                        continue;

                    int max= Math.max(l,Math.max(m,h));
                    int min = Math.min(l,Math.min(m,h));

                    diff=Math.min(diff,max-min);
                    flag=true;

                }
            }

            if (flag)
                System.out.println("#"+t+" "+diff);
            else
                System.out.println("#"+t+" "+"-1");
        }


        /*
        * N개의 과일 무게에 따라 상 중 하
        * 하< k1< 중< k2 < 상
        *
        * 모든 등급 과일 각각 a<x<b
        *
        * 가장 많은 과일이 속한 등급, 적은 과일 속한 등급의 차이 최소값 구하기
        * 조건 만족x -> -1
        *
        *lo high 범위를 한구간이라도 벗어난다면 -1
        *
        * */


    }

}
