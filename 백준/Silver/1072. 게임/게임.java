import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st= new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());// 총 겜 수

        long Y = Long.parseLong(st.nextToken());// 이긴 수

        long current = (Y * 100) / X;// 80.xxx

        if (current>=99){
            System.out.println(-1);
            return;
        }

        long left = 1;
        long right = X;
        long ans=0;

        while (left<=right){

            long mid = (left+right)/2;

            long newrate = ((Y+mid)*100)/(X+mid);

            if (newrate > current){
                ans=mid;
                right=mid-1;
            }else {
                left=mid+1;
            }

        }
        System.out.println(ans);
    }
}
