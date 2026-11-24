
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

        find(size,r,c);
        System.out.println(cnt);
    }
    static void find(int size,int r,int c){
        if (size==1)
            return;

        int half =size/2;//반띵
        int area= half*half;//너비

        if (r<half&&c<half){//1사
            find(half,r,c);
        }else if (r<half&&c>=half){//2사
            cnt+=area;
            find(half, r, c-half);
        }else if(r>=half&&c<half){//3사
            cnt+=area*2;
            find(half, r-half, c);
        }else {//4사
            cnt+=area*3;
            find(half, r-half, c-half);
        }

    }

    /*
    모든칸을다 셀수없음 -> 시간초과
    4등분해서 몇사분면에 있는지 찾아가야함;;
    2N-1 × 2N-1로 4등분
    * */
}