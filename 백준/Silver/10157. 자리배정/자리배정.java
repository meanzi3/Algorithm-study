import java.io.*;
import java.util.*;

public class Main {
	
	private static int C, R; // 공연장의 크기
	private static int K; // 어떤 관객의 대기번호
	
	// 상, 우, 하, 좌
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	private static int[][] map;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(br.readLine());
		
		if(K > R * C) { // 좌석을 배정할 수 없는 경우
			bw.write(0 + "\n");
		} else {
			map = new int[R][C];
			
			int r = R - 1;
			int c = 0;
			
			int num = 1; // 현재 대기번호
			
			int dir = 0; // 현재 진행 방향
			
			map[r][c] = num; // 1번부터
			
			// 좌석 배정 시작
			while(num < K) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				// 다음 이동할 좌표가 유효한 범위 내에 있고, 아직 배정되지 않은 좌석인지 확인
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 0) {
					r = nr;
					c = nc;
					num++;
					map[nr][nc] = num;
				} else {
					// 방향 변경
					dir = (dir + 1) % 4;
				}
			}
			
			bw.write((c + 1) + " " + (R - r) + "\n");	
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
