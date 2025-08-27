import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] pick;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int [][]arr = new int[N+1][3];

        int M=9901;

        // 1~N까지  1 2
        arr[1][0]=1;
        arr[1][1]=1;
        arr[1][2]=1;
        //이게 arr[2][0]=arr[1][0]+arr[1][1]+arr[1][2];

        //... arr[4][0] [1] [2]
        int sum=0;
        for (int i=1;i<N;i++){

            arr[i+1][0]=(arr[i][0]+arr[i][1]+arr[i][2])%M;
            arr[i+1][1]=(arr[i][0]+arr[i][2])%M;
            arr[i+1][2]=(arr[i][0]+arr[i][1])%M;

        }

        sum= (arr[N][0]+arr[N][1]+arr[N][2])%M;

        System.out.println(sum);

    }


}
