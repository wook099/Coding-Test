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
class Solution{
public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            int T = Integer.parseInt(br.readLine());

            int cnt=0;
            int result=0;
            boolean fact;

            String A= br.readLine();//ti 비교할문자열
            String S = br.readLine();

            char[] b=new char[A.length()];
            char[] c= new char[S.length()];//전체 문자열

            for (int i=0;i<A.length();i++){
                b[i]=A.charAt(i);
            }

            for (int i = 0; i < S.length(); i++) {//5 -3
                c[i]=S.charAt(i);// 0 1 2 3 4
            }

            for (int i = 0; i < S.length()-A.length()+1; i++) {//5 -3
                for (int j=0;j<A.length();j++){ // 0 1 2
                    if(c[i+j]==b[j]){
                        cnt++;
                        if(cnt==A.length())
                            result++;
                    }
                }
                cnt=0;
            }

            System.out.println("#"+T+" "+result);

        }
    }
}