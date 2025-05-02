import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, M;
    static int[][] arr;
    static int maxSafe = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfsWall(0);
        System.out.println(maxSafe);
    }

    // 벽을 3개 세우는 DFS
    static void dfsWall(int depth) {
        if (depth == 3) {
            int[][] copied = copyArray(arr);
            // 바이러스 퍼뜨리기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copied[i][j] == 2) {
                        dfsVirus(copied, i, j);
                    }
                }
            }

            // 안전 영역 세기
            int safe = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copied[i][j] == 0) safe++;
                }
            }

            maxSafe = Math.max(maxSafe, safe);
            return;
        }

        // 빈칸에 벽 세우기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfsWall(depth + 1);
                    arr[i][j] = 0; // 백트래킹
                }
            }
        }
    }

    // 바이러스 퍼뜨리기 (DFS)
    static void dfsVirus(int[][] map, int x, int y) {
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (map[nx][ny] == 0) {
                    map[nx][ny] = 2;
                    dfsVirus(map, nx, ny);
                }
            }
        }
    }

    // 배열 복사
    static int[][] copyArray(int[][] src) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = src[i].clone();
        }
        return copy;
    }
}
