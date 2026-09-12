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

        for (int t=1; t<=T; t++) {

            int max=0;

            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0;i<N;i++){

                arr[i]=Integer.parseInt(st.nextToken());
                max=Math.max(max,arr[i]);
            }
            int one=0;
            int two=0;
            for (int i=0;i<N;i++){
                one+=(max-arr[i])%2;
                two+=(max-arr[i])/2;
            }

            while (one+1<two){//two 가 더 많은건 절대안됨 1로 나누면 더 효율적 분배가 가능해짐
                two--;
                one+=2;
            }
//            int p=0;
//            if (one>two+1){//쉬는날도 계산이 필요함 1 1 1 -> 5일 필요
//
//                p=(one-two-1);
//            }

        int result =0;
            if (one>two) {
                result=one*2-1;
            }else
                result=two*2;



            System.out.println("#"+t+" "+result);



            /*
            * 첫째날 1 둘째날 2
            * 가장높은 나무의 크기가 되기까지 몇일이 걸리는지
            * 최소날짜 구하기
            *
            * 각 나무마다 필요한 개수를 찾아서 one, two 중에 뭘 줘야하는지 구해야함
            * 1만 필요한 경우를 분류하기 위함임. 1 2개면 3일 필요 ,3개면 5일필요
            * */

        }
    }
}