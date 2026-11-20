import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M,N;
    static int[][] arr;
    static int max=0;
    static int[] dx= {1,-1,0,0};
    static int[] dy= {0,0,1,-1};
    static Queue<int[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr=new int[N][M];
        /*
        익은 토마토 옆에 있으면 익는대 -> 전체 다 익는 최소 일수 +1하면된다는뜻 bfs
        * */
        for (int i=0;i<N;i++){//4
            st = new StringTokenizer(br.readLine());

            for (int j=0;j<M;j++){//6
                arr[i][j]=Integer.parseInt(st.nextToken());
                if (arr[i][j]==1){
                    q.add(new int[]{i, j,1});
                }
            }
        }
        bfs();

        for (int i=0;i<N;i++){//4
            for (int j=0;j<M;j++){//6
                max=Math.max(max,arr[i][j]);
                if(arr[i][j]==0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(max-1);

    }
    static void bfs(){

        while (!q.isEmpty()){
            int[] cur=q.poll();
            int curx=cur[0];
            int cury=cur[1];
            int cnt=cur[2];
            cnt++;

            for (int i=0;i<4;i++){
                int nx=curx+dx[i];
                int ny=cury+dy[i];

                if(nx<0||nx>=N||ny<0||ny>=M||arr[nx][ny]!=0)
                    continue;

                arr[nx][ny]=cnt;
                q.add(new int[]{nx,ny,cnt});
            }
        }

    }
}
