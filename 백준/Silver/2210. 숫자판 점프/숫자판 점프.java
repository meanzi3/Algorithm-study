import java.io.*;
import java.util.*;

public class Main {
	
	private static int[][] map; // 숫자판
	
	private static Set<String> set; // 서로 다른 여섯 자리 수 저장 - set 이용 
	
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		map = new int[5][5];
		
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		set = new HashSet<>();
		
		// 모든 위치에서 시작
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				dfs(i, j, "" + map[i][j]);
			}
		}
		
		// set의 크기가 정답이 됨
		int answer = set.size();
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	private static void dfs(int r, int c, String nums) {
		// 6자리 수를 만들면 종료
		if(nums.length() == 6) {
			
			// 만든 수를 set에 추가
			set.add(nums);
			return;
		}
		
		// 네 방향 탐색
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			// 범위 확인
			if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
			
			// 다음 탐색
			dfs(nr, nc, nums + map[nr][nc]);
		}
	}
}
