import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int [][]arr=new int[N][2];

        st = new StringTokenizer(br.readLine());
        for (int i =0;i<N;i++){
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=i;
        }//2131 0123

        Arrays.sort(arr,(a,b)->{
            if(a[0]==b[0])
                return a[1]-b[1];
            else
                return a[0]-b[0];
        });//1123 1302

        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            // arr[i][1] (원래 위치)를 인덱스로 사용하여 i (현재 정렬된 순서)를 저장
            P[arr[i][1]] = i;
        }//1302 0123

        for (int x : P) {
            System.out.print(x + " ");
        }
    }
}
