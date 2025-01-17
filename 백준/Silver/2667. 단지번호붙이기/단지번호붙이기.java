import java.io.*;
import java.util.*;

public class Main {
	
	private static int N; // 지도의 크기
	private static int[][] map; // 지도
	private static boolean[][] visited; // 방문 확인 배열
	
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	private static int num = 0; // 단지 수
	private static ArrayList<Integer> list; // 단지 내의 집의 수 
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		String input;
		
		for(int i = 0; i < map.length; i++) {
			input = br.readLine();
			for(int j = 0; j < map[0].length; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		} // 지도 입력
		
		list = new ArrayList<>();
		
		// bfs 탐색
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					num++; // 단지 수 증가
					bfs(i, j);
				}
			}
		}
		
		// 오름차순 정렬
		Collections.sort(list);
		
		// 출력
		bw.write(num + "\n"); // 단지 수
		
		int size = list.size();
		
		for(int i = 0; i < size; i++) {
			bw.write(list.get(i) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>(); // [행 좌표, 열 좌표]
		q.offer(new int[] {r, c});
		visited[r][c] = true;
		int houseNum = 1; // 단지 내 집의 수
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			int currR = temp[0];
			int currC = temp[1];
			
			// 4방향 탐색
			for(int i = 0; i < 4; i++) {
				int nr = currR + dr[i];
				int nc = currC + dc[i];
				
				// 범위, 방문 확인
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] != 1)	
					continue;
				
				q.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
				houseNum++;
			}
		}
		
		// 단지 내 집의 수를 list에 추가
		list.add(houseNum);
	}
}
