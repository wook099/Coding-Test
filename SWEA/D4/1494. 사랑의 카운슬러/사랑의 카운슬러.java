import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static long min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int test = 1; test <= T; test++) {
            N = Integer.parseInt(br.readLine().trim());
            arr = new int[N][2];
            visited = new boolean[N];
            min = Long.MAX_VALUE;

            // N개의 줄에 걸쳐 각 점의 좌표를 읽어야 함
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            // 0번 인덱스부터 시작, 현재 선택된 '+' 그룹 개수 0개
            dfs(0, 0);

            sb.append("#").append(test).append(" ").append(min).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int depth,int goals){


        if(goals==N/2){
            long x=0;
            long y=0;

            for(int i=0;i<N;i++){
                if(visited[i]){
                    x+=arr[i][0];// 선택된 x좌표 끼리 더해
                    y+=arr[i][1];
                }else {
                    x-=arr[i][0];
                    y-=arr[i][1];
                }
            }

            long sum=x*x+y*y;
            min=Math.min(min,sum);
            return;
        }
        if(depth>=N){
            return;
        }
        visited[depth]=true;
        dfs(depth+1,goals+1);

        visited[depth]=false;
        dfs(depth+1,goals);
    }
}