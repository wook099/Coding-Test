import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[] team;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        team = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    static void dfs(int idx,int depth){

        if (depth==N/2){
            cal();
            return;
        }

        if (idx==N){
            return;
        }

//        team[idx]=true;
//        dfs(idx+1,depth+1);
//        team[idx]=false;
//        dfs(idx+1,depth);
        for (int i=idx;i<N;i++){
            team[i]=true;
            dfs(i+1,depth+1);
            team[i]=false;
        }

    }

    static void cal(){

        int start=0;
        int link=0;
        for(int i=0;i<N-1;i++){
            for (int j=i+1;j<N;j++){
                if(team[i]&& team[j]) {
                    start +=(arr[i][j] + arr[j][i]);
                }else if(!team[i]&& !team[j]) {
                    link +=(arr[i][j] + arr[j][i]);
                }
            }
        }

        int result = Math.abs(start-link);
        min=Math.min(result,min);
    }




}