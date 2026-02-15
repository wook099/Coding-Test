import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][]arr;
    static int cnt;
    static int N;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N =Integer.parseInt(br.readLine());

        arr=new int[N][N];
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0;i<N;i++){
            String str= br.readLine();
            for (int j=0;j<N;j++){
                arr[i][j]=str.charAt(j)-'0';
            }
        }

        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){

                if(arr[i][j]==1){
                    cnt=0;
                    dfs(i,j);

                    result.add(cnt);
                }
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for (int a: result){
            System.out.println(a);
        }
    }

    static void dfs(int x, int y){

        cnt++;
        arr[x][y]=0;

        for (int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx>=N||ny>=N||nx<0||ny<0)
                continue;

            if (arr[nx][ny]==1){
                dfs(nx,ny);
            }

        }

    }
}
