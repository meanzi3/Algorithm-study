import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	private static int[] nums;
	private static boolean[] isClockNum;
	
	public static void main(String args[]) throws Exception
	{
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 아이디어 : 1111부터 9999까지 시계수를 구한다.
		// 주어진 수의 시계수를 구한다.
		// 몇 번째인지 센다.
		
		nums = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < 4; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		} // 카드 저장
		
		// 시계수인지 체크하는 배열
		isClockNum = new boolean[10000];
		
		// 1111부터 9999까지 주어졌을 때 시계수를 구하여 체크한다.
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				for(int k = 1; k <= 9; k++) {
					for(int l = 1; l <= 9; l++) {
						int clockNum = getMinClockNum(i, j, k, l);
						
						isClockNum[clockNum] = true;
					}
				}
			}
		}
		
		// 입력으로 주어진 수의 시게수를 구한다.
		int inputClockNum = getMinClockNum(nums[0], nums[1], nums[2], nums[3]);
		
		// 순서를 구한다.
		int answer = 0;
		for(int i = 1111; i <= inputClockNum; i++) {
			if(isClockNum[i]) {
				answer++;
			}
		}
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
		
		
	}
	
	private static int getMinClockNum(int i, int j, int k, int l) {
		int minClockNum = Integer.MAX_VALUE;
		
		// 4가지 경우의 수
		minClockNum = Math.min(minClockNum, i * 1000 + j * 100 + k * 10 + l);
		minClockNum = Math.min(minClockNum, j * 1000 + k * 100 + l * 10 + i);
		minClockNum = Math.min(minClockNum, k * 1000 + l * 100 + i * 10 + j);
		minClockNum = Math.min(minClockNum, l * 1000 + i * 100 + j * 10 + k);
		
		return minClockNum;
	}
}
