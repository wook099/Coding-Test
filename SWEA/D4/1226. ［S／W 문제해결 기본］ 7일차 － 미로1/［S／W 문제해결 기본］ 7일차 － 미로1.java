import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static int min;
    static int[][] arr;
    static boolean[][] visited;
    static boolean flag;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for (int tc = 1; tc <= 10; tc++) {
String tcNum = br.readLine(); 
    if (tcNum == null) break;
            arr = new int[16][16];
            visited=new boolean[16][16];
            min = Integer.MAX_VALUE;

            for (int i = 0; i < 16; i++) {
                String s = br.readLine();
                for (int j = 0; j < 16; j++) {
                    arr[i][j] = s.charAt(j)-'0';
                }
            }
            flag = false;
            visited[1][1]=true;
            bfs(1,1);

            if(flag){
                System.out.println("#"+tc+" "+"1");
            }else
                System.out.println("#"+tc+" "+"0");

        }
    }

    static void bfs(int x,int y){

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int curx=cur[0];
            int cury=cur[1];
            if(arr[curx][cury]==3){
                flag=true;
                return;
            }

            for(int i=0;i<4;i++){
                int nx=curx+dx[i];
                int ny=cury+dy[i];


                if (nx < 0 || nx >= 16 || ny < 0 || ny >= 16 || visited[nx][ny]||arr[nx][ny]==1)
                    continue;

                visited[nx][ny]=true;
                q.add(new int[]{nx,ny});
            }

        }

    }
}