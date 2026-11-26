import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {//상근이
    static int[] p;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =Integer.parseInt(br.readLine());

        for (int t=0;t<T;t++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            p=new int[N+1];
            for (int i=1;i<N+1;i++){
                p[i]=i;
            }
            int cnt=0;
            for (int i=0;i<M;i++){

                st = new StringTokenizer(br.readLine());
                int a =Integer.parseInt(st.nextToken());
                int b =Integer.parseInt(st.nextToken());

                if (find(a)!=find(b)){
                    union(a,b);
                    cnt++;
                }

            }

            System.out.println(cnt);

        }

        /*
        상근이는 N개국 여행을 하는데 최대한 적은 비행기를 타야함
        모든 국가를 다 지나가야해 ,양방향임

        유니온 파인드?
        * */

    }
    static int find(int x){// 부모찾기 메서드

        if (x==p[x])//부모가 자기면 바로나와
            return x;

        return find(p[x]);//부모 값을 찾아야함 이것도 논리적으론 맞지만 경로압축이 되진않음 : O(N)
        //return p[x]=find(p[x]); 찾은 최종루트를 갱신하며 경로압축 : O(1)
    }

    static void union(int x,int y){
        int PX=find(x);
        int PY=find(y);

        if (PX==PY)
            return;

        p[PY]=PX;// py부모를 px엉덩이에 붙여 px부모를 바라봄

    }

}
