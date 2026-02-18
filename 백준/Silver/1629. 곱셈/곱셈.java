import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static long sum=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());

        System.out.println(cal(a,b,c));
    }

    static long cal(int a, int b, int c){

        if (b==1){
            return a%c;
        }

        long m = cal(a,b/2,c);

        sum=(m*m)%c;
        if(b%2==1){
            return sum%c*a%c;
        }

        return sum;
    }
}
