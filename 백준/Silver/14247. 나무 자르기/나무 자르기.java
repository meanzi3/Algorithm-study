import java.io.*;
import java.util.*;

public class Main {
	
	private static int n; // 나무의 개수
	private static int[][] trees; // 나무 정보
	
	public static void main(String args[]) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		
		trees = new int[n][2];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			trees[i][0] = Integer.parseInt(st.nextToken());
		} // 첫날 나무 길이 저장
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			trees[i][1] = Integer.parseInt(st.nextToken());
		} // 나무들이 자라는 길이 저장
		
		// 작은 길이로 자라는 나무부터 자르기?
		// 자라는 길이 순으로 오름차순 정렬
		Arrays.sort(trees, (a, b) -> Integer.compare(a[1], b[1]));
		
		long answer = 0;
		for(int i = 0; i < n ; i++) {
			// 첫 날의 길이 + (자라는 길이 x 일 수)
			answer += (trees[i][0] + (trees[i][1] * i));
		}
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
