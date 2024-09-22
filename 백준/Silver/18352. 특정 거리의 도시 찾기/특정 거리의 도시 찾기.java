import java.io.*;
import java.util.*;

public class Main {
	
	private static int N, M, K, X;
	private static List<List<Integer>> adjList;
	private static boolean[] visited;
	private static List<Integer> answer;
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 도시의 개수
		M = Integer.parseInt(st.nextToken()); // 도로의 개수
		K = Integer.parseInt(st.nextToken()); // 거리 정보
		X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호
		
		adjList = new ArrayList<>();
		
		for(int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			adjList.get(node1).add(node2); // 단방향
		} // 인접 리스트 생성
		
		visited = new boolean[N + 1];
		answer = new ArrayList<>();
		
		Queue<int[]> q = new LinkedList<>();
		
		visited[X] = true;
		q.offer(new int[] {X, 0});
		
		while(!q.isEmpty()) {
			int[] tmpNode = q.poll();
			
			List<Integer> tmpList = adjList.get(tmpNode[0]);
			
			int dir = tmpNode[1];
			
            if(dir > K)	continue;
            
			if(dir == K) {
				answer.add(tmpNode[0]);
			}
			
			if(tmpList.size() != 0) {
				for(int nextNode : tmpList) {
					if(!visited[nextNode]) {
						visited[nextNode] = true;
						q.offer(new int[] {nextNode, dir + 1});
					}
				}
			}
		}
		
		// 해당하는 노드들이 없으면 -1 출력
		if(answer.size() == 0) {
			bw.write("-1");
			bw.write("\n");
		} else {
			// 오름차순 정렬
			Collections.sort(answer);
			
			// 출력
			int size = answer.size();
			for(int i = 0; i < size; i++) {
				bw.write(answer.get(i).toString());
				bw.write("\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
