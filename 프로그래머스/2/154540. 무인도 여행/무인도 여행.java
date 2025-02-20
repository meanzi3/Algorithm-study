import java.util.*;

class Solution {
    
    private static int[][] map;
    
    private static boolean[][] visited;
    
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};
    
    private static int day = 0;
    
    public int[] solution(String[] maps) {
        List<Integer> answerList = new ArrayList<>(); // 정답 리스트
        
        map = new int[maps.length][maps[0].length()];
        
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(maps[i].charAt(j) == 'X'){
                    map[i][j] = 0;
                } else {
                    map[i][j] = maps[i].charAt(j) - '0';
                }
            }
        }
        
        visited = new boolean[map.length][map[0].length];
        
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(!visited[i][j] && map[i][j] != 0){
                    // dfs로 섬 탐색
                    dfs(i, j);
                    answerList.add(day);
                    day = 0;
                }
            }
        }
        
        int[] answer;
        int size = answerList.size();
        
        if(size == 0){
            // 무인도가 없으면
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = answerList.stream().mapToInt(i -> i).toArray();
            Arrays.sort(answer);
        }
        
        return answer;
    }
    
    private static void dfs(int r, int c){
        visited[r][c] = true;
        day += map[r][c];
        
        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            // 범위, 방문, 무인도인지 확인
            if(nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length || visited[nr][nc] || map[nr][nc] == 0)  continue;
            
            dfs(nr, nc);
        }
        
    }
}