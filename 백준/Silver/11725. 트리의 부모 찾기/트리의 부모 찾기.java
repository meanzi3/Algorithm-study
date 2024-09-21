import java.io.*;
import java.util.*;

public class Main {
	
	private static int N; // 노드의 개수
	private static List<List<Integer>> adjList; // 인접 리스트
	private static boolean[] visited; // 방문 확인 배열
	
	private static int[] answer; // 각 노드의 부모 노드를 저장하는 정답 배열
	
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		adjList = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			adjList.get(node1).add(node2);
			adjList.get(node2).add(node1);
		} // 인접 리스트 생성
		
		visited = new boolean[N + 1];
		answer = new int[N + 1];
		
		// 1번 노드 부터 탐색
		dfs(1);
		
		// 정답 출력
		for(int i = 2; i <= N; i++) {
			bw.write(answer[i] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	private static void dfs(int currentNode) {
		
		// 현재 노드 방문 처리
		visited[currentNode] = true;
		
		for(int adjNode : adjList.get(currentNode)) {
			// 인접한 노드가 아직 방문하지 않은 노드이면
			if(!visited[adjNode]) {
				// 해당 노드의 부모를 현재 노드로
				answer[adjNode] = currentNode;
				// 해당 노드 방문
				dfs(adjNode);
			}
		}
	}
}
