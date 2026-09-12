import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n, m, count;
    static int[][] m_arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 개수 읽기
        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {

            // 빈 줄이나 공백 처리용 StringTokenizer
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            m_arr = new int[m][2];

            for (int i = 0; i < m; i++) {//안되는 레시피 조합
                st = new StringTokenizer(br.readLine());
                m_arr[i][0] = Integer.parseInt(st.nextToken());
                m_arr[i][1] = Integer.parseInt(st.nextToken());
            }

            count = 0;
            visited = new boolean[n + 1];

            dfs(1);

            System.out.println("#" + test_case + " " + count);
        }
    }

    public static void dfs(int num) {

        for (int i = 0; i < m_arr.length; i++) {//안되는 조합 순회
            int a = m_arr[i][0];
            int b = m_arr[i][1];

            if (visited[a] && visited[b]) return;// 이미 밟았으면 끝
        }

        if (num > n) {
            count++;
            return;
        }

        visited[num] = true;
        dfs(num + 1);
        visited[num] = false;

        dfs(num + 1);
    }
}