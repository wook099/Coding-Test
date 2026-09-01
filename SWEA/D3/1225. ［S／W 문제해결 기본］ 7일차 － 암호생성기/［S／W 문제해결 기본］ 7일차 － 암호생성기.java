import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // SWEA 암호생성기는 총 10개의 테스트 케이스가 주어집니다.
        for (int t = 1; t <= 10; t++) {
            
            // 1. 테스트 케이스 번호 읽기
            String tcStr = br.readLine();
            if (tcStr == null) break; // 입력이 끝나면 종료
            int tc = Integer.parseInt(tcStr.trim());

            // 2. 8개의 데이터 읽기
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<Integer> queue = new ArrayDeque<>();

            for (int i = 0; i < 8; i++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }

            // 3. 암호 생성 시뮬레이션
            int cnt = 0;
            while (true) {
                int first = queue.poll();
                cnt = (cnt % 5) + 1;
                first -= cnt;

                // 0 이하가 되면 0으로 만든 뒤 큐에 넣고 종료
                if (first <= 0) {
                    first = 0;
                    queue.offer(first);
                    break;
                }

                queue.offer(first);
            }

            // 4. SWEA 출력 포맷에 맞추기 (#테스트케이스번호 숫자1 숫자2 ... 숫자8)
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc);
            for (int num : queue) {
                sb.append(" ").append(num);
            }
            
            System.out.println(sb.toString());
        }
    }
}