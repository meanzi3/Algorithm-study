import java.io.*;
import java.util.*;

public class Main {
	
	private static int n, m;
	private static int[][] board;
	private static boolean[][] visited;
	private static int cnt;
	
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n][m];
		
		for(int i = 0; i < board.length; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < board[0].length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[n][m];
		List<Integer> answer = new ArrayList<>();
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				cnt = 0;
				if(board[i][j] == 1 && !visited[i][j]) {
					cnt++;
					bfs(i, j);
					
					// 그림의 크기 저장
					answer.add(cnt);
				}
				
			}
		}
		
		Collections.sort(answer);
		
		int size = answer.size();
		int max = 0;
		
		if(size > 0) {
			max = answer.get(size - 1);
		} 
		
		bw.write(size + "\n" + max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void bfs(int i, int j) {
		visited[i][j] = true;
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i, j});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			
			for(int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				
				// 범위, 1인지, 방문했는지 확인
				if(nr < 0 || nr >= n || nc < 0 || nc >= m || board[nr][nc] == 0 || visited[nr][nc])
					continue;
				
				cnt++;
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
	}
}
