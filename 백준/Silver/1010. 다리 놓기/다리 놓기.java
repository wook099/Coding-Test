import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            // 서쪽에는 다리 N, 동쪽에 M (N<=M)
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N > M) {
                return;
            }
            int[][] dp = new int[M + 1][N + 1];

//        for (int i = 0; i <= M; i++) {
//            dp[i][0] = 1; // 0개 선택
//        }
//
//        for (int i = 1; i <= M; i++) {       // 동쪽 사이트 수
//            for (int j = 1; j <= Math.min(i, N); j++) { // 선택할 서쪽 사이트 수
//                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
//            }
//        }
            long result = 1;
            for (int i = 0; i < N; i++) {
                result *= (M - i);
                result /= (i + 1);
            }

            System.out.println(result);
            //McN
            //점화식 필요해보임
            //ar[0]=M-i;
            //ar[i]=ar[i]*ar[i-1]
            //
        }
    }
}
