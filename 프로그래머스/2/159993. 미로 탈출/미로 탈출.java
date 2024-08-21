import java.util.*;

class Solution {
    
    private static int[] dr = {1, 0, -1, 0};
    private static int[] dc = {0, 1, 0, -1};
    private static int n;
    private static int m;
    private static char[][] map;
    
    public int solution(String[] maps) {
        int answer = -1;
        
        n = maps.length; // 행 갯수
        m = maps[0].length(); // 열 갯수
        
        int[] start = new int[2]; // 시작 지점
        int[] lever = new int[2]; // 레버
        int[] end = new int[2]; // 출구
        
        // 각각 위치 저장
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(maps[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
                if(maps[i].charAt(j) == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                }
                if(maps[i].charAt(j) == 'E'){
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        
        // 시작 지점에서 레버 까지
        int startToLever = bfs(maps, start, lever);
        
        // 레버에서 출구 까지
        int leverToEnd = bfs(maps, lever, end);
        
        if(startToLever != -1 && leverToEnd != -1){
            answer = startToLever + leverToEnd;
        }
        
        return answer;
    }
    
    private static int bfs(String[] maps, int[] from, int[] to){
        Queue<int[]> q = new LinkedList<int[]>();
        
        boolean[][] visited = new boolean[n][m];
        
        int row = from[0];
        int col = from[1];
        
        // 시작 위치 지정
        visited[row][col] = true;
        q.offer(new int[] {row, col, 0});
        
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int cr = tmp[0];
            int cc = tmp[1];
            int dir = tmp[2];
            
            // 도착 했을 시
            if(cr == to[0] && cc == to[1]){
                return dir;
            }
            
            for(int i = 0; i < 4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                // 범위, 방문 확인
                if(nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc]) continue;
                
                // 벽 확인
                if(maps[nr].charAt(nc) == 'X') continue;
                
                // 방문처리
                visited[nr][nc] = true;
                
                // 큐에 추가
                q.offer(new int[] {nr, nc, dir + 1});
                
            }
        }
        
        return -1;
    }
}