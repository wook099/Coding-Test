import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr= new int[L+1];
        for(int i=1;i<L+1;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int n=Integer.parseInt(br.readLine());

        int t=0;
        for (int i=1;i<L+1;i++){
            if(arr[i]>=n){
                t=i;
                break;
            }
        }

        if (arr[t] == n) {
            System.out.println(0);
            return;
        }

        int start=arr[t-1];
        int end = arr[t];

        int sum=0;
            sum+=(n-start-1)*(end-n);//3개
            sum+=end-n-1;

        System.out.println(sum);
    }
}
