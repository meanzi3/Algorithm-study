import java.io.*;
import java.util.*;

public class Main {
	
	private static int n; // 컴퓨터의 수
	private static int pairs; // 컴퓨터 쌍의 수
	
	private static List<List<Integer>> adjList;
	private static boolean[] visited;
	private static int answer;
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		pairs = Integer.parseInt(br.readLine());
		
		adjList = new ArrayList<>();
		
		for(int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<>());
		}	// 인접 행렬
		
		StringTokenizer st;
		
		for(int i = 0; i < pairs; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			adjList.get(num1).add(num2);
			adjList.get(num2).add(num1);
		} // 무방향 
		
		visited = new boolean[n + 1]; // 방문 확인 배열
		answer = 0;
		
		// bfs 수행
		bfs();
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		
		visited[1] = true;
		q.offer(1); // 1번 컴퓨터부터 bfs 수행
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int n : adjList.get(temp)) {
				if(!visited[n]) {
					visited[n] = true;
					answer++;
					q.offer(n);
				}
			}
		}
		
	}
}
