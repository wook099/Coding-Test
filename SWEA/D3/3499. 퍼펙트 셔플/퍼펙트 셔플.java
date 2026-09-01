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
	      public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int t=1;t<=T;t++){

            int N = Integer.parseInt(br.readLine());

            String[] arr = new String[N];

            st=new StringTokenizer(br.readLine());

            for (int i=0;i<N;i++){
                arr[i]=st.nextToken();
            }

            StringBuilder sb = new StringBuilder();
            String[] A = new String[(N+1)/2];
            String[] B = new String[(N+1)/2];
            for (int i=0;i<(N+1)/2;i++){
                A[i]=arr[i];
            }
            int a=0;
            for (int i=((N+1)/2);i<N;i++){

                B[a]=arr[i];
                a++;
            }

            for (int i=0;i<A.length;i++){
                sb.append(A[i]+" ");
                if (B[i]==null)
                    break;


                sb.append(B[i]+" ");

            }

            System.out.println("#"+t+" "+sb);


//            String[] arr = new String[N];
//            st = new StringTokenizer(br.readLine());
//
//            for (int i=0;i<N;i++){
//                arr[i]=st.nextToken();
//            }
//            int a = 0;
//            int b = (N+1)/2;
//
//            StringBuilder sb = new StringBuilder();
//            for (int i=0;i<N/2;i++){
//                sb.append(arr[a++]);
//                sb.append(" ").append(arr[b++]).append(" ");
//            }
//
//            if (N%2!=0)
//                sb.append(arr[a]);
//
//            System.out.println("#"+t+" "+sb);
        }
    }
}
