import java.io.*;
import java.util.*;

class Point {
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	
	public static void main(String args[]) throws Exception
	{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		ArrayList<Point> point; // 집, 편의점, 락페 위치 저장
		ArrayList<ArrayList<Integer>> graph; // 거리가 (50 * 20 = 1000m) 이내인 장소를 연결한 그래프
		
		int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine()); // 맥주를 파는 편의점의 개수
			
			point = new ArrayList<>();
			
			// 각 위치 저장
			for(int j = 0; j < n+2; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				point.add(new Point(x, y));
			}
			
			graph = new ArrayList<>();
			for(int j = 0; j < n+2; j++) {
				graph.add(new ArrayList<>());
			}
			
			// 양방향 그래프 만듦 (노드 번호: 상근이집 0번, 편의점1 1번, 편의점2 2번, ... 편의점n n번, 락페 n+1번)
			for(int j = 0; j < n+2; j++) {
				for(int k = j+1; k < n+2; k++) {
					if(isPossible(point.get(j), point.get(k))) {
						graph.get(j).add(k);
						graph.get(k).add(j);
					}
				}
			}
			
			if(bfs(graph, n)) {
				sb.append("happy" + "\n");
			} else {
				sb.append("sad" + "\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static boolean isPossible(Point p1, Point p2) {
		// 맨헤튼 거리가 1000m 이내인지
		if((Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y)) <= 1000) {
			return true;
		}
		return false;
	}
	
	public static boolean bfs(ArrayList<ArrayList<Integer>> graph, int n) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		
		boolean[] visited = new boolean[n+2];
		visited[0] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			// 락페까지 갈 수 있으면
			if(now == n+1) {
				return true;
			}
			
			for(int next : graph.get(now)) {
				if(!visited[next]) {
					visited[next] = true;
					q.offer(next); // 다음 노드 탐색
				}
			}
		}
		
		return false;
	}
}
