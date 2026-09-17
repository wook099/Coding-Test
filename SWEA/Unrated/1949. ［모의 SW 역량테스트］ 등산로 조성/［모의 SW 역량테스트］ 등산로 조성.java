import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int K;
    static int[][] arr;
    static int[] dx= {0,0,1,-1};
    static int[] dy= {1,-1,0,0};
    static boolean flag;
    static int cnt=0;
    static boolean[][] visited;

    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T =Integer.parseInt(st.nextToken());
        for(int t=1;t<=T;t++) {

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            visited= new boolean[N][N];
            arr= new int[N][N];
            int max=0;
            flag=false;
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {

                    arr[i][j]=Integer.parseInt(st.nextToken());

                    if(max<arr[i][j]){
                        max=arr[i][j];
                    }
                }
            }
            cnt=0;

            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(max==arr[i][j]){
                        dfs(i,j,flag,1);//가장 높은 값에서만 dfs들어감
                    }

                }
            }
            System.out.println("#" + t + " " + cnt);


        }
    }
    static void dfs(int x,int y,boolean flag,int length) {

        cnt= Math.max(cnt,length);
        visited[x][y]=true;

            for(int d=0;d<4;d++) {

                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny])
                    continue;

                if (arr[x][y] > arr[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, flag, length + 1);
                    visited[nx][ny] = false;

                } else if (arr[x][y] > arr[nx][ny] - K && !flag) {
                    int temp = arr[nx][ny];

                    visited[nx][ny] = true;
                    arr[nx][ny] = arr[x][y] - 1;

                    dfs(nx, ny, true, length + 1);
                    visited[nx][ny] = false;
                    arr[nx][ny] = temp;
                }
            }
            visited[x][y]=false;

    }
}
/*
 * 등산로는 가장 높은 곳부터 시작
 * 딱 한곳 최대 K만큼 깍는 공사 가능
 *
 * 1. 가장 높은 좌표 셀렉
 *
 * 2. 같거나 크면  -k 해주고 flag 설정
 * -  k해서 들어갈수있으면 다음 arr값은 현좌표 -1값만 해주기(최대 효율)
 *
 * 3. 작을떈 기본 이동
 *
 * */
