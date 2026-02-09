import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][] target= new int[N][M];

        for (int i=0;i<N;i++){
             String s = br.readLine();;
            for (int j=0;j<M;j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i=0;i<N;i++){
            String s = br.readLine();;
            for (int j=0;j<M;j++){
                target[i][j] = s.charAt(j) - '0';
            }
        }

        int cnt=0;

        for (int i=0;i<N-2;i++){// 0~5   0 4 n-1
            for (int j=0;j<M-2;j++){

                if(arr[i][j]!=target[i][j]){
                    for (int a=i;a<=i+2;a++){
                        for (int b=j;b<=j+2;b++) {
                            if(arr[a][b]==1){
                                arr[a][b]=0;
                            } else {
                                arr[a][b]=1;
                            }
                        }
                    }
                    cnt++;
                }
            }
        }

        for (int i =0;i<N;i++){
            for (int j=0;j<M;j++){
                if(arr[i][j]!=target[i][j]){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(cnt);

    }
}
