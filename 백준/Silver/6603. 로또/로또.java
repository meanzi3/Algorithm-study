import java.io.*;
import java.util.*;

public class Main {
	
	private static int K;
	private static int[] num;
	private static boolean[] visited;
	private static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true){
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			K = Integer.parseInt(st.nextToken()); // 개수
			
			if(K == 0) {
				break;
			}
			
			num = new int[K];
			visited = new boolean[K];
			
			for(int i = 0; i < K; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			sb = new StringBuilder();
			
			getLotto(0, 0);
			
			bw.write(sb.toString() + "\n");
			
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static void getLotto(int depth, int index) {
		if(depth == 6) {
			// 종료, 출력
			for(int i = 0; i < K; i++) {
				if(visited[i]) {
					sb.append(num[i]).append(" ");
				}
			}
			sb.append("\n");
		}
		
		// 오름차순 조합
		for(int i = index; i < K; i++) {
			visited[i] = true;
			getLotto(depth + 1, i + 1);
			
			// 백트래킹
			visited[i] = false;
		}
	}
	
}
