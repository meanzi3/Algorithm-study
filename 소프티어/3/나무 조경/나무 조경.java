import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int[][] map;
    private static boolean[][] visited;
    private static int answer;
    private static final int[] dr = {0, 1};
    private static final int[] dc = {1, 0}; // 오른쪽, 아래쪽

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = sc.nextInt();
            }
        }

        visited = new boolean[n][n];
        answer = -1;

        // 만약에 하나를 기준으로 한다면 상하좌우 중 하나 더를 골라야 하는데 -> ㄴㄴ 오른쪽, 아래쪽만 봐도 됨
        // 2x2라면 최대 2쌍만 고를 수 있음. 3x3부터는 4쌍 고를 수 있음
        // dfs로 탐색
        if(n == 2){
            dfs(0, 0, 2);
        } else {
            dfs(0, 0, 4);
        }

        System.out.println(answer);
        
    }

    private static void dfs(int nowDepth, int sum, int depth){
        // 종료 조건
        if(nowDepth == depth){
            // 최댓값 갱신
            answer = Math.max(answer, sum);
            return;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j]) continue; // 방문 확인

                // 쌍 고르기
                for(int k = 0; k < 2; k++){
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    // 범위, 방문 확인
                    if(nr < 0 || nc < 0 || nr >= n || nc >= n || visited[nr][nc]) continue;

                    visited[i][j] = true;
                    visited[nr][nc] = true;

                    dfs(nowDepth + 1, sum + map[i][j] + map[nr][nc], depth);

                    // 백트래킹
                    visited[i][j] = false;
                    visited[nr][nc] = false;
                }
            }
        }
        
    }
}