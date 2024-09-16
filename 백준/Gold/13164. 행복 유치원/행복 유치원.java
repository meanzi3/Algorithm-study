import java.io.*;
import java.util.*;

public class Main {
	
	private static int N, K; // 원생의 수, 나누려는 조의 수
	private static int[] heights; // 원생들의 키
	private static int[] difference; // 키 차이
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		heights = new int[N];
		difference = new int[N - 1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < heights.length; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < difference.length; i++) {
			difference[i] = heights[i + 1] - heights[i];
		}
		
		Arrays.sort(difference);
		
		int answer = 0;
		
		for(int i = 0 ; i < N - K; i++) {
			answer += difference[i];
		}
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
