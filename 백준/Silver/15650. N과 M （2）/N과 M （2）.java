import java.io.*;
import java.util.*;

public class Main {
	
	private static int N, M;
	private static int[] arr;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		dfs(0, 0);
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	private static void dfs(int depth, int index) {
		// 종료 조건
		if(depth == M) {
			for(int num : arr) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = index; i < N; i++) {
			arr[depth] = i + 1;
			dfs(depth + 1, i + 1);
			
		}
	}
	
}
