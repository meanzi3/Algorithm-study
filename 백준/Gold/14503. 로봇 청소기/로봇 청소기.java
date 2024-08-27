import java.io.*;
import java.util.*;

public class Main {
	
	private static int N;
	private static int M;
	private static int R, C, D;
	private static int[][] map;
	private static int cnt = 0;
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	public static void main(String args[]) throws Exception
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 로봇청소기 위치, 방향 저장
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 방의 상태 저장
		
		dfs(R, C, D);
		
		bw.write(cnt + "\n");
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	private static void dfs(int r, int c, int d) {
		// 현재 칸 청소
		if(map[r][c] == 0) {
			map[r][c] = 2;
			cnt++;
		}
		
		// 주변 4칸 중 청소할 칸이 있다면
		for(int i = 0; i < 4; i++) {
			// 방향 반시계방향 90도 회전
			d = (d+3) % 4;
			
			// 이동할 칸
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 범위 확인
			if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
				// 청소되지 않은 칸인지 확인
				if(map[nr][nc] == 0) {
					dfs(nr, nc, d);
					return;
				}
			}
		}
		
		// 없다면
		int dir = (d + 2) % 4; // 후진
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		
		// 범위, 벽 확인
		if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 1) {
			// 바라보는 방향은 유지, 후진
			dfs(nr, nc, d);
		}
	}
}