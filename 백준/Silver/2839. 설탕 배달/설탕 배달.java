import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int a=3;
        int b=5;

        //5로 나누어보고
        // 3으로 나누어보고
        //

        int x=N/5;
        int sum=0;
        int no=0;

        for (int i=0;i<=x;i++){
            int result=0;
            if ((N-b*i)%a==0){
                result=(N-b*i)/a+i;
                sum=Math.min(result,Integer.MAX_VALUE);
            }
        }
        if(sum==0){
            System.out.println(-1);
        }else
            System.out.println(sum);
    }
}
