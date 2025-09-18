import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	
	private static int n; // 회원의 수
	private static int INF = 987654321;
	
	public static void main(String args[]) throws Exception
	{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		
		int[][] dist = new int[n+1][n+1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i != j) {
					dist[i][j] = INF;
				}
			}
		}
		
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			if(node1 == -1 && node2 == -1) {
				break;
			}
			
			dist[node1][node2] = 1;
			dist[node2][node1] = 1;
		}
		
		// 플로이드 와샬로 모든 회원에서 모든 회원까지의 최단 경로를 구한다
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		
		int min = INF;
		
		int[] scoreArr = new int[n+1]; // 각 회원의 친구 점수 저장
		
		for(int i = 1; i <= n; i++) {
			int score = 0;
			for(int j = 1; j <= n; j++) {
				if(dist[i][j] != INF) {
					score = Math.max(score, dist[i][j]);
				}
				
			}
			
			scoreArr[i] = score;
			
			min = Math.min(min, score);
		}
		
		int cnt = 0; // 회장 후보의 수
		StringBuilder sb = new StringBuilder(); // 회장 후보를 출력하기 위한 스트링빌더
		
		for(int i = 1; i <= n; i++) {
			if(min == scoreArr[i]) {
				cnt++;
				sb.append(i + " ");
			}
		}
		
		// 결과 출력
		bw.write(min + " " + cnt + "\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	
}
