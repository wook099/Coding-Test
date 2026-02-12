
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[][] track;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());//노드 수

        visited = new boolean[N+1];
        track=new int[N+1][N+1];

        int M = Integer.parseInt(br.readLine());//간선

        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());

            track[A][B]=1;
            track[B][A]=1;
        }
        dfs(1);

        System.out.println(count-1);

    }
    static void dfs(int node){

        visited[node]=true;
        count++;
        for (int i=0;i<track.length;i++){
            if(track[node][i]==1&&!visited[i]){
                dfs(i);
            }
        }
    }
}