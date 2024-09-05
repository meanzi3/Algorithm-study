import java.io.*;
import java.util.*;

public class Main {
	
	private static int N, M;
	private static int[][] map;
	private static boolean[][] visited;
	
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < map.length; i++) {
			String inputs = br.readLine();
			for(int j = 0; j < map[0].length; j++) {
				map[i][j] = inputs.charAt(j) - '0';
			}
		} // 미로 저장
		
		visited = new boolean[N][M];
		
		int answer = bfs();
		
		bw.write(answer + "\n");
		
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	private static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		
		// (1,1) 부터 출발
		q.offer(new int[] {0, 0, 1});
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			int r = tmp[0];
			int c = tmp[1];
			int d = tmp[2];
			
			// 도착했다면
			if((r == N - 1) && (c == M - 1)) {
				return d;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				// 범위, 방문 확인
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
				
				// 이동할 수 있는 칸인지 확인
				if(map[nr][nc] == 0) continue;
				
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc, d + 1});
			}
		}
		
		return -1;
		
	}
}
