
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine());

        int max=1000000000;

        long[][] dp=new long[N+1][10];

        for (int i=1;i<10;i++){
            dp[1][i]=1;
        }
       //0일때는 앞에 무조건 1
        // 9일때 앞에 무조건 8
        for (int i=2;i<=N;i++){
            for (int j=0;j<10;j++){

                if (j==0){
                    dp[i][j]=dp[i-1][1]%max;
                }else if(j==9){
                    dp[i][j]=dp[i-1][8]%max;
                }else {
                    dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%max;
                }
            }
        }
        long sum=0;
        for (int i=0;i<10;i++){
            sum+=dp[N][i];
        }

        System.out.println(sum%max);
    }
}
