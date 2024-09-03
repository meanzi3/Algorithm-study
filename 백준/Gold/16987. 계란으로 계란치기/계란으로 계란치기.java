import java.io.*;
import java.util.*;

public class Main {
	
	private static int N; // 계란의 수
	private static int[][] eggs; // 계란의 정보 {내구도, 무게}
	private static int max = Integer.MIN_VALUE;
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		
		eggs = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 2; j++) {
				eggs[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		
		crackEggs(0, 0); // 시작 인덱스, 깨진 계란 수 
		
		bw.write(max + "\n");
		
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	private static void crackEggs(int index, int cnt) {
		// 종료 조건
		
		// 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란이거나 이미 모든 계란이 깨져있다면 
		if(index == N || cnt >= N-1) {
			max = Math.max(max, cnt);
			return;
		}
		
		// 들고 있는 계란이 이미 깨진 계란이라면
		if(eggs[index][0] <= 0) {
			// 다음 계란 들기
			crackEggs(index + 1, cnt);
			return;
		}
		
		// 다른 계란들과 부딪히기
		int nCnt = cnt;
		for(int i = 0; i < N; i++) {
			
			// 들고 있는 계란과 부딪히려는 계란이 같은 계란이면 패스
			if(i == index) continue;
			
			// 부딪히려는 계란이 이미 꺠져있다면 패스
			if(eggs[i][0] <= 0) continue;
			
			// 계란끼리 부딪히기
			eggs[index][0] -= eggs[i][1];
			eggs[i][0] -= eggs[index][1];
			
			// 들고 있던 계란이 깨진다면 cnt++
			if(eggs[index][0] <= 0)	cnt++;
			
			// 부딪힌 계란이 깨진다면 cnt++
			if(eggs[i][0] <= 0) cnt++;
			
			// 들고 있던 계란의 오른쪽 계란을 든다.
			crackEggs(index + 1, cnt);
			
			// 백트래킹
			eggs[index][0] += eggs[i][1];
			eggs[i][0] += eggs[index][1];
			cnt = nCnt;
		}
		
	}
}
