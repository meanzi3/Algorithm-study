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
		
		// 식의 결과가 가장 작은 수가 되려면
		// 큰 값을 빼주어야 함. - 뒤의 수가 커야함
		// + 연산을 가장 먼저 해주고
		// 나머지 연산을 해줌
		
		// - 를 기준으로 나눔
		StringTokenizer stMinus = new StringTokenizer(br.readLine(), "-");
		
		int sum = Integer.MAX_VALUE;
		
		while(stMinus.hasMoreTokens()) {
			
			// + 를 기준으로 나눔
			StringTokenizer stPlus = new StringTokenizer(stMinus.nextToken(), "+");
			
			int num = 0;
			
			while(stPlus.hasMoreTokens()) {
				num += Integer.parseInt(stPlus.nextToken());
			}
			
			if(sum == Integer.MAX_VALUE) {
				// 첫 번째 토큰일 경우
				sum = num;
			} else {
				sum -= num;
			}
		}
		
		bw.write(sum+"\n");
		bw.flush();
		bw.close();
		br.close();
		
	}

}
