import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	
	private static int M, N; // 세로, 가로 길이
	private static int K; // 직사각형 개수
	private static int[][] map; // 직사각형이 그려진 맵
	private static int[][] rectangles; // 직사각형 정보
	private static boolean[][] visited; // 방문확인 배열
	private static List<Integer> answerList; // 넓이 저장 리스트
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, 1, -1};
	
	public static void main(String args[]) throws Exception
	{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		
		rectangles = new int [K][4];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++) {
				rectangles[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < K; i++) {
			for(int j = (M - rectangles[i][3]); j < (M - rectangles[i][1]); j++){
				for(int k = rectangles[i][0]; k < rectangles[i][2]; k++) {
					map[j][k] = 1; // 직사각형이 있는 부분은 맵에서 1로 채워줌
				}
			}
		}
		
		visited = new boolean[M][N];
		
		answerList = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 0 && !visited[i][j]) {
					// bfs 탐색
					bfs(i, j);
				}
			}
		}
		
		Collections.sort(answerList); // 오름차순 정렬
		
		bw.write(answerList.size() + "\n"); // 영역 개수 출력
		
		for(int size : answerList) {
			bw.write(size + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		
		visited[r][c] = true;
		q.offer(new int[] {r, c});
		int size = 1;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			
			for(int i = 0; i < 4; i++) {
				int nr = tmp[0] + dr[i];
				int nc = tmp[1] + dc[i];
				
				// 범위, 방문, 빈칸 확인
				if(nr < 0 || nr >= M || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] != 0)
					continue;
				
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc});
				size++;
			}
			
		}
		
		
		// 정답 리스트에 해당 영역 넓이 추가
		answerList.add(size);
	}
}
