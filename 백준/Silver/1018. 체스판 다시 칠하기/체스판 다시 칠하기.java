import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int minPaint = Integer.MAX_VALUE;

        // 모든 8x8 블록 탐색
        for (int sr = 0; sr <= N - 8; sr++) {
            for (int sc = 0; sc <= M - 8; sc++) {
                int cntW = 0; // W 시작
                int cntB = 0; // B 시작

                for (int i = sr; i < sr + 8; i++) {
                    for (int j = sc; j < sc + 8; j++) {
                        char current = board[i][j];

                        // 체스판 짝수/홀수 위치 기준 색 비교
                        if ((i + j) % 2 == 0) {
                            if (current != 'W') cntW++;
                            if (current != 'B') cntB++;
                        } else {
                            if (current != 'B') cntW++;
                            if (current != 'W') cntB++;
                        }
                    }
                }

                minPaint = Math.min(minPaint, Math.min(cntW, cntB));
            }
        }

        System.out.println(minPaint);
    }
}
