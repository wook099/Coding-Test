import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int[] targets =new int[M];

        for (int i=1;i<=N;i++){
            dq.add(i);
        }
        st=new StringTokenizer(br.readLine());

        for (int i=0;i<M;i++){
            targets[i]=Integer.parseInt(st.nextToken());
        }
        int totalMoves = 0;
        for(int target: targets) {
            int targetIdx = 0;
            for (int num : dq) {
                if (num == target) {
                    break;
                }
                targetIdx++;
            }
            int size = dq.size();

            int leftDist = targetIdx;
            int rightDist = size - targetIdx;

            if (leftDist < rightDist) {
                for (int i = 0; i < leftDist; i++) {
                    dq.addLast(dq.pollFirst());
                    totalMoves++;
                }
            } else {
                for (int i = 0; i < rightDist; i++) {
                    dq.addFirst(dq.pollLast());
                    totalMoves++;
                }
            }
            dq.pollFirst();
        }

        System.out.println(totalMoves);
    }
}
