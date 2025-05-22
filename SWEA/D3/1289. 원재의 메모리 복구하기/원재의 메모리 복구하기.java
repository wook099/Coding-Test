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

            boolean fact=true;

            String S =br.readLine();
            char[] arr=new char[S.length()];
            for (int i=0;i<S.length();i++){
                arr[i]=S.charAt(i);
            }
            int cnt=0;

//            for (int i=0;i<S.length();i++){
//                if(arr[i]=='1') {
//                    for (int j = i; j < S.length(); j++) {
//                        if (arr[j] == '1')
//                            arr[j] = '0';
//                        else
//                            arr[j] = '1';
//                    }
//                    cnt++;
//
//                }
//
//                for (int a=0;a<S.length();a++) {
//                    if (arr[a] == '0')
//                        fact = true;
//                    else {
//                        fact = false;
//                        break;
//                    }
//                }
//
//                if(fact)
//                    break;
//
//            }더 쉽게 푸는방법 0000이고 0010을 받아 그럼 달라질때만 바꾸고 값을 이전시키면됨
            char pre='0';
            for (int i=0;i<S.length();i++){
                if(S.charAt(i)!=pre){
                    cnt++;
                    pre=S.charAt(i);
                }

            }


            System.out.println("#" + t + " "+cnt );
        }
	}
}