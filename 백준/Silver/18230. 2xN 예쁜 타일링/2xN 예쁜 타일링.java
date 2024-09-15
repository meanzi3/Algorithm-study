import java.io.*;
import java.util.*;

public class Main {
	
	
	private static int N;
	private static int A, B;
	
	private static Integer[] aTiles;
	private static Integer[] bTiles;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		aTiles = new Integer[A];
		bTiles = new Integer[B];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < aTiles.length; i++) {
			aTiles[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < bTiles.length; i++) {
			bTiles[i] = Integer.parseInt(st.nextToken());
		}
		
		// 내림차순 정렬
		Arrays.sort(aTiles, Collections.reverseOrder());
		Arrays.sort(bTiles, Collections.reverseOrder());
		
		int restTiles = N; // 남은 타일
		int max = 0; // 예쁨의 합
		int aIndex = 0; // 2x1 타일 인덱스
		int bIndex = 0; // 2x2 타일 인덱스
		
		// N이 홀수라면 2x1 타일을 무조건 하나 이상 써야 함
		if(restTiles % 2 == 1 && A > 0) {
			max += aTiles[aIndex++]; // 제일 큰 타일 쓰기
			restTiles --;
		} // 남은 타일을 먼저 짝수로 맞춰준다.
		
		while(restTiles > 0) {
			// 2x1 타일이 2개 이상, 2x2 타일이 1개 이상 있을 때
			if(bIndex < B && aIndex + 1 < A) {
				// 2x2 타일 하나와 2x1 타일 두 개 중 더 큰 예쁨을 가진 쪽을 선택한다.
				if(bTiles[bIndex] > aTiles[aIndex] + aTiles[aIndex + 1]) {
					max += bTiles[bIndex++];
				} else{
					max += aTiles[aIndex++] + aTiles[aIndex++];
				}
			} else if(bIndex < B) {
				// 2x2 타일이 남아 있을 때
				max += bTiles[bIndex++];
			} else if(aIndex + 1 < A) {
				// 2x1 타일이 두 개 남아있을 때
				max += aTiles[aIndex++] + aTiles[aIndex++];
			} else {
				// 더 이상 타일을 배치할 수 없을 때
				break;
			}
			
			restTiles -= 2;
		}
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
