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
        int T=Integer.parseInt(br.readLine());

        for (int t=1;t<=T;t++){

            StringTokenizer st =new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());//인원
            int K=Integer.parseInt(st.nextToken());//학생번호
            int[] mterm=new int[N+1];
            int[] fterm=new int[N+1];
            int[] hw=new int[N+1];
            double[] total=new double[N+1];

            String[] grade={" ","A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};

            for (int i=1;i<=N;i++){
                st=new StringTokenizer(br.readLine());

                mterm[i]=Integer.parseInt(st.nextToken());
                fterm[i]=Integer.parseInt(st.nextToken());
                hw[i]=Integer.parseInt(st.nextToken());
            }
            for (int i=1;i<=N;i++){
                total[i]=mterm[i]*(0.35)+fterm[i]*(0.45)+hw[i]*(0.2);
            }

            double score=total[K];
            int cnt=1;

            for (int i=1;i<=N;i++){// 1 ~30  123 /3 = 1
                if(score<total[i])
                    cnt++;
            }
            
           int A=0;

            if(N>10) {
                A = (cnt - 1) / (N / 10);
                A++;
            }
            else 
                A=cnt;
            


            System.out.println("#"+t+" "+grade[A]);


        }
	}
}