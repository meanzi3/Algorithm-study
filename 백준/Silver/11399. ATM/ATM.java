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
		
		int N = Integer.parseInt(br.readLine());
		int[] atm = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			atm[i] = Integer.parseInt(st.nextToken());
		}
		
		// 각 사람이 돈을 인출하는 데 필요한 시간의 합이 최소가 되려면
		// 인출하는 데 필요한 시간이 작은 순부터 돈을 인출해야함
		
		// 오름차순 정렬
		Arrays.sort(atm);
		
		int[] sum = new int[N];
		sum[0] = atm[0];
		
		int answer = sum[0];
		
		for(int i = 1; i < atm.length; i++) {
			sum[i] = sum[i-1] + atm[i];
			answer += sum[i];
		}
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
