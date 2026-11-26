import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // [1단계: 초기 세팅] 입력 및 상어 위치 분리
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        int startX = 0, startY = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    startX = i;
                    startY = j;
                    arr[i][j] = 0;
                }
            }
        }
        bfs(startX, startY, 2);
    }

    static void bfs(int x, int y, int size) {
        int curSharkX = x;
        int curSharkY = y;
        int curSize = size;
        int eat = 0;       // 현재 크기에서 먹은 마릿수
        int totalTime = 0; // 누적 이동 시간

        while (true) {
            Queue<int[]> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[N][N];

            q.add(new int[]{curSharkX, curSharkY, 0});
            visited[curSharkX][curSharkY] = true;

            int min = Integer.MAX_VALUE;
            int minX = -1;               // 최종 선택된 물고기 X
            int minY = -1;               // 최종 선택된 물고기 Y

            while (!q.isEmpty()) {//1마리 탐색
                int[] cur = q.poll();
                int curX = cur[0];
                int curY = cur[1];
                int dist = cur[2];

                // 이미 찾은 최단 거리 물고기보다 멀어지면 더 볼 필요 없음
                if (dist >= min) continue;

                for (int i = 0; i < 4; i++) {
                    int nx = curX + dx[i];
                    int ny = curY + dy[i];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || arr[nx][ny] > curSize) {
                        continue;
                    }

                    visited[nx][ny] = true;
                    int nextDist = dist + 1;

                    // 먹을 수 있는 물고기(빈칸이 아니고 상어보다 작음) 발견 시 후보 갱신
                    if (arr[nx][ny] > 0 && arr[nx][ny] < curSize) {
                        if (nextDist < min) { // 1) 더 가까운 물고기면 무조건 갱신
                            min = nextDist;
                            minX = nx;
                            minY = ny;
                        } else if (nextDist == min) { // 2) 거리가 같으면 위쪽(nx) -> 왼쪽(ny) 순으로 갱신
                            if (nx < minX || (nx == minX && ny < minY)) {
                                minX = nx;
                                minY = ny;
                            }
                        }
                    }

                    q.add(new int[]{nx, ny, nextDist});
                }
            }//전체 탐색해서 1개 남음

            if (minX == -1) {
                break;
            }

            // 1마리 확정된 경우: 이동 및 식사 처리
            curSharkX = minX;
            curSharkY = minY;
            totalTime += min;
            arr[curSharkX][curSharkY] = 0;
            eat++;

            if (eat == curSize) {
                curSize++;
                eat = 0;
            }
        }

        System.out.println(totalTime);
    }
}

        /*
         * 물고기 M마리와 아기상어 1마리
         * 아기상어 크기는 2
         * 자기보다 큰 물고기가 있음 못지나감. 같은 크기 물고기는 지나갈수있음 ,작은 고기만 먹어
         *
         * 더 이상 먹을 고기가 없으면 엄마에게 도움 요청
         * 먹을수 있는 물고기가 1마리보다 많으면 !!가장 가까운!! 고기 먹어 (작은 고기부터 먹는게 아님)
         * 거리가 같을때 가장 위에 있는 고기 -> 왼쪽 고기
         *
         * 먹으면 빈칸이 됨
         * 자신의크기와 같은 수의 고기를 먹으면 크기 1증가
         *
         * 아기상어가 몇초동안 엄마에게 도움요청하지 않는지 구해라
         *
         * 1~6 고기 크기
         * 9 아기상어 위치 (크기 2)
         * */


