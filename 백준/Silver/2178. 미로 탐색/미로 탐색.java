import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] arr;
    static int cnt = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                arr[i][j] = str.charAt(j - 1) - '0';
            }
        }

        bfs(1, 1);

        System.out.println(arr[N][M]);
    }

    static void bfs(int x, int y) {

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {

            int[] a = q.poll();

            int cX = a[0];
            int cY = a[1];

            for (int i = 0; i < 4; i++) {
                int nx = cX + dx[i];
                int ny = cY + dy[i];

                if (nx > N || ny > M || nx < 1 || ny < 1)
                    continue;

                if (arr[nx][ny] != 1)
                    continue;

                arr[nx][ny] = arr[cX][cY] + 1;
                q.add(new int[]{nx, ny});
            }


        }
    }
}