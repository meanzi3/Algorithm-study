import java.io.*;
import java.util.*;

public class Main {
	
	private static int N, M; // 지도의 세로, 가로 크기
	private static int x, y; // 주사위를 놓은 곳의 좌표
	private static int K; // 명령의 개수
	
	//   2
	// 4 1 3
	//   5
	//   6
	private static int[] dice; // 주사위 정보
	
	private static int[][] map; // N X M 크기의 지도
	
	private static int[] dr = {0, 0, -1, 1}; // 동, 서, 북, 남
	private static int[] dc = {1, -1, 0, 0};

	
	public static void main(String args[]) throws Exception{
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dice = new int[7];
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1- 동쪽, 2- 서쪽, 3- 북쪽, 4- 남쪽
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < K; i++) {
			int d = Integer.parseInt(st.nextToken());
			int output = roll(d); // 명령에 따라 주사위 굴림
			
			if(output != -1) {
				bw.write(output + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	private static int roll(int d) throws Exception{
		// 다음 주사위 위치
		int nx = x + dr[d-1];
		int ny = y + dc[d-1];
		
		// 범위 확인
		if(nx < 0 || nx >= N || ny < 0 || ny >= M)	return -1; // 출력 X
		
		// 주사위 굴림
		int top = dice[1]; // 윗면
		switch(d) {
		case 1:
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = top;
			break;
		case 2:
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = top;
			break;
		case 3:
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[2];
			dice[2] = top;
			break;
		case 4:
			dice[1] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[5];
			dice[5] = top;
			break;
		}
		
		// 이동한 칸에 쓰여있는 수가 0이면, 주사위 바닥면에 쓰여있는 수가 칸에 복사
		if(map[nx][ny] == 0) {
			map[nx][ny] = dice[6];
		} else {
			// 0이 아니면, 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사, 칸에 쓰여 있는 수는 0
			dice[6] = map[nx][ny];
			map[nx][ny] = 0;
		}
		
		x = nx;
		y = ny;
		
		return dice[1];
	}
}
