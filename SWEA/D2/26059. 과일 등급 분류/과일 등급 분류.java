import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
class Solution
{
	 public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int t=1;t<=T;t++){

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int lo = Integer.parseInt(st.nextToken());
            int hi = Integer.parseInt(st.nextToken());

            int[] arr= new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i=0;i<N;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }

            int result=Integer.MAX_VALUE;
            boolean flag=false;

            for (int i=1;i<N-1;i++){
                for (int j=i+1;j<N;j++){

                    int low=i;
                    int mid=j-i;
                    int high=N-j;

                    if (low<lo||mid<lo||high<lo||low>hi||mid>hi||high>hi)
                        continue;

                    if (arr[i]==arr[i-1]||arr[j]==arr[j-1])
                        continue;

                    int max = Math.max(low,Math.max(mid,high));
                    int min = Math.min(low,Math.min(mid,high));

                    flag=true;
                    result=Math.min(result,max-min);
                }
            }

            if (flag){
                System.out.println("#"+t+" "+result);
            }else
                System.out.println("#"+t+" "+"-1");



        }

    }

}

