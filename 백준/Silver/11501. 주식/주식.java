import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());

        for (int i=0;i<T;i++){

            int N =Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr = new int[N];
            for (int j=0;j<N;j++){
                arr[j]=Integer.parseInt(st.nextToken());
            }
            long max=0;
            long cnt=0;

            for (int j=N-1;j>=0;j--){

                if (arr[j]>max){
                    max=arr[j];
                }else {
                    cnt+=max-arr[j];
                }
            }
            System.out.println(cnt);
        }

    }

}
