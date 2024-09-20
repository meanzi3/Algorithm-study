import java.io.*;
import java.util.*;

public class Main {
	
	private static int N; // 주사위의 개수
	private static int[][] diceInfos; // 주사위 정보
	
	private static int max = Integer.MIN_VALUE;
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		diceInfos = new int[N][6];
		
		for(int i = 0; i < diceInfos.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < diceInfos[0].length; j++) {
				diceInfos[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1번 주사위의 상태 6가지에 따른 경우 탐색
		for(int i = 0; i < 6; i++) {
			searchMax(0, i, 0);
		}
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	private static void searchMax(int cnt, int tmpBottom, int sum) {
		
		// 마주보는 면 구하기
		int tmpTop = searchTop(tmpBottom);
		
		// 옆면 중 최댓값 구하기
		int tmpMax = Integer.MIN_VALUE;
		for(int i = 0; i < 6; i++) {
			if(i != tmpBottom && i != tmpTop) { // 아랫면, 윗면 제외
				tmpMax = Math.max(tmpMax, diceInfos[cnt][i]);
			}
		}
		
		sum += tmpMax; // 최댓값 더하기
		
		if(cnt == N - 1) {
			// 종료
			max = Math.max(max, sum); // 최댓값 갱신
			return;
		}
		
		// 다음 주사위 쌓기
		for(int i = 0; i < 6; i++) {
			if(diceInfos[cnt][tmpTop] == diceInfos[cnt + 1][i]) {
				searchMax(cnt + 1, i, sum);
			}
		}
	}
	
	private static int searchTop(int bottomIndex) {
		
		// 규칙에 따라 마주보는 면의 인덱스를 구함
		if(bottomIndex == 0)	return 5;
		else if(bottomIndex == 1)	return 3;
		else if(bottomIndex == 2)	return 4;
		else if(bottomIndex == 3)	return 1;
		else if(bottomIndex == 4)	return 2;
		else return 0;
		
	}
}
