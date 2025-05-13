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

        int T = Integer.parseInt(br.readLine());



        for(int a=1;a<T+1;a++) {
            long sum=0;
            int N = Integer.parseInt(br.readLine());
            int[] arr= new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            for (int i = N-1; i >= 0; i--) {

                if(arr[i]>max){
                    max=arr[i];
                }
                else if(arr[i]<max)
                    sum+=max-arr[i];

            }

            System.out.println("#"+a+" "+sum);
        }
	}
}