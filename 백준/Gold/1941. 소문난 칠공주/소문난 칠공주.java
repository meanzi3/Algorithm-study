import java.io.*;
import java.util.*;

public class Main {
	
	private static char[][] students;
	
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	private static boolean[] visited;
	private static int[] selected;
	
	private static int answer = 0;
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		students = new char[5][5];
		
		for(int i = 0; i < 5; i++) {
			students[i] = br.readLine().toCharArray();
		} // 입력값 저장
		
		selected = new int[7];
		
		// 백트래킹으로 7명 조합 만듦
		dfs(0, 0, 0);
		
		// 출력
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	private static void dfs(int depth, int numY, int start) {
		// 종료 조건
		if(numY >= 4)	return;
		
		if(depth == 7) {
			visited = new boolean[7];
			bfs();
			return;
		}
		
		for(int i = start; i < 25; i++) {
			selected[depth] = i;
			
			if(students[i/5][i%5] == 'Y') { // 임도연파일 때
				dfs(depth + 1, numY + 1, i + 1);
			} else { // 임도연파가 아닐 때
				dfs(depth + 1, numY, i + 1);
			}
			
			selected[depth] = 0;
		}
	}
	
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {selected[0] / 5, selected[0] % 5}); // 학생의 위치 (행, 열) 저장
		visited[0] = true;
		
		int cnt = 1; // 인접한 개수
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				int ni = nr * 5 + nc; // 다음 인덱스
				
				// 범위 확인
				if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5)	continue;
				
				for(int j = 0; j < 7; j++) {
					if(!visited[j] && selected[j] == ni) {
						q.offer(new int[] {nr, nc});
						visited[j] = true;
						cnt++;
					}
				}
			}
		}
		
		if(cnt == 7) answer++;
	}
}
