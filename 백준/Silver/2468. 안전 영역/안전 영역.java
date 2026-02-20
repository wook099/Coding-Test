import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] arr;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int N;
    static int cnt;
    static int maxHigh=0;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N =Integer.parseInt(br.readLine());

        arr=new int[N][N];

        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());

                if (arr[i][j] > maxHigh) {
                    maxHigh = arr[i][j];
                }
            }
        }

        int max=0;
        for (int i=0;i<maxHigh;i++){
            visited = new boolean[N][N];
            cnt=0;
            for (int a=0;a<N;a++){
                for (int b=0;b<N;b++){

                    if (arr[a][b]>i&&!visited[a][b]){
                        dfs(a,b,i);
                        cnt++;
                    }
                }
            }
            max=Math.max(cnt,max);

        }

        System.out.println(max);


    }

    static void dfs(int x,int y,int height){

        visited[x][y]=true;

        for (int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0||ny<0||nx>=N|ny>=N||visited[nx][ny])
                continue;

            if (arr[nx][ny]<=height)
                continue;

            visited[nx][ny]=true;

            dfs(nx,ny,height);
        }


    }
}
