import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	
	private static int max = Integer.MIN_VALUE;
	private static int[][] schedule;
	
	public static void main(String args[]) throws Exception
	{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		schedule = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			schedule[i][0] = Integer.parseInt(st.nextToken());
			schedule[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			dfs(i, 0);
		}
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void dfs(int index, int num) {
		// 범위 넘어가면 종료
		if((index + schedule[index][0]) > schedule.length) {
			max = Math.max(max, num); // 최댓값 갱신
			
			return;
		}
		
		int nextIndex = index + schedule[index][0];
		num += schedule[index][1];
		
		if(nextIndex >= schedule.length) {
			max = Math.max(max, num); // 최댓값 갱신
			
			return;
		}
		
		for(int i = nextIndex; i < schedule.length; i++) {
			dfs(i, num);
		}
	}
}
