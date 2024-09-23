import java.io.*;
import java.util.*;

public class Main {
	
	private static int N, M;
	private static int startCity, endCity;
	private static int[] distances;
	
	static class Edge {
		int destination; // 도착 노드
		int weight; // 가중치
		
		public Edge(int destination, int weight) {
			this.destination = destination;
			this.weight = weight;
		}
	}
	
	static class Graph {
		private Map<Integer, List<Edge>> adjListMap;
		
		public Graph() {
			adjListMap = new HashMap<>();
		}
		
		// edge 추가
		public void addEdge(int start, int end, int weight) {
			adjListMap.putIfAbsent(start, new ArrayList<>());
			adjListMap.get(start).add(new Edge(end, weight));
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine()); // 도시의 개수
		M = Integer.parseInt(br.readLine()); // 버스의 개수
		
		Graph graph = new Graph();
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int startNode = Integer.parseInt(st.nextToken());
			int endNode = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph.addEdge(startNode, endNode, weight);		
		} // Graph 클래스를 이용하여 방향 그래프를 나타냄
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		startCity = Integer.parseInt(st.nextToken());
		endCity = Integer.parseInt(st.nextToken());
		
		distances = new int[N + 1]; // 최소 거리 저장 배열
		
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[startCity] = 0; // 출발 도시
		
		// 가장 작은 가중치부터 탐색하기 위해 최소 힙 이용
		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
		pq.offer(new Edge(startCity, 0));
		
		while(!pq.isEmpty()) {
			Edge tmp = pq.poll();
			int tmpDestination = tmp.destination;
			int tmpWeight = tmp.weight;
			
			// 현재의 버스의 도착지가 도착 도시라면 종료
			if(tmpDestination == endCity) {
				break;
			}
			
			// 현재 노드의 도착지에서 출발하는 버스 탐색
			for(Edge neighbor : graph.adjListMap.getOrDefault(tmpDestination, new ArrayList<>())) {
				// 새로운 가중치를 구함
				int newDistance = tmpWeight + neighbor.weight;
				
				// 더 짧은 경로라면 갱신
				if(newDistance < distances[neighbor.destination]) {
					distances[neighbor.destination] = newDistance;
					// 다음 노드 탐색
					pq.offer(new Edge(neighbor.destination, newDistance));
				}
			}
		}
		
		// 정답 출력 - 경로가 없으면 -1 출력
		int answer = (distances[endCity] == Integer.MAX_VALUE ? -1 : distances[endCity]);
		
		bw.write(answer + "\n");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
