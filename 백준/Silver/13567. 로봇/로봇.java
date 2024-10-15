import java.io.*;
import java.util.*;

public class Main {
	
	private static int M;
	private static int n;
	
	private static int[] dr = {0, 1, 0, -1};
	private static int[] dc = {1, 0, -1, 0};
	
	public static void main(String args[]) throws Exception
	{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		int cr = 0;
		int cc = 0;
		int dir = 0; // 처음은 동쪽을 바라봄
		
		boolean flag = true;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			String command = st.nextToken();
			int d = Integer.parseInt(st.nextToken());
			
			if(command.equals("MOVE")) {
				cr += dr[dir] * d;
				cc += dc[dir] * d;
			} else {
				if(d == 0) {
					dir = (dir + 1) % 4;
				} else if(d == 1) {
					dir = (dir + 3) % 4;
				}
			}
			
			if(cr < 0 || cr > M || cc < 0 || cc > M) {
				flag = false;
				break;
			}
		}
		
		if(flag) {
			bw.write(cc + " " + cr + "\n");
		} else {
			bw.write("-1");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
