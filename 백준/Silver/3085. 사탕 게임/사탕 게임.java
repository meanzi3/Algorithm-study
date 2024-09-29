import java.io.*;

public class Main {
	
	private static int N;
	private static char[][] candy;
	private static int max = Integer.MIN_VALUE;
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		candy = new char[N][N];
		
		for(int i = 0; i < candy.length; i++) {
			candy[i] = br.readLine().toCharArray();
		}
		
		// 아이디어 : 브루트포스로 가능한 경우로 모두 다 바꿔본다.
		// 모든 사탕마다 인접한 상하좌우에 있는 사탕이랑 바꾼다면 -> 중복되는 작업이 생김
		// 옆으로 가면서 오른쪽 사탕이랑 교환하기, 아래로 가면서 아래쪽 사탕이랑 교환하기
		
		// 행 별로 오른쪽으로 가면서 오른쪽 사탕이랑 교환하기
		for(int i = 0; i < candy.length; i++) {
			for(int j = 0; j < candy[0].length - 1; j++) {
				// 인접한 사탕 위치 바꾸기
				changeCandy(i, i, j, j + 1);
				
				// max 찾기
				getMax();
				
				// 바꾼 사탕 다시 되돌리기
				changeCandy(i, i, j + 1, j);
			}
		}
		
		// 열 별로 아래쪽으로 가면서 아래쪽 사탕이랑 교환하기
		for(int i = 0; i < candy[0].length; i++) {
			for(int j = 0; j < candy.length - 1; j++) {
				// 인접한 사탕 위치 바꾸기
				changeCandy(j, j + 1, i, i);
				
				// max 찾기
				getMax();
				
				// 바꾼 사탕 다시 되돌리기
				changeCandy(j + 1, j, i, i);
			}
		}
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	private static void changeCandy(int r1, int r2, int c1, int c2) {
		char tmp = candy[r1][c1];
		candy[r1][c1] = candy[r2][c2];
		candy[r2][c2] = tmp;
	}
	
	private static void getMax() {
		// 행 별 탐색
		for(int i = 0; i < candy.length; i++) {
			int cnt = 1;
			
			// 가장 긴 연속 부분 세기
			for(int j = 0; j < candy[0].length - 1; j++) {
				if(candy[i][j] == candy[i][j + 1]) {
					cnt++;
					max = Math.max(cnt, max);
				} else {
					cnt = 1;
				}
			}
		}
		
		// 열 별 탐색
		for(int i = 0; i < candy[0].length; i++) {
			int cnt = 1;
			
			// 가장 긴 연속 부분 세기
			for(int j = 0; j < candy.length - 1; j++) {
				if(candy[j][i] == candy[j + 1][i]) {
					cnt++;
					max = Math.max(cnt, max);
				} else {
					cnt = 1;
				}
			}
		}
	}
}
