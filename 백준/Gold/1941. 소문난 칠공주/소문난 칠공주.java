import java.io.*;
import java.util.*;

public class Main {
	
	private static char[][] students;
	
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	private static boolean[] visited;
	
	private static int answer = 0;
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		students = new char[5][5];
		
		for(int i = 0; i < 5; i++) {
			students[i] = br.readLine().toCharArray();
		} // 입력값 저장
		
		visited = new boolean[25];
		
		// 백트래킹으로 7명 조합 만듦
		dfs(0, 0, 0, new ArrayList<>());
		
		// 출력
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	private static void dfs(int depth, int numY, int start, List<Integer> selected) {
		// 종료 조건
		if(numY >= 4)	return;
		
		if(depth == 7) {
			if(bfs(selected)) {
				answer++;
			}
			return;
		}
		
		for(int i = start; i < 25; i++) {
			selected.add(i);
			visited[i] = true;
			
			if(students[i/5][i%5] == 'Y') { // 임도연파일 때
				dfs(depth + 1, numY + 1, i + 1, selected);
			} else { // 임도연파가 아닐 때
				dfs(depth + 1, numY, i + 1, selected);
			}
			
			selected.remove(selected.size() - 1);
			visited[i] = false;
		}
	}
	
	private static boolean bfs(List<Integer> selected) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] check = new boolean[7];
		q.offer(selected.get(0)); // 학생의 위치 (행, 열) 저장
		check[0] = true;
		
		int cnt = 1; // 인접한 개수
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			int r = temp / 5;
			int c = temp % 5;
			
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				int ni = nr * 5 + nc; // 다음 인덱스
				
				// 범위 확인
				if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || !selected.contains(ni))	continue;
				
				int idx = selected.indexOf(ni);
				if(!check[idx]) {
					check[idx] = true;
					q.offer(ni);
					cnt++;
				}
			}
		}
		
		return cnt == 7;
	}
}
