import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //길이가 적어도 L인 가장 짧은 연속된 음이 아닌 정수 리스트 , 전체 합
        int L = Integer.parseInt(st.nextToken()); //L은 2보다 크거나 같고, 100보다 작거나 같은 자연수

        // 만약 리스트의 길이가 100보다 작거나 같으면, 연속된 수를 첫째 줄에 공백으로 구분하여 출력한다.
        // 만약 길이가 100보다 크거나 그러한 수열이 없을 때는 -1을 출력한다.

        for (int len=L;len<=100;len++){
            int x=(N - len*(len-1)/2);
            if (x%len==0){
                int start=x/len;
                if (start<0){
                    System.out.println(-1);
                    return;
                }
                for (int i = 0; i < len; i++) {
                    System.out.print(start + i + " ");
                }
                return;

            }
        }
        System.out.println(-1);



    }
}
