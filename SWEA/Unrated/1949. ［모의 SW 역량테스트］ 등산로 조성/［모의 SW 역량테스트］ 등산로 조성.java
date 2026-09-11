
import java.io.BufferedReader;
import java.util.*;
import java.io.InputStreamReader;

public class Solution {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    static int K;
    static int[][] arr;
    static List<int[]> cores;
    static int maxLen;
    static boolean[][] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            cores = new ArrayList<>();
            int max = 0;
            arr = new int[N][N];
            visited = new boolean[N][N];
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] > max) {
                        max = arr[i][j];
                    }
                }
            }
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == max) {
                        cores.add(new int[] {i, j});
                    }
                }
            }
            
            // 테스트 케이스마다 maxLen 초기화
            maxLen = 0;
            
            for (int i = 0; i < cores.size(); i++) {
            	
                int[] cur = cores.get(i);
                int curx = cur[0];
                int cury = cur[1];
                
                visited[curx][cury] = true;
                dfs(curx, cury, 1, false); // 시작 길이 1부터 시작
                visited[curx][cury] = false;
            }
            
            System.out.println("#" + t + " " + maxLen);
        }
    }
    
    /*
     * dfs
     * 4방향으로 갈건데 
     * 방문체크하면서 더 작은수일때만 갈거임
     * if 더 클땐 -k빼서 갈수있으면 방문체크하면서 진행 해당 부분에서 flag 전환하고 백트래킹 필요
     * 
     * 하나갈떄마다 maxlen 저장 
     * */
    
    static void dfs(int x,int y,int len,boolean flag) {
    	
    
    	for(int d=0;d<4;d++) {
    		
    		int nx=x;
    		int ny=y;
    		nx+=dx[d];
    		ny+=dy[d];
    		
    		if(nx<0||ny<0||nx>=N||ny>=N||visited[nx][ny])
    			continue;
    		
    		if(arr[nx][ny]<arr[x][y]) {//정상 실행
    			
    			visited[nx][ny]=true;
    			dfs(nx,ny,len+1,flag);
    			visited[nx][ny]=false;
    		}else {
    			if(arr[nx][ny]-K<arr[x][y]&&!flag) {//k만큼 뺏을때 더 작아진다면
    				
    				int original=arr[nx][ny];
    				arr[nx][ny]=arr[x][y]-1;//이전꺼보다 1작은걸 넣어 왜냐면 이게 고점이 높으니까
    				visited[nx][ny]=true;
    				
    				dfs(nx,ny,len+1,true);
    				visited[nx][ny]=false;
    				arr[nx][ny]=original;			
    			}
    		}
    		
    	}
    	
    	maxLen=Math.max(maxLen, len);
    	
    }
}