import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int V;
    static boolean[] visited;
    static int[][] arr;
    static StringBuilder sb;
    static StringBuilder sb1;
    static Queue<Integer> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N =Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());
        V =Integer.parseInt(st.nextToken());

        visited= new boolean[N+1];
        arr=new int[N+1][N+1];

        for (int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u= Integer.parseInt(st.nextToken());
            int v= Integer.parseInt(st.nextToken());
            arr[u][v]=arr[v][u]=1;
        }

        sb = new StringBuilder();
        dfs(V);
        sb1 = new StringBuilder();
        visited= new boolean[N+1];
        bfs(V);

        System.out.println(sb);
        System.out.println(sb1);
    }

    static void dfs(int pos){
        sb.append(pos+" ");
        visited[pos]=true;
        for (int i=1;i<=N;i++) {
            if(arr[pos][i]==1&&!visited[i]){
                dfs(i);
            }
        }
    }

    static void bfs(int pos){
        q = new LinkedList<>();

        q.add(pos);
        visited[pos]=true;

        while (!q.isEmpty()){
            int poll = q.poll();
            sb1.append(poll).append(" ");

            for (int i=1;i<=N;i++){
                if(arr[poll][i]==1&&!visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

}
