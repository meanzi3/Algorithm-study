import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] schedule = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			schedule[i][0] = Integer.parseInt(st.nextToken());
			schedule[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+1]; // dp[i]는 i일까지 가능한 최대 이익
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			
			// 스킵 전이
			dp[i+1] = Math.max(dp[i+1], dp[i]);
			
			int next = i + schedule[i][0]; // 해당 상담이 끝나는 날
			
			// 범위 넘는지 확인
			if(next <= N) {
				dp[next] = Math.max(dp[next], dp[i] + schedule[i][1]); // 수행 전이
			}
		}
		
		bw.write(dp[N] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
