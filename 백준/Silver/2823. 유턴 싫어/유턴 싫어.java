import java.io.*;
import java.util.*;

public class Main {
	
	private static int R, C;
	private static char[][] map;
	
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i = 0; i < map.length; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// 아이디어: 막다른 길? 모든 길이 연결되어 있기 때문에 각 위치의 인접한 네 방향 중에서 길이 한 개 이하로 있다면 무조건 되돌아 와야 한다.
		// 네 방향 중에서 두 개 이상의 길이 필요하다.
		
		bw.write((checkDeadEnd() ? 1 : 0) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static boolean checkDeadEnd() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == '.') {
					// 길이라면 
					int path = 0;
					
					// 인접한 네 방향 확인
					for(int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						
						// 범위 확인, 길인지 확인
						if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == 'X')
							continue;
						
						path++;
					}
					
					// 연결된 길이 1개 이하라면 막다른 길로 판단
					if(path <= 1)
						return true;
				}
			}
		}
		
		return false;
	}
}
