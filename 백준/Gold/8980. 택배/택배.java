import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception
	{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		int N, C; // 마을의 수, 트력 용량
		int M; // 보내는 박스 정보의 개수
		int[][] boxInfo; // 박스 배송 정보
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		
		boxInfo = new int[M][3];
		
		for(int i = 0; i < boxInfo.length; i++) {
			st = new StringTokenizer(br.readLine());
			boxInfo[i][0] = Integer.parseInt(st.nextToken());
			boxInfo[i][1] = Integer.parseInt(st.nextToken());
			boxInfo[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int[] town = new int[N+1]; // 각 마을마다 새로 실을 수 있는 택배 수 저장 
		Arrays.fill(town, C); // 트력의 용량만큼 초기화
		
		// 거리가 먼 박스를 싣고 오래 이동하면 중간에 옮길 수 있는 상자를 놓치게 됨
		// 최대한 가까이에 있는 마을이 도착지인 택배를 싣는게 이득
		// 받는 마을이 가까운 순으로 정렬, 보내는 마을이 가까운 순으로 정렬
		
		Arrays.sort(boxInfo, (a, b) -> {
			if(a[1] == b[1]) {
				return a[0] - b[0];
			}
			return a[1] - b[1];
		});
		
		// 박스 정보 배열 탐색하면서 답을 구함
		int answer = 0;
		
		for(int i = 0; i < boxInfo.length; i++) {
			int start = boxInfo[i][0]; // 보내는 마을
			int end = boxInfo[i][1]; // 받는 마을
			int num = boxInfo[i][2]; // 박스 개수
			
			int min = Integer.MAX_VALUE; // 실을 수 있는 남은 용량 중 가장 적은 용량
			
			for(int j = start; j < end; j++) {
				min = Math.min(min, town[j]);
			}
			
			int box = Math.min(min, num);
			
			for(int j = start; j < end; j++) {
				town[j] -= box;
			}
			
			answer += box;
		}
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
		
	}
}
