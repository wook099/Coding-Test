import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int x1=0;
        int y1=0;
        int x2=0;
        int y2=0;
        int r1=0;
        int r2=0;

        for (int i=0;i<T;i++){

            StringTokenizer st =new StringTokenizer(br.readLine());
            x1=Integer.parseInt(st.nextToken());
            y1=Integer.parseInt(st.nextToken());
            r1=Integer.parseInt(st.nextToken());
            x2=Integer.parseInt(st.nextToken());
            y2=Integer.parseInt(st.nextToken());//애네가 반지름임
            r2=Integer.parseInt(st.nextToken());

            int d= (y2-y1)*(y2-y1)+(x2-x1)*(x2-x1);
            if(x1==x2&&y1==y2&&r1==r2){
                System.out.println(-1);
            }
            else if(d==(r1+r2)*(r1+r2)){//외접
                System.out.println(1);
            }
            else if(d==(r1-r2)*(r1-r2)){//내접
                System.out.println(1);
            }
            else if (d>(r1+r2)*(r1+r2))
                System.out.println(0);
            else if(d<(r1-r2)*(r1-r2))
                System.out.println(0);
            else
                System.out.println(2);
        }

        //x1 y1 , x2 y2  원의 좌표라 생각하고 겹치는건 2개

    }
}
