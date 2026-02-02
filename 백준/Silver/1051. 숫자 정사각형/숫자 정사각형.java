import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i=0;i<N;i++){
            String str = br.readLine();
            for (int j=0;j<M;j++){
                map[i][j]=str.charAt(j)-'0';
            }
        }

        int maxArea = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                int limit = Math.min(N - i, M - j);

                for (int k = limit; k > 1; k--) {
                    int val = map[i][j];

                    if (val == map[i][j + k - 1] &&
                            val == map[i + k - 1][j] &&
                            val == map[i + k - 1][j + k - 1]) {

                        maxArea = Math.max(maxArea, k * k);
                        break;
                    }
                }
            }
        }

        System.out.println(maxArea);
    }
}
