import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
     public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int []a = new int[N];
        int []b = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            b[i]=Integer.parseInt(st.nextToken());
        }
        //S = A[0] × B[0] + ... + A[N-1] × B[N-1]

        //작은수 -> 가장큰수x 가장작은수
        // b의 가장큰수에 a에 가장 작은수를 배치
        boolean []visited1=new boolean[N];
        boolean []visited2 = new boolean[N];

        int sum=0;
        for (int t=0;t<N;t++){
            int min=Integer.MAX_VALUE;
            int max=0;

            int idx1=0;
            for (int i=0;i<N;i++){
                if(b[i]>max&&!visited1[i]){
                    max=b[i];
                    idx1=i;
                }
            }
            visited1[idx1]=true;
            int idx2=0;
            for (int i=0;i<N;i++){
                if(a[i]<min&&!visited2[i]){
                    min=a[i];
                    idx2=i;
                }


            }
            visited2[idx2]=true;

            sum +=min*max;

        }
        System.out.println(sum);
    }
}
