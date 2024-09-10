import java.io.*;
import java.util.*;

public class Main {
	
	private static int N, S; // 정수의 개수와 만들어야 하는 정수
	private static int[] nums; // 주어진 수열
	private static int answer; // 정답
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		nums = new int[N];
		
		for(int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0);
		
		if(S == 0) answer--;
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void dfs(int index, int sum) {
		
		// 종료 조건
		if(index == N) {
			if(sum == S) answer++;
			return;
		}
		
		// 현재 원소를 포함 했을 때
		dfs(index + 1, sum + nums[index]);
		// 포함하지 않았을 때
		dfs(index + 1, sum);
	}
}
