import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int ans;
    static boolean[] vCol;
    static boolean[] vDiag1; // 우상향 대각선 (/)
    static boolean[] vDiag2; // 우하향 대각선 (\)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());

            //첫날은 1 두째날 2 홀 짝
            // 가장 나무가 큰거와 같아져야해 총 몇일?
            int max=0;
            int[] arr= new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0;i<N;i++){

                arr[i]=Integer.parseInt(st.nextToken());
                max=Math.max(arr[i],max);
            }
            int one =0;
            int two=0;
            for (int i=0;i<N;i++){
                one+=(max-arr[i])%2;
                two+=(max-arr[i])/2;
            }

            while (two>one+1){//1 x 1 x 1
                one+=2;
                two--;
            }
            int result=0;
            if (two==one)
                result=2*one;
            else if (one>two)
                result=2*one-1;
            else if(two>one)//1 2 1 2 2
                result=2*two;


            System.out.println("#" + tc + " " + result);
        }
    }
}