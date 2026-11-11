
import java.util.*;

import java.io.*;

public class Solution {

	static int N, W, H;
    static int minBricks;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            int[][] map = new int[H][W];
            int totalBricks = 0;

            for (int r = 0; r < H; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < W; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                    if (map[r][c] > 0) 
                    	totalBricks++;
                }
            }

            minBricks = totalBricks;

            // 중복순열 백트래킹 시작
            comb(0, map);

            System.out.println("#" + t + " " + minBricks);
        }
    }

    // 1. 중복순열 백트래킹
    static void comb(int cnt, int[][] map) {
        int remain = 0;
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if (map[r][c] > 0) remain++;
            }
        }

        // 가지치기: 이미 부술 벽돌이 없으면 즉시 종료
        if (remain == 0) {
            minBricks = 0;
            return;
        }

        
        if (cnt == N) {//구슬 다 씀
            minBricks = Math.min(minBricks, remain);
            return;
        }

        for (int c = 0; c < W; c++) {
            int r = 0;
            while (r < H && map[r][c] == 0) {
                r++;
            }
            if (r == H) 
            	continue;

            int[][] nextMap = new int[H][W];
            for (int i = 0; i < H; i++) {
                System.arraycopy(map[i], 0, nextMap[i], 0, W);
            }

            bfs(r, c, nextMap);
            comb(cnt + 1, nextMap);
        }
    }

    static void bfs(int startR, int startC, int[][] map) {
        Queue<int[]> q = new ArrayDeque<>();

        if (map[startR][startC] > 1) {
            q.add(new int[]{startR, startC, map[startR][startC]});
        }
        map[startR][startC] = 0; // 명중한 벽돌 파괴

        // --- 연쇄 폭발 ---
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int power = cur[2];

            for (int d = 0; d < 4; d++) {
                int nr = r;
                int nc = c;

                for (int k = 1; k < power; k++) {
                    nr += dx[d];
                    nc += dy[d];

                    if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
                    	
                        if (map[nr][nc] > 0) {
                            if (map[nr][nc] > 1) {//1 보다 크면 다음 폭탄으로 이어짐
                                q.add(new int[]{nr, nc, map[nr][nc]});
                            }
                            map[nr][nc] = 0;//1이면 그냥 1넣고 패슈
                        }
                    } else { //어긋나면 끝
                        break;
                    }
                }
            }
        }

        // 중력 처리 ---
        for (int c = 0; c < W; c++) {//가로
            int writeRow = H - 1;
            
            for (int r = H - 1; r >= 0; r--) {//밑에서 위로
                if (map[r][c] > 0) {// 양수면
                    int temp = map[r][c];
                    map[r][c] = 0;
                    map[writeRow--][c] = temp;
                }
            }
        }
    }
}