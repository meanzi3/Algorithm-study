import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	
	private static int N;
	private static int num[]; // 수열
	private static int operand[]; // 연산자
	private static int operandCopy[]; // 연산자 배열 복사
	private static int max = Integer.MIN_VALUE; // 최대값
	private static int min = Integer.MAX_VALUE; // 최소값
	
	public static void main(String args[]) throws Exception
	{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		num = new int[N];
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		operand = new int[4];
		for(int i = 0; i < 4; i++) {
			operand[i] = Integer.parseInt(st.nextToken());
		}
		
		operandCopy = new int[4];
		
		// dfs 탐색
		dfs(num[0], 0);
		
		bw.write(max + "\n" + min +"\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void dfs(int result, int depth) {
		if(depth == N-1) {
			max = Math.max(max, result); // 최대값 갱신
			min = Math.min(min, result); // 최소값 갱신
		}
		
		if(depth == 0) {
			operandCopy = operand.clone();
		}
		
		for(int i = 0; i < 4; i++) {
			if(operandCopy[i] > 0) {
				operandCopy[i]--;
				if(i == 0) {
					dfs(result + num[depth + 1], depth + 1);
				} else if(i == 1) {
					dfs(result - num[depth + 1], depth + 1);
				} else if(i == 2) {
					dfs(result * num[depth + 1], depth + 1);
				} else if(i == 3) {
					dfs(result / num[depth + 1], depth + 1);
				}
				operandCopy[i]++;
				
			}
		}
	}
}
