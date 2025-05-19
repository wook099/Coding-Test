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

        int T =Integer.parseInt(br.readLine());

        for (int t=1;t<=T;t++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N= Integer.parseInt(st.nextToken());
            int M= Integer.parseInt(st.nextToken());

            int[] p1=new int[N];
            int[] p2=new int[M];

            st= new StringTokenizer(br.readLine());
            for (int i=0;i<N;i++){
                p1[i]=Integer.parseInt(st.nextToken());//N
            }
            st= new StringTokenizer(br.readLine());
            for (int i=0;i<M;i++){
                p2[i]=Integer.parseInt(st.nextToken());//M
            }
            int sum=0;
            int result=0;
//            1 5 3
//            3 6 -7 5 4
            if (N>M){// P1[5] P2[3]

                for (int i=0;i<N-M+1;i++){ // 0~2
                    for (int j=i;j<i+M;j++){ //012 123 234
//                        if(i+M==N)
//                            break;
                        sum+=p1[j]*p2[j-i];
                    }
                    result=Math.max(sum,result);
                    sum=0;
                }
            }
            else if(N<M){// N-p1[3], M-p2[5]

                for (int i=0;i<M-N+1;i++){ // 0~2 3번
                    for (int j=i;j<i+N;j++){ //012 123 234
                        sum+=p2[j]*p1[j-i];// 0 0 1 1 2 2/ 1 0 2 1 3 2/ 2 0 3 1 4 2
                    }
                    result=Math.max(sum,result);
                    sum=0;
                }
            }
            else {
                for (int i = 0; i < N; i++) {
                    sum += p1[i] * p2[i];
                }
                result = sum;
            }
            System.out.println("#"+t+" "+result);
        }
	}
}