import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 테스트 케이스 수
		int t = Integer.parseInt(br.readLine());
		
		int MOD = 1000000007;
		
	    long[] dp = new long[5001];
	    dp[0] = dp[2] = 1;
	    
	    for(int i = 4; i <= 5000; i+=2) {
	    	for(int j = 0; j < i; j+=2) {
	    		dp[i] += dp[j] * dp[i - j - 2];
	    		dp[i] %=  MOD;
	    	}
	    }
		
		for(int i = 0; i < t; i++) {
			int L = Integer.parseInt(br.readLine());
			
			bw.write(dp[L] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
