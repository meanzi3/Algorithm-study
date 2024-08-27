import java.util.*;

class Solution {
    
    private List<List<Integer>> adjList;
    private boolean[] visited;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        adjList = new ArrayList<>();
        visited = new boolean[n + 1];
        
        // 인접 리스트로 표현
        for(int i = 0; i <= n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] vertex : edge){
            adjList.get(vertex[0]).add(vertex[1]);
            adjList.get(vertex[1]).add(vertex[0]);
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
                for(int neighbor : adjList.get(tmp)){
                    if(!visited[neighbor]){
                        q.offer(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
        }
        
        return size;
    }
}