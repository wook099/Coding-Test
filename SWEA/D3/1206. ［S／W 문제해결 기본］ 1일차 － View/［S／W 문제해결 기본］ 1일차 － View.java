import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Solution
{
	public static void main(String args[]) throws Exception
	{
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A=0;
        int sum=0;
        int max1=0;
        int max2=0;
        int result=0;
        while (A++ < 10){
            int T= Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[T];
            for (int i=0;i<T;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i=2;i<T-2;i++){
                if(arr[i]>arr[i-1] && arr[i]>arr[i-2] && arr[i]>arr[i+1] && arr[i]>arr[i+2]){
                    max1=Math.max(arr[i-1],arr[i-2]);

                    max2=Math.max(arr[i+1],arr[i+2]);
                    sum=Math.max(max2,max1);

                    result+=arr[i]-sum;

                }



            }
            System.out.println("#"+A+" "+result);
            result=0;
        }
	}
}