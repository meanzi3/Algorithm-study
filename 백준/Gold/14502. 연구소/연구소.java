import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	
	private static int N;
	private static int M;
	private static int[][] map;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, 1, -1};
	private static int max = Integer.MIN_VALUE;
	
	public static void main(String args[]) throws Exception
	{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// dfs -> 벽 3개를 세운다
		dfs(0);
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	private static void dfs(int depth) {
		// 벽 3개 설치 후에 bfs 탐색
		if(depth == 3) {
			bfs();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(depth+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	private static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 2) {
					q.add(new int[] {i, j});
				}
			}
		}
		
		// 원래 맵 복사
		int[][] copyMap = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			copyMap[i] = map[i].clone();
		}
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				// 범위, 빈칸 확인
				if(nr >= N || nc >= M || nr < 0 || nc < 0 || copyMap[nr][nc] != 0)
					continue;
				
				q.add(new int[] {nr, nc});
				copyMap[nr][nc] = 2;
			}
		}
		
		// 안전 영역 크기 구하기
		getSafeCnt(copyMap);
		
	}
	
	private static void getSafeCnt(int[][] copyMap) {
		int safeCnt = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(copyMap[i][j] == 0) {
					safeCnt++;
				}
			}
		}
		
		max = Math.max(max, safeCnt);
	}
}
