import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int n,k,w,v;
    static int[] arr;
    static int[] brr;
    static int max=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr= new int[n];
        brr= new int[n];

        int[] w = new int[n + 1];
        int[] v = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n + 1][k + 1];
        for (int i=1;i<=n;i++){//모든 물건을 넣어줘야하니까 1~n까지 돌리고

            for (int j=1;j<=k;j++){//현재 배당의 무게가 1~k일때의 모든 경우를 시뮬레이션

                if(w[i]>j){//이미 최적으로 다찼네? 넘었으니까 이전꺼가 나와야댐
                    dp[i][j]=dp[i-1][j];
                }else {
                    int not=dp[i-1][j];//현재 최적의 상태에서 넣지 않는 경우 i 문이 ++됐으니 뺴주는거임 그게 전으로돌아가는방법
                    int take=dp[i-1][j-w[i]]+v[i];// 똑같이 i문에서 빼주고
                    dp[i][j] = Math.max(not, take);
                }
            }
        }

        System.out.println(dp[n][k]);
        /*
        * 무게 W와 가치 V 보관
        *
        * */
    }

}