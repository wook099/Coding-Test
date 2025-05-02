import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int maxProfit = 0;

    public static void dfs(int day, int profit) {
        if (day >= N) { // 퇴사일 넘으면 종료 (day == N일 때도 종료해야 함)
            maxProfit = Math.max(maxProfit, profit);
            return;
        }

        // 최대 이익 갱신
        maxProfit = Math.max(maxProfit, profit);

        // 상담 시작: 현재 상담이 가능한 경우
        if (day + arr[day][0] <= N) {
            dfs(day + arr[day][0], profit + arr[day][1]);
        }

        // 상담 안 시작: 현재 상담을 건너뛰고 다음 날로 이동
        dfs(day + 1, profit);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 기간
            arr[i][1] = Integer.parseInt(st.nextToken()); // 보수
        }

        // dfs 시작
        dfs(0, 0);
        System.out.println(maxProfit);
    }
}
