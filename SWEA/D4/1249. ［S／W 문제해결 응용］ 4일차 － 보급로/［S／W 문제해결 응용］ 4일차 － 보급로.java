import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int N;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine().trim();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j) - '0';
                    dist[i][j]=Integer.MAX_VALUE;
                }
            }

            bfs();
            System.out.println("#" + tc + " " + dist[N - 1][N - 1]);
        }
    }

    static void bfs() {
        PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });

        dist[0][0] = 0;
        pq.add(new int[]{0, 0,0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curx = cur[0];
            int cury = cur[1];
            int curcost =cur[2];

            if(curcost>dist[curx][cury])
                continue;

            if(curx==N-1&&cury==N-1)
                return;

            for (int i = 0; i < 4; i++) {
                int nx = curx + dx[i];
                int ny = cury + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                // 핵심: 기존에 알고 있던 dist[nx][ny]보다 더 작은 비용으로 도착할 수 있을 때만 갱신 후 큐에 삽입
                if (dist[curx][cury] + map[nx][ny] < dist[nx][ny]) {
                    dist[nx][ny] = dist[curx][cury] + map[nx][ny];
                    pq.add(new int[]{nx, ny, dist[nx][ny]});
                }
            }
        }
    }
}