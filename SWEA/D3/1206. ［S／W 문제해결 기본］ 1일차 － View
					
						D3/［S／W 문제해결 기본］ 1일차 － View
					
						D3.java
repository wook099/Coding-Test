import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Solution
{
	public static void main(String args[]) throws Exception
	{
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int T = Integer.parseInt(br.readLine());


        for (int t=1;t<=10;t++) {
            int N =Integer.parseInt(br.readLine());
            int[] arr= new int[N];

           StringTokenizer st= new StringTokenizer(br.readLine());

           for (int i=0;i<N;i++){
               arr[i]=Integer.parseInt(st.nextToken());
           }
           int sum=0;
           for (int i=2;i<N-2;i++){
               int max=0;
               if(arr[i]==0)
                   continue;
               if(arr[i]>arr[i-1]&&arr[i]>arr[i-2]&&arr[i]>arr[i+1]&&arr[i]>arr[i+2]){
                   max=Math.max(arr[i-1],max);
                   max=Math.max(max,arr[i-2]);
                   max=Math.max(max,arr[i+2]);
                   max=Math.max(max,arr[i+1]);

                   sum+=arr[i]-max;
               }
           }
            System.out.println("#"+t+" "+sum);



        }
	}
}