import java.util.*;

class Solution {
    
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1}; // 하, 우, 상, 좌
    private static int N;
    private static int M;
    
    private static boolean[][] visited;
    
    public int solution(String[] board) {
        int answer = -1;
        
        N = board.length;
        M = board[0].length();
        
        visited = new boolean[N][M];
        
        int dir = 0; // 방향
        
        int startR = 0;
        int startC = 0;
        // 시작 위치 찾기
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i].charAt(j) == 'R'){
                    startR = i;
                    startC = j;
                    break;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[] {startR, startC, 0});
        
        while(!q.isEmpty()){
            
            int[] tmp = q.poll();
            int nowR = tmp[0];
            int nowC = tmp[1];
            int min = tmp[2];
            
            if(board[nowR].charAt(nowC) == 'G'){
                // 도착지점인지 확인
                answer = min;
                break;
            }
            
            // 4방향으로 이동
            for(int i = 0; i < 4; i++){
                int nextR = nowR + dr[i];
                int nextC = nowC + dc[i];
                
                while(true){ // 원하는 방향으로 끝까지 이동
                    if(nextR >= 0 && nextC >= 0 && nextR < N && nextC < M && board[nextR].charAt(nextC) != 'D'){
                        nextR += dr[i];
                        nextC += dc[i];
                    } else {
                        nextR -= dr[i];
                        nextC -= dc[i];
                        break;
                    }
                    
                }
                
                if(!visited[nextR][nextC]){
                    q.offer(new int[] {nextR, nextC, min + 1});
                    visited[nextR][nextC] = true;
                }
            }
        }
        
        
        return answer;
    }
}