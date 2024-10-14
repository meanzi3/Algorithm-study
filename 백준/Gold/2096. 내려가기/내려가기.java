import java.io.*;
import java.util.*;

public class Main {
	
	private static int N;
	private static int[][] board;
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][3];
		
		for(int i = 0; i < board.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < board[0].length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dpMax = new int[N][3];
		int[][] dpMin = new int[N][3];
		
		for(int i = 0; i < board.length; i++) {
			if(i == 0) {
				
				dpMax[i][0] = dpMin[i][0] = board[i][0];
				dpMax[i][1] = dpMin[i][1] = board[i][1];
				dpMax[i][2] = dpMin[i][2] = board[i][2];
				
			} else {
				
				dpMax[i][0] = Math.max(dpMax[i-1][0], dpMax[i-1][1]) + board[i][0];
				dpMax[i][1] = Math.max(dpMax[i-1][0], Math.max(dpMax[i-1][1], dpMax[i-1][2])) + board[i][1];
				dpMax[i][2] = Math.max(dpMax[i-1][1], dpMax[i-1][2]) + board[i][2];
				
				dpMin[i][0] = Math.min(dpMin[i-1][0], dpMin[i-1][1]) + board[i][0];
				dpMin[i][1] = Math.min(dpMin[i-1][0], Math.min(dpMin[i-1][1], dpMin[i-1][2])) + board[i][1];
				dpMin[i][2] = Math.min(dpMin[i-1][1], dpMin[i-1][2]) + board[i][2];
			}
		}
		
		int max = Math.max(dpMax[N-1][0], Math.max(dpMax[N-1][1], dpMax[N-1][2]));
		int min = Math.min(dpMin[N-1][0], Math.min(dpMin[N-1][1], dpMin[N-1][2]));
		
		bw.write(max + " " + min + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
