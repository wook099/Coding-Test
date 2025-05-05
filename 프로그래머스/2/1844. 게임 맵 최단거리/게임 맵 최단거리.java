import java.util.*;

class Solution {
    
    static int[] dx={1,0,-1,0};
    static int[] dy={0,-1,0,1};

    
   
    
    public int solution(int[][] maps) {
        
        return bfs(maps);
    }
    
    static int bfs(int[][] maps){
        int N=maps.length;
        int M=maps[0].length;
        
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new ArrayDeque<>();
        
        visited[0][0]=true;
        q.add(new int[]{0,0,1});
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            
            int a= cur[0];
            int b= cur[1];
            int dist=cur[2];
            
            if(a==N-1&&b==M-1){
                return dist;
            }
                
            for(int i=0;i<4;i++){
                int nx= a+dx[i];
                int ny= b+dy[i];
            
                
                
                if(nx<0||nx>=N||ny<0||ny>=M)
                    continue;

                if(maps[nx][ny]==1 && !visited[nx][ny]){
                    visited[nx][ny]=true;
                    q.add(new int[]{nx,ny,dist+1});
                    }
            }
        }
      return -1;                                 
}
    

}

    
                                       