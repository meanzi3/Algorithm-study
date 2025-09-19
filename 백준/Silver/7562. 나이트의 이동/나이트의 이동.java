import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	
	private static int l;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] start;
	private static int[] end;
	private static int[] dr = {-1, -2, -1, -2, 1, 2, 1, 2};
	private static int[] dc = {2, 1, -2, -1, 2, 1, -2, -1};
	
	public static void main(String args[]) throws Exception
	{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		
		StringTokenizer st;
		
		for(int i = 0; i < t; i++) {
			l = Integer.parseInt(br.readLine()); // 체스판의 한 변의 길이
			
			map = new int[l][l]; // 맵 배열
			visited = new boolean[l][l]; // 방문 확인 배열
			
			start = new int[2]; // 나이트가 현재 있는 칸
			end = new int[2]; // 나이트가 이동하려고 하는 칸
			
			st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			end[0] = Integer.parseInt(st.nextToken());
			end[1] = Integer.parseInt(st.nextToken());
			
			bfs();
			
			bw.write(map[end[0]][end[1]] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		
		visited[start[0]][start[1]] = true;
		q.offer(new int[] {start[0], start[1]});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int i = 0; i < 8; i++) {
				int nr = tmp[0] + dr[i];
				int nc = tmp[1] + dc[i];
				
				// 범위, 방문 확인
				if(nr < 0  || nr >= l || nc < 0 || nc >= l || visited[nr][nc])
					continue;
				
				visited[nr][nc] = true;
				map[nr][nc] = map[tmp[0]][tmp[1]] + 1; // 거리 + 1
				q.offer(new int[] {nr, nc});
			}
		}
	}
}
