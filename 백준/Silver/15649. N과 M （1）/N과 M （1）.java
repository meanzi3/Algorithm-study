import java.io.*;
import java.util.*;

public class Main {
	
	private static int N, M;
	private static int[] arr;
	private static boolean[] visited;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		br.close();
		
		arr = new int[M];
		visited = new boolean[N];
		
		dfs(0);
		
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		
	}
	
	private static void dfs(int depth) {
		if(depth == M) {
			// 종료 및 문자열 만들기
			for(int num : arr) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = i + 1;
				dfs(depth + 1);
				// 백트래킹
				visited[i] = false;
			}
		}
	}
}
