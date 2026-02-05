import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr = new int[30][30];
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){

            StringTokenizer st= new StringTokenizer(br.readLine());
            int N= Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());


            System.out.println(combination(M, N));
        }


    }

    static int combination(int m, int n) {

        if (arr[m][n] > 0) {
            return arr[m][n];
        }

        if (m < n)
            return 0;

        if (m == n || n == 0) {
            return arr[m][n] = 1;
        }

        return arr[m][n] = combination(m - 1, n - 1) + combination(m - 1, n);
    }
}
