import java.io.*;
import java.util.*;

public class Main {
	
	private static int H, W; // 모눈 종이의 크기
	private static int N; // 스티커의 수
	private static int[][] stickers; // 스티커들의 정보
	private static int max = 0;
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		N = Integer.parseInt(br.readLine());
		
		stickers = new int[N][3];
		
		for(int i = 0; i < stickers.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			stickers[i][0] = Integer.parseInt(st.nextToken()); // R
			stickers[i][1] = Integer.parseInt(st.nextToken()); // C
			stickers[i][2] = stickers[i][0] * stickers[i][1]; // 넓이
		}
		
		getMax();
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	private static void getMax() {
		
		// 스티커 두 개를 고른다.
		for(int i = 0; i < stickers.length; i++) {
			for(int j = i + 1; j < stickers.length; j++) {
				
				// 둘 다 그대로인 경우
				if(checkHeightWidth(stickers[i][0], stickers[i][1], stickers[j][0], stickers[j][1])) {
					max = Math.max(max, stickers[i][2] + stickers[j][2]); // 넓이 더해서 최대값 구함.
				}
				
				// 1번 스티커만 회전한 경우
				if(checkHeightWidth(stickers[i][1], stickers[i][0], stickers[j][0], stickers[j][1])) {
					max = Math.max(max, stickers[i][2] + stickers[j][2]); // 넓이 더해서 최대값 구함.
				}
				
				// 2번 스티커만 회전한 경우
				if(checkHeightWidth(stickers[i][0], stickers[i][1], stickers[j][1], stickers[j][0])) {
					max = Math.max(max, stickers[i][2] + stickers[j][2]); // 넓이 더해서 최대값 구함.
				}
				
				// 둘 다 회전한 경우
				if(checkHeightWidth(stickers[i][1], stickers[i][0], stickers[j][1], stickers[j][0])) {
					max = Math.max(max, stickers[i][2] + stickers[j][2]); // 넓이 더해서 최대값 구함.
				}
					
			}
		}
	}
	
	// 위 아래로 붙인 경우
	private static boolean checkHeight(int h1, int w1, int h2, int w2) {
		if(h1 + h2 > H || Math.max(w1, w2) > W) return false;
		return true;
	}
	
	// 옆으로 붙인 경우
	private static boolean checkWidth(int h1, int w1, int h2, int w2) {
		if(w1 + w2 > W || Math.max(h1, h2) > H) return false;
		return true;
	}
	
	// 두 경우 고려
	private static boolean checkHeightWidth(int h1, int w1, int h2, int w2) {
		if(checkHeight(h1, w1, h2, w2) || checkWidth(h1, w1, h2, w2)) return true;
		return false;
	}
}
