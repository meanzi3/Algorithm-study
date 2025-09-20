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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 가로
		int m = Integer.parseInt(st.nextToken()); // 세로
		
		int storeNum = Integer.parseInt(br.readLine()); // 상점 개수
		
		int[][] arr = new int[storeNum+1][2];
		
		for(int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] newArr = new int[storeNum+1]; // 북쪽 맨 왼쪽을 기준으로 위치 다시 저장할 배열
		
		for(int i = 0; i < newArr.length; i++) {
			if(arr[i][0] == 1) {
				// 북쪽
				newArr[i] = arr[i][1];
			} else if(arr[i][0] == 2) {
				// 남쪽
				newArr[i] = n + m + (n-arr[i][1]);
			} else if(arr[i][0] == 3) {
				// 서쪽
				newArr[i] = n + m + n + (m-arr[i][1]);
			} else if(arr[i][0] == 4) {
				// 동쪽
				newArr[i] = n +arr[i][1];
			}
		}
		
		int sum = 0;
		
		int per = 2*n + 2*m;
		int guard = newArr[storeNum];

		for (int i = 0; i < storeNum; i++) {
		    int diff = Math.abs(guard - newArr[i]);
		    sum += Math.min(diff, per - diff);
		}
		
		
		bw.write(sum+"\n");
		bw.flush();
		bw.close();
		br.close();
		
	}
}
