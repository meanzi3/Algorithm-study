import java.util.*;

class Solution {
    
    private boolean[][] graphs;
    private boolean[] visited;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        graphs = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];
        
        // 인접 행렬로 표현
        for(int[] vertex : edge){
            graphs[vertex[0]][vertex[1]] = true;
            graphs[vertex[1]][vertex[0]] = true;
        }
        
        answer = bfs();
        
        return answer;
    }
    
    private int bfs(){
        Queue<Integer> q = new LinkedList<>();

        // 1부터 출발
        q.offer(1);
        visited[1] = true;
        
        int size = 0;

        while(!q.isEmpty()){
            size = q.size();
             
            for(int i = 0; i < size; i++){
                int tmp = q.poll();
                for(int j = 1; j < visited.length; j++){
                    if(!visited[j] && graphs[tmp][j]){
                        q.offer(j);
                        visited[j] = true;
                    }
                }
            }
        }
        
        return size;
    }
}