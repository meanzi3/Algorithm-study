import java.io.*;
import java.util.*;

public class Main {
	
	private static int N; // 식택의 길이
	private static int K; // 햄버거를 선택할 수 있는 거리
	
	private static char[] hamburgers; // 식탁 정보 저장
	private static boolean[] visited; // 먹은 햄버거 관리
	private static int answer; // 정답
	
	public static void main(String args[]) throws Exception
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		hamburgers = br.readLine().toCharArray();
		visited = new boolean[N];
		
		// 먹을 수 있는 햄버거 중 항상 앞쪽에 위치한 햄버거를 먹어야 최대로 많은 사람들이 햄버거를 먹을 수 있다.
		for(int i = 0; i < N; i++) {
			if(hamburgers[i] == 'P') {
				for(int j = (i - K); j <= (i + K); j++) {
					if(j >= N) break; // N보다 커지면 종료
					if(j < 0) continue; // 0보다 작으면 넘어감
					
					// 아직 먹지 않은 햄버거라면
					if(hamburgers[j] == 'H' && visited[j] == false) {
						visited[j] = true;
						answer++;
						break;
					}
				}
			}
		}
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
