import java.io.*;
import java.util.*;

public class Main {
	
	private static int N;
	private static char[][] painting;
	
	private static boolean[][] visited;
	
	private static int[] dr = {1, 0, -1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		painting = new char[N][N];
		
		for(int i = 0; i < painting.length; i++) {
			painting[i] = br.readLine().toCharArray();
		}
		
		// 적록 색약이 아닌 사람
		int cnt = 0;
		visited = new boolean[N][N];
		
		for(int i = 0; i < painting.length; i++) {
			for(int j = 0; j < painting[0].length; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					dfs(i, j);
					cnt++;
				}
				// 적록 색약이 사람의 탐색을 위해 R을 G로 바꿔줌
				if(painting[i][j] == 'R')
					painting[i][j] = 'G';
			}
		}
		
		bw.write(cnt + " "); // 출력
		
		// 적록 색약인 사람
		cnt = 0;
		visited = new boolean[N][N];
		
		for(int i = 0; i < painting.length; i++) {
			for(int j = 0; j < painting[0].length; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					dfs(i, j);
					cnt++;
				}
			}
		}
		
		bw.write(cnt + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void dfs(int r, int c) {
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			// 범위 확인
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			
			// 방문 확인, 같은 구역인지 확인
			if(visited[nr][nc] || painting[r][c] != painting[nr][nc]) continue;
			
			visited[nr][nc] = true;
			dfs(nr, nc);
		}
	}
}
