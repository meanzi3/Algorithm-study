import java.io.*;
import java.util.*;

public class Main {
	
	private static int k; // 부등호 개수
	private static String[] sign; // 부등호 저장
	private static boolean[] visited; // 사용한 정수인지 확인
	
	private static String max = "";
	private static String min = "";
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		k = Integer.parseInt(br.readLine());
		
		sign = new String[k];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < sign.length; i++) {
			sign[i] = st.nextToken();
		}
		
		
		for(int i = 0; i <= 9; i++) {
			visited = new boolean[10];
			visited[i] = true;
			dfs(0, String.valueOf(i), i);
		}
		
		bw.write(max + "\n" + min + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void dfs(int depth, String nums, int currentNum) {
		if(depth == k) {
			// 종료
			if(max.equals("") || nums.compareTo(max) > 0) {
				// 최댓값 갱신
				max = nums;
			}
			if(min.equals("") || nums.compareTo(min) < 0) {
				// 최소값 갱신
				min = nums;
			}
			return;
		}
		
		// 다음 숫자 고르기
		for(int i = 0; i <= 9; i++) {
			
			// 이미 고른 숫자인지 확인
			if(visited[i]) continue;
			
			// 부등호에 맞는 숫자인지 확인
			if(sign[depth].equals(">")) {
				if(currentNum < i)	continue;
			} else if(sign[depth].equals("<")) {
				if(currentNum > i)	continue;
			}
			
			// 다음 탐색
			visited[i] = true;
			dfs(depth + 1, nums + i, i);
			
            visited[i] = false;
		}
	}
}
