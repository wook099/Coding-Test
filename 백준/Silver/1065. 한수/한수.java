import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N==1000){
            System.out.println(144);
            return;
        }
        int cnt=0;

        if(N/100==0){
            System.out.println(N);
        }else {
            // 123 , 135 , 147 . 159, 234

            for (int i=101;i<=N;i++){
                int a =i/100;
                int b =i%100/10;
                int c =i%10;
                if(c-b==b-a){
                    cnt++;
                }
            }
            System.out.println(cnt+99);
        }

    }
}
