import java.util.*;

class Solution {
    
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};
    
    private static int n;
    private static int m;
    
    private static boolean[][] visited;
    private static int answer = -1;
    
    public int solution(int[][] maps) {
        
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        answer = bfs(maps);
        
        return answer;
    }
    
    private static int bfs(int[][] maps){
        
        Queue<int[]> q = new LinkedList<int[]>();
        
        visited[0][0] = true;
        q.offer(new int[] {0, 0, 1});
        
        while(!q.isEmpty()) {
            int tmp[] = q.poll();
            int r = tmp[0];
            int c = tmp[1];
            int count = tmp[2];
            
            if(r == n-1 && c == m-1){
                answer = count;
                break;
            }
            
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                // 범위, 방문 여부 확인
                if(nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc])
                    continue;
                
                // 길인지 확인
                if(maps[nr][nc] == 0)
                    continue;
                
                visited[nr][nc] = true;
                q.offer(new int[] {nr, nc, count + 1});
            } 
        }
        
        return answer;
    }
}