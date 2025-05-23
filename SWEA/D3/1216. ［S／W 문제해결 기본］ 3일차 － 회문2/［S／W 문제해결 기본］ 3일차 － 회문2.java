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

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution{
 public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int a = 0; a < 10; a++) {


            char[][] arr = new char[100][100];

            int T = Integer.parseInt(br.readLine());
            int len=0;
            int max = 0;



            for (int i = 0; i < 100; i++) {
                String s = br.readLine();
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    for (int k = 99; k >= j; k--) {// 0 99~0, 1 99~0
                        int left = j;// j 0~99일때 k 99~0
                        int right = k;//
                        boolean isPal = true;
                        while (left < right) {
                            if (arr[i][left] == arr[i][right]) {// 0~99, 1 98 2 97 ~
                                left++;
                                right--;

                            } else {
                                isPal = false;
                                break;
                            }
                        }
                        if (isPal) {
                            len = k - j + 1;
                            max = Math.max(len, max);
                            break;
                        }

                    }
                }
            }

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    for (int k = 99; k >= j; k--) {// 0 99~0, 1 99~0
                        int left = j;// j 0~99일때 k 99~0
                        int right = k;//
                        boolean isPal = true;
                        while (left < right) {
                            if (arr[left][i] == arr[right][i]) {// 0~99, 1 98 2 97 ~
                                left++;
                                right--;

                            } else {
                                isPal = false;
                                break;
                            }
                        }
                        if (isPal) {
                            len = k - j + 1;
                            max = Math.max(len, max);
                            break;
                        }

                    }
                }
            }
            System.out.println("#" + T + " " + max);


        }
    }
 }