import java.util.*;
import java.io.*;


public class Main {
	
	private static int w, h;
	private static int[][] map;
	private static boolean[][] visited;
	
	private static int dr[] = {0, 1, 0, -1, 1, -1, 1, -1};
	private static int dc[] = {1, 0, -1, 0, -1, 1, 1, -1};
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			// 입력 마지막 줄
			if(w == 0 && h == 0) {
				break;
			}
			
			map = new int[h][w];
			visited = new boolean[h][w];
			
			for(int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < map[0].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 섬 개수
			int islandCnt = 0;
			
			// (0, 0)부터 섬 확인
			for(int i = 0; i < map.length; i++) {
				for(int j = 0; j < map[0].length; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						
						// dfs를 이용해서 연결되는 땅 확인
						visited[i][j] = true;
						dfs(i, j);
						
						// 섬 개수 증가
						islandCnt++;
					}
				}
			}
			
			// 테스트 케이스마다 섬의 개수 출력
			bw.write(islandCnt + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void dfs(int r, int c) {
		// 8방향 탐색 (연결된 땅이 있는지 확인)
		for(int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			// 범위 확인
			if(nr < 0 || nr >= h || nc < 0 || nc >= w)	continue;
			
			// 땅인지, 방문했는지 확인
			if(map[nr][nc] == 0 || visited[nr][nc])	continue;
			
			visited[nr][nc] = true;
			dfs(nr, nc);
			
		}
	}
}
