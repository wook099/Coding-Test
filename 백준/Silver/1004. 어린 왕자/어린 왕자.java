
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t=0;t<T;t++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int N = Integer.parseInt(br.readLine());
            int []x =new int[N];
            int []y = new int[N];
            int []r = new int[N];
            int count=0;

            for (int i=0;i<N;i++){
                st=new StringTokenizer(br.readLine());
                x[i]=Integer.parseInt(st.nextToken());
                y[i]=Integer.parseInt(st.nextToken());
                r[i]=Integer.parseInt(st.nextToken());

                boolean start = Math.pow(x1-x[i],2)+Math.pow(y1-y[i],2)<Math.pow(r[i],2);
                boolean end = Math.pow(x2-x[i],2)+Math.pow(y2-y[i],2)<Math.pow(r[i],2);

                if(start!=end){
                    count++;
                }
            }
            System.out.println(count);

        }

    }
}
/*
    첫줄 테케

    출발-5,1  끝좌표 12,1
    7개

    1,1     8
   -3,-1    1
    2,2     2
    5,5     1
   -4,5     1
   12,1     1
   12,1     2

   출발 -5,1  끝 5,1
   1
   0,0,2

*/