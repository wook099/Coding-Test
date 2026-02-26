class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        // 이동 방향: 우(0,1), 하(1,0), 좌(0,-1), 상(-1,0)
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        int x = 0, y = 0, dir = 0; // 시작 위치와 초기 방향(우측)
        
        for (int i = 1; i <= n * n; i++) {
            answer[x][y] = i;
            
            // 다음 이동할 위치 미리 계산
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            // 1. 배열 범위를 벗어나거나 2. 이미 숫자가 채워진 경우 (0이 아닌 경우)
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || answer[nx][ny] != 0) {
                // 방향 전환 (0 -> 1 -> 2 -> 3 -> 0)
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            
            x = nx;
            y = ny;
        }
        
        return answer;
    }
}