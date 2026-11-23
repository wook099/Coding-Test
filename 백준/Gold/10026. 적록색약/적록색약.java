
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static char[][] arr;
    static int[] dx= {1,-1,0,0};
    static int[] dy= {0,0,-1,1};
    static boolean[][] visited;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N =Integer.parseInt(br.readLine());
        arr=new char[N][N];
        visited=new boolean[N][N];

        for (int i=0;i<N;i++){
            String s =br.readLine();
            for (int j=0;j<N;j++){
                arr[i][j]=s.charAt(j);
            }
        }
        int cnt=0;
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                if (!visited[i][j]){
                    bfs(i,j);
                    cnt++;
                }
            }
        }
        visited=new boolean[N][N];
        int pnt=0;
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                if (!visited[i][j]){
                    pfs(i,j);
                    pnt++;
                }
            }
        }
        System.out.println(cnt +" "+pnt);
    }
    static void bfs(int x,int y){

        Queue<int[]> q=new ArrayDeque<>();
        q.add(new int[]{x,y});
        visited[x][y]=true;

        while (!q.isEmpty()){

            int[] cur=q.poll();
            int curX=cur[0];
            int curY=cur[1];

            for (int i=0;i<4;i++){
                int nx=curX+dx[i];
                int ny=curY+dy[i];

                if(nx<0||ny<0||nx>=N||ny>=N||visited[nx][ny]||arr[curX][curY]!=arr[nx][ny])
                    continue;

                visited[nx][ny]=true;
                q.add(new int[]{nx,ny});
            }
        }

    }
    static void pfs(int x,int y) {

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {

            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny])
                    continue;

                if (arr[curX][curY] == 'G' && (arr[nx][ny] == 'R' || arr[nx][ny] == 'G')) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }else if(arr[curX][curY] == 'R' && (arr[nx][ny] == 'R' || arr[nx][ny] == 'G')) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }else if (arr[curX][curY]==arr[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }

            }
        }
    }
}
