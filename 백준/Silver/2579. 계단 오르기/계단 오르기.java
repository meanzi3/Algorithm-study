import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws Exception
	{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine()); // 계단의 개수
		int[] stairs = new int[n]; // 계단 정보 배열
		
		for(int i = 0; i < n; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[n]; // dp 배열 (각 계단까지 도달했을 때 얻을 수 있는 최대 점수)
		
		// 엣지 케이스 
		if(n == 1) {
			dp[0] = stairs[0];
		} else if(n == 2){
			dp[1] = stairs[1] + stairs[0];
		} else {
			dp[0] = stairs[0];
			dp[1] = stairs[0] + stairs[1];
			dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
			// 1 -> 3번째로 온 경우 / 2 -> 3번째로 온 경우
			
			for(int i = 3;i < dp.length; i++) {
				dp[i] = Math.max(dp[i-3] + stairs[i-1], dp[i-2]) + stairs[i];
				// 2 + 1 계단으로 올라온 경우 = i-3 -> i-1 -> i
				// 2계단으로 올라온 경우 = i-2 -> i
			}
		}
	
		
		bw.write(dp[n-1] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
