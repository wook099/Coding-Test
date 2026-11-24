
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String n;
    static int N;
    static int r,c;
    static int cnt=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        r =Integer.parseInt(st.nextToken());
        c =Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);
        
        while (size>1){
            
            int half=size/2;
            int area=half*half;
            
            if (r<half&&c<half){
                size=half;
            }else if(r<half&&c>=half){
                cnt+=area;
                c-=half;
                size=half;
            }else if(r>=half&&c<half){
                cnt+=area*2;
                r-=half;
                size=half;
            }else{
                cnt+=area*3;
                r-=half;
                c-=half;
                size=half;
            }
            
        }
        System.out.println(cnt);
    }
 

    /*
    모든칸을다 셀수없음 -> 시간초과
    4등분해서 몇사분면에 있는지 찾아가야함;;
    2N-1 × 2N-1로 4등분
    * */
}