import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<Integer>[] arr;
    static int cnt=0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int[] count= new int[N+1];
        arr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i=0;i<M;i++){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[b].add(a);
        }
        int max=0;

        for (int i=1;i<=N;i++){
            cnt=0;
            count[i]=bfs(i);
            max=Math.max(max,count[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (count[i] == max) {
                sb.append(i+" ");
            }
        }
        System.out.println(sb);
    }

    static int bfs(int pos){
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(pos);
        visited[pos]=true;

        while (!q.isEmpty()){
            int cur = q.poll();
            for (int a : arr[cur]){
                if(!visited[a]){
                    cnt++;
                    visited[a] = true;
                    q.add(a);
                }
            }
        }
        return cnt;
    }
}
