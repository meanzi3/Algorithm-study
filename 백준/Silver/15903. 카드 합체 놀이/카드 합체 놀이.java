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
		
		int n = Integer.parseInt(st.nextToken()); // 카드의 개수
		int m = Integer.parseInt(st.nextToken()); // 카드 합체 횟수
		
		// 제일 작은 수를 만드려면
		// 합체할 때 가장 작은 수 2개를 합체하면 된다.
		// 합체할 때마다 가장 작은 수를 찾아야하므로 우선순위큐를 쓴다.
		
		// 최소힙
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			long num = Long.parseLong(st.nextToken());
			pq.offer(num);
		}
		
		for(int i = 0; i < m; i++) {
			// 가장 작은 수 2개 뺌
			long num1 = pq.poll();
			long num2 = pq.poll();
			
			// 합체
			long tmp = num1 + num2;
			
			pq.offer(tmp);
			pq.offer(tmp);
		}
		
		// 우선순위큐 안의 모든 수를 더함
		long sum = 0;
		
		while(!pq.isEmpty()) {
			long num = pq.poll();
			
			sum += num;
		}
		
		bw.write(sum + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
