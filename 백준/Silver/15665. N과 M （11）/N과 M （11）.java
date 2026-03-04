import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());

        arr= new int[N];// 배열 길이
        result= new int[N];
        for (int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);


        visited= new boolean[N+1];
        sb =new StringBuilder();
        dfs(0);
        System.out.println(sb);

    }
    static void dfs(int depth){

        if (depth==M){

            for (int i=0;i<M;i++){
                sb.append(result[i]+" ");
            }
            sb.append("\n");
            return;
        }
        int pre = 0;

        for (int i=0;i<N;i++){
            if(pre!=arr[i]){
                result[depth]=arr[i];
                pre = arr[i];
                dfs(depth+1);
            }


        }
    }
}
