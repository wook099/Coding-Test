import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

        int count = 0;
        arr = new int[N+1][N+1];
        visited = new boolean[N + 1];

        for (int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u][v]=arr[v][u]=1;//
        }

        for (int i=1;i<=N;i++){// 1~6 방문체크
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
//      1 2
//      2 5
//      5 1
//      3 4
//      4 6
//      5 4
//      2 4
//      2 3
    }
    static void dfs(int now) {
        visited[now] = true;

        for (int i = 1; i <= N; i++) {
            if (arr[now][i] == 1 && !visited[i]) { // 내가 통로만들어놨는데 방문표시없으면 바로 방문표시하고 다음 수로 dfs진행
                dfs(i);
            }
        }
    }
    
    
}
