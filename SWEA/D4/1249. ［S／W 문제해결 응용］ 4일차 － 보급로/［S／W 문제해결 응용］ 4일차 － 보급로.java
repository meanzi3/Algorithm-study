import java.io.*;
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	
	private static int n; // 지도 크기
	private static int[][] arr; // 지도 정보 저장 배열
	private static int[][] sum; // 최소 비용 저장 배열
	
	private final static int dx[] = {1, 0, -1, 0};
	private final static int dy[] = {0, -1, 0, 1};
			
	
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		// System.setIn(new FileInputStream("src/samsung05/input.txt"));

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    int T = Integer.parseInt(br.readLine());
	    
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			sum = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				Arrays.fill(sum[i], Integer.MAX_VALUE);
			}
			
			for(int i = 0; i < n; i++) {
				String s = br.readLine();
				for(int j = 0; j < n; j++) {
					arr[i][j] = s.charAt(j) - '0';
				}
			} 
			
			sum[0][0] = 0;
			
			bfs();
			
			System.out.println("#" + test_case + " " + sum[n-1][n-1]);

		}
		
	}
	
	private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0, 0 }); // 현재 위치와 현재까지의 비용을 담음
        
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                
                // 범위 확인
                if (nx < 0 || nx >= n || ny < 0 || ny >= n)continue;

                int cost = temp[2] + arr[nx][ny]; // 비용 계산
                if (sum[nx][ny] > cost) { // 더 짧은 거리로 갱신 될 때만 큐에 넣음 
                    sum[nx][ny] = cost;
                    q.offer(new int[] { nx, ny, cost });
                }
            }
        }

    }
}
