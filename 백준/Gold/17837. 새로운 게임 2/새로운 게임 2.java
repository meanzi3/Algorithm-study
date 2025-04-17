import java.io.*;
import java.util.*;

public class Main {
	
	private static int N;
	private static int K;
	private static int[][] board; // 0은 흰색, 1은 빨간색, 2는 파란색
	private static int[][] players; // [말이 위치한 행, 열, 이동 방향(오른쪽, 왼쪽, 위, 아래 (1~4))]
	private static List<Integer>[][] list; // 게임판에 위치한 말의 번호 표시
	
	private static int[] dr = {0, 0, -1, 1}; // 오른쪽, 왼쪽, 위, 아래
	private static int[] dc = {1, -1, 0, 0};
	
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new int[N+1][N+1];
		list = new ArrayList[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				list[i][j] = new ArrayList<>();
			}
		}
		
		players = new int[K+1][3];
		
		for(int i = 1; i <= K; i++) { // 1~K번째 말
			st = new StringTokenizer(br.readLine(), " ");
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			players[i] = new int[] {r, c, d};
			list[r][c].add(i);
		}
		
		int cnt = 0;
		while(cnt < 1000) { // 1000 초과 시 종료
			cnt++;
			
			// K개의 말 이동
			for(int i = 1; i <= K; i++) {
				
				int r = players[i][0];
				int c = players[i][1];
				int d = players[i][2];
				
				int nr = r + dr[d-1];
				int nc = c + dc[d-1];
				
				// 범위 확인
				if(nr >= 1 && nr <= N && nc >= 1 && nc <= N) {
					if(board[nr][nc] == 0) {
						// 흰색 이면 => 그 칸으로 이동하고, 이동하려는 칸에 말이 이미 있다면 가장 위에 그 말을 올려 놓는다.
						// 해당 말 위에 다른 말이 있는 경우, 해당 말과 그 위에 있는 모든 말이 이동한다. 
						
						int index = list[r][c].indexOf(i); // 현재 말이 밑에서 몇 번째에 있는지
						
						list[nr][nc].addAll(list[r][c].subList(index, list[r][c].size())); // 현재 말과 위에 있는 모든 말을 이동
						
						list[r][c] = new ArrayList<>(list[r][c].subList(0, index)); // 나머지는 그대로 원래 있던 위치에
						
						// 현재 위치 갱신
						for(Integer p : list[nr][nc]) {
							players[p][0] = nr;
							players[p][1] = nc;
						}
					} else if(board[nr][nc] == 1) {
						// 빨간색 이면 => 이동한 후에 해당 말과 그 위에 있는 모든 말의 쌓여 있는 순서를 바꾼다.
						
						int index = list[r][c].indexOf(i);
						
						List<Integer> subList = list[r][c].subList(index, list[r][c].size());
						Collections.reverse(subList); // 순서 바꾸기
						
						list[nr][nc].addAll(subList); // 가장 위에 순서 바꾼 말들 올리기
						
						list[r][c] = new ArrayList<>(list[r][c].subList(0, index)); // 나머지는 그대로
						
						// 현재 위치 갱신
						for(Integer p : list[nr][nc]) {
							players[p][0] = nr;
							players[p][1] = nc;
						}
					} else if(board[nr][nc] == 2) {
						// 파란색 이면 => 이동 방향을 반대로 하고 한 칸 이동한다.
						// 방향을 바꾸고 난 후 이동하려는 칸이 파란색이라면 이동하지 않는다.
						
						int nd; // 새로운 방향 설정
						if(d % 2 == 0) {
							nd = d - 1;
						} else {
							nd = d + 1;
						}
						players[i][2] = nd;
						
						if(r + dr[nd-1] < 1 || r + dr[nd-1] >= N+1 || c + dc[nd-1] < 1 || c + dc[nd-1] >= N+1) {
							continue;  // 이동하려는 칸이 범위를 벗어나면 이동하지 않음
						}
						
						if(board[r + dr[nd-1]][c + dc[nd-1]]!= 2) {
							i--; // 이동하도록
						}
					}
					
					// 4개 이상 쌓이면 종료
					if(list[nr][nc].size() >= 4) {
						bw.write(cnt + "\n");
						bw.flush();
						bw.close();
						br.close();
						return;
					}
				}else {
					// 체스판을 벗어나는 경우 => 파란색과 마찬가지로 이동 방향 반대로 하고 한 칸 이동한다.
					// 방향을 바꾸고 난 후 이동하려는 칸이 파란색이라면 이동하지 않는다. 
					int nd; // 새로운 방향 설정
					if(d % 2 == 0) {
						nd = d - 1;
					} else {
						nd = d + 1;
					}
					players[i][2] = nd;
					
					if(board[r + dr[nd-1]][c + dc[nd-1]]!= 2) {
						i--; // 이동하도록
					}
				}
			}
		}
		
		bw.write(-1 + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
