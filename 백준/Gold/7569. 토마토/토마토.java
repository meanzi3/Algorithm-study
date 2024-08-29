import java.io.*;
import java.util.*;

public class Main {
	
	private static int M, N, H;
	private static int[][][] box;
	
	// 6방향
	private static int[] dr = {-1, 0, 1, 0, 0, 0};
	private static int[] dc = {0, 1, 0, -1, 0, 0};
	private static int[] dh = {0, 0, 0, 0, -1, 1}; 
	
	private static int zeroCnt; // 안 익은 토마토 갯수
	
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		
		box = new int[H][N][M];
		
		Queue<int[]> q = new LinkedList<>(); 
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int k = 0; k < M; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if(box[i][j][k] == 1) {
						// 익은 토마토라면 
						q.offer(new int[] {i, j, k});
					}
					if(box[i][j][k] == 0) {
						// 안 익은 토마토라면
						zeroCnt++;
					}
				}
			}
		}
		
		int day = 0;
				
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				int[] tmp = q.poll();
				
				int h = tmp[0];
				int r = tmp[1];
				int c = tmp[2];
				
				for(int j = 0; j < 6; j++) {
					int nh = h + dh[j];
					int nr = r + dr[j];
					int nc = c + dc[j];
					
					// 범위 확인
					if(nh < 0 || nh >= H || nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					
					// 이미 익은 토마토이거나 빈 칸인지 확인
					if(box[nh][nr][nc] != 0) continue;
					
					// 토마토가 익음
					zeroCnt--;
					box[nh][nr][nc] = 1;
					q.offer(new int[] {nh, nr, nc});
					
				}
			}
			
			day++;
			
		}
		
		if(zeroCnt != 0) {
			bw.write(-1 + "\n");
		} else {
			bw.write((day - 1) + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}
}