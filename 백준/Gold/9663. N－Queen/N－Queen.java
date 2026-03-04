import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int cnt=0;
    static boolean[][] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N][N];

        dfs( 0);
        System.out.println(cnt);

    }

    static void dfs(int pos) {

        if (pos == N) {
            cnt++;
            return;
        }

        for(int i = 0; i < N; i++) {
            arr[pos] = i;

            boolean valid = true;

            for (int j=0;j<pos;j++){
                if (arr[pos]==arr[j]||Math.abs(arr[pos]-arr[j])==Math.abs(pos-j)){
                    valid=false;
                    break;
                }
            }

            if (valid) dfs(pos + 1);
        }
    }
}
