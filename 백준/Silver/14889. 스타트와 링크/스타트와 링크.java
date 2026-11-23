
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int N;
    static int K;
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        K=N/2;
        visited = new boolean[N];

        for (int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        System.out.println(min);
    }

    static void dfs(int idx, int depth) {
        if(depth==K){
            cal();
            return;
        }

        for (int i=idx;i<N;i++){//0 , 1,2

            visited[i]=true;
            dfs(i+1,depth+1);
            visited[i]=false;
        }
    }

    static void cal(){

        int Steam=0;
        int Lteam=0;
        for (int i=0;i<N-1;i++){
            for (int j=i+1;j<N;j++){
                if (visited[i]&&visited[j]){
                    Steam+=arr[i][j]+arr[j][i];
                }else if(!visited[i]&&!visited[j]){
                    Lteam+=arr[i][j]+arr[j][i];
                }
            }
        }

        min=Math.min(Math.abs(Steam-Lteam),min);
    }
}
