import java.io.*;
import java.util.*;

public class Main {
	
	private static int H, W;
	private static int[] blocks;
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		
		blocks = new int[W];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < blocks.length; i++) {
			blocks[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		
		// 맨 왼쪽, 맨 오른쪽에는 빗물이 고일 수 없다.
		for(int i = 1; i < W-1; i++) {
			int maxLeft = 0, maxRight = 0; // 좌, 우 중 최대 높이 블럭
			
			// 좌측에서 가장 높은 블럭 찾기
			for(int j = 0; j < i; j++) {
				maxLeft = Math.max(maxLeft, blocks[j]);
			}
			
			// 우측에서 가장 높은 블럭 찾기
			for(int j = i + 1; j < W; j++) {
				maxRight = Math.max(maxRight, blocks[j]);
			}
			
            // 현재 위치한 열보다 좌, 우로 높은 블럭이 존재해야 빗물이 고일 수 있음
			if(maxLeft <= blocks[i] || maxRight <= blocks[i]) continue;
			
            // 좌측 최대, 우측 최대 중 더 낮은 블럭 높이 - 현재 열의 블럭 높이
			answer += Math.min(maxLeft, maxRight) - blocks[i];
		}
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
		
	}
}
