import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr =new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int[] dp=new int[N];
        dp[0]=arr[0];
        int result=dp[0];
        //arr[0] 
        //dp[1] = max(arr[0],arr[0]+arr[1])
        //dp[2] = max(arr[1],arr 0 1 2)
        //dp[3] = max(arr[2],arr 0 1 2 3)
        for (int i=1;i<N;i++){
            dp[i]=Math.max(arr[i],dp[i-1]+arr[i]);
            result=Math.max(result,dp[i]);
        }

//        for (int i=0;i<N;i++){
//            int sum=0;
//            for (int j=i;j<N;j++){
//
//                sum+=arr[j];
//                result=Math.max(sum,result);
//            }
//        }
        System.out.println(result);
    }
}
//이중 포문 시간복잡도 터짐
// DP로 풀어야함
