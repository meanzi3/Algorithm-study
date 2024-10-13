import java.io.*;
import java.util.*;

public class Main {
	
	private static int N;
	private static int[][] rgb;
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		rgb = new int[N][3];
		
		for(int i = 0; i < rgb.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < rgb[0].length; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[N][3];
		
		dp[0][0] = rgb[0][0];
		dp[0][1] = rgb[0][1];
		dp[0][2] = rgb[0][2];
		
		for(int i = 1; i < rgb.length; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
		    dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
		    dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
		}
		
		int answer = Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2]));
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
