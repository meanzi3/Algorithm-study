import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		/**
		 * dp[n][k][visited]
		 * n은 길이, k는 올 수 있는 숫자, visited는 올 수 있는 숫자를 마킹할 마스킹비트
		 */
		
		long[][][] dp = new long[N+1][10][1<<10];
		
		// 계단 수는 0으로 시작할 수 없으므로, 1~9에 해당하는 비트를 마스킹
		for(int i = 1; i < 10; i++) {
			dp[1][i][1<<i] = 1;	
		}
		
		int MOD = 1000000000;
		
		for(int i = 2; i <= N; i++) { // 자리 수 (2부터 N까지)
			for(int j = 0; j < 10; j++) { // 현재 숫자 (0~9)
				for(int k = 0; k<(1<<10); k++) { // 지금까지 등장한 숫자 마스크
					if(j == 0) // 현재 숫자가 0이면 이전 숫자는 1밖에 안됨
						dp[i][j][k | 1<<j] = (dp[i][j][k | 1<<j] + dp[i-1][j+1][k]) % MOD;
					else if(j ==9) // 현재 숫자가 9이면 이전 숫자는 8밖에 안됨
						dp[i][j][k | 1<<j] = (dp[i][j][k | 1<<j] + dp[i-1][j-1][k]) % MOD;
					else // 그 외에는 j-1, j+1에서 올 수 있음
						dp[i][j][k | 1<<j] = (dp[i][j][k | 1<<j] + dp[i-1][j-1][k] + dp[i-1][j+1][k]) % MOD;
				}
			}
		}
		
		long answer = 0;
		
		for(int i = 0; i <10; i++) {
			answer = (answer + dp[N][i][(1<<10)-1]) % MOD; // 0~9까지 모두 사용한 것만 카운트
		}
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
		
	}
}
