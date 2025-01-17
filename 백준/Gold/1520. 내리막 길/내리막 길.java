import java.io.*;
import java.util.*;

public class Main {
	
	private static int M, N; // 세로의 크기, 가로의 크기
	private static int[][] map;
	private static int[][] dp;
	
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		dp = new int[M][N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		int answer = dfs(0, 0);
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	
	}
	
	private static int dfs(int r, int c) {
		
		// 종료 조건
		if(r == M-1 && c == N-1) {
			return 1;
		}
		
		// 방문한 적 없으면 
		if(dp[r][c] == -1) {
			dp[r][c] = 0;
			
			// 4방향 탐색
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				// 범위 확인
				if(nr < 0 || nr >= M || nc < 0 || nc >= N)
					continue;
				
				// 내리막인지 확인
				if(map[r][c] <= map[nr][nc])
					continue;
				
				dp[r][c] += dfs(nr, nc);
			}
		}
		
		return dp[r][c];
	}

}
