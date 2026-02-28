import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static boolean[][] visite;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr= new int[M];// 배열 길이
        visite = new boolean[N + 1][N+1];// 값에 대한 방문체크
        visited= new boolean[N+1];
        sb =new StringBuilder();
        dfs(0);
        System.out.println(sb);

    }
    static void dfs(int depth){

        if (depth==M){

            for (int i=0;i<M;i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=1;i<=N;i++) {
            arr[depth] = i;
            dfs(depth + 1);
        }
        //dep=0

        // arr[0]=1 arr[1]=1,arr[2]
    }
}















