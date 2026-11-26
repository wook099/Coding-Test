import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            // 다음 테스트 케이스 입력을 정상적으로 읽기 위해 M줄 소모
            for (int i = 0; i < M; i++) {
                br.readLine();
            }
            
            sb.append(N - 1).append('\n');
        }
        
        System.out.print(sb);
    }
}