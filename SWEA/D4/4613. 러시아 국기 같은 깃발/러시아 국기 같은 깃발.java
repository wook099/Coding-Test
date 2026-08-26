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

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < M; j++) {
                    if (s.charAt(j)=='W')
                        arr[i][0]++;
                    else if (s.charAt(j)=='B')
                        arr[i][1]++;
                    else
                        arr[i][2]++;
                }
            }

            //W -> B -> R
            //문자열 넣고 세주고 있지만, 애초에 cnt해서 배열에 넣어놓으면 시간 단축!

            int min=Integer.MAX_VALUE;
            for (int i=0;i<N-2;i++){//white
                for (int j=i+1;j<N-1;j++){//blue

                    int cnt=0;

                    for (int w = 0; w <= i; w++) {
                        cnt+=M-arr[w][0];
                    }

                    for (int b = i + 1; b <= j; b++) {
                        cnt+=M-arr[b][1];
                    }

                    for (int r = j + 1; r < N; r++) {
                        cnt+=M-arr[r][2];
                    }

                    if (cnt < min)
                        min = cnt;

                }


            }
            System.out.println("#"+t+" "+min);

        }
    }
}
