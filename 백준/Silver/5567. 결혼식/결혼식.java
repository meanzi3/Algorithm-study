import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	
	private static int n, m; // 동기의 수, 리스트의 길이
	private static List<List<Integer>> adjList = new ArrayList<>();
	private static int answer = 0;
	
	public static void main(String args[]) throws Exception
	{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<Integer>());
		} // 인접 리스트 초기화
		
		StringTokenizer st;
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			adjList.get(node1).add(node2);
			adjList.get(node2).add(node1);
		} // 양방향 그래프 만듦
		
		bfs();
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(1); // 1번 노드부터
		
		boolean[] visited = new boolean[n+1];
		visited[1] = true;
		
		int dist = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				int node = q.poll();
				
				for(int nextNode : adjList.get(node)) {
					if(visited[nextNode])
						continue;
					

					visited[nextNode] = true;
					q.offer(nextNode);
					answer++;
				}
			}
			
			dist++;
			if(dist == 2) break; // 친구의 친구까지만 탐색
		}
	}
}
