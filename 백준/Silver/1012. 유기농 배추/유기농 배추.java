import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx={1,0,-1,0};
    static int[] dy={0,1,0,-1};
    static int nx=0;
    static int ny=0;
    static int N;
    static int M;
    static int[][] arr;
    static int dir=0;
    static int cnt=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            arr= new int[M][N];



            for (int j=0;j<K;j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr[a][b] = 1;
            }

//            dfs(0,0);
            for (int i=0;i<M;i++){
                for (int j=0;j<N;j++){
                    if (arr[i][j]==1){
                        dfs(i,j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
            cnt=0;
        }
    }
    static void dfs(int x,int y){

        for (int dir=0;dir<4;dir++){

            nx=x+dx[dir];
            ny=y+dy[dir];

            if (nx<0||nx>=M||ny<0||ny>=N)
                continue;

            if (arr[nx][ny]==1){
                arr[nx][ny]=0;
                dfs(nx,ny);
            }

        }


    }
}
