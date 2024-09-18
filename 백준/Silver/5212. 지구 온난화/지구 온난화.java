import java.io.*;
import java.util.*;

public class Main {
	
	private static int R, C; // 지도의 ㅋ크기 
	private static char[][] map; // 지도
	
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	private static Queue<int[]> q; // 가라앉는 땅을 저장할 큐
	
	// 정답 지도를 그릴 범위
	private static int rowMin;
	private static int rowMax;
	private static int colMin;
	private static int colMax;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i = 0; i < map.length; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		q = new LinkedList<>();
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				// 땅이라면 3면이 바다인지 확인
				if(map[i][j] == 'X') {
					
					int cnt = 0;
					
					for(int k = 0; k < 4; k ++) {
						
						int nr = i + dr[k];
						int nc = j + dc[k];
						
						// 범위 밖은 바다
						if(nr < 0 || nr >= R || nc < 0 || nc >= C) {
							cnt++;
							continue;
						}
						
						// 바다인지 확인
						if(map[nr][nc] == '.') {
							cnt++;
						}
					}
					
					if(cnt >= 3) {
						q.offer(new int[] {i, j});
					}
				}
			}
		}
		
		// 가라앉을 땅을 표시
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			map[tmp[0]][tmp[1]] = '.';
		}
		
		rowMin = R;
		rowMax = 0;
		colMin = C;
		colMax = 0;
		
		// 정답 지도 범위 정하기
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == 'X') { // 당이라면
					rowMin = Math.min(rowMin, i);
					rowMax = Math.max(rowMax, i);
					colMin = Math.min(colMin, j);
					colMax = Math.max(colMax, j);
				}
			}
		}
		
		// 정답 지도를 그리기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();
		
		for(int i = rowMin; i <= rowMax; i++) {
			for(int j = colMin; j <= colMax; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
