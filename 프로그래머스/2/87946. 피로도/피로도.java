class Solution {
    static boolean visited[];
    static int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        
        // 던전을 방문했는지 체크 배열
        visited = new boolean[dungeons.length];
        
        // dfs(던전 배열, 현재 피로도, 통과한 던전 수) 
        dfs(dungeons, k, 0);
        
        return answer;
    }
    
    public void dfs(int[][] dungeons, int k, int n){
        for(int i = 0; i < dungeons.length; i++){
            // 방문했던 던전이거나, 현재 피로도가 모자라면
            if(visited[i] || k < dungeons[i][0]) continue;
            
            // 방문했을 때
            visited[i] = true;
            dfs(dungeons, k - dungeons[i][1], n+1);
            // 방문안했을 때
            visited[i] = false;
        }
        
        answer = Math.max(answer, n);
    }
}