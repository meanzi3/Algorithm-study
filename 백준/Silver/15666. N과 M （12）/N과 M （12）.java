import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	
	private static int[] num;
	private static int n;
	private static int m;
	private static int[] numArr;
	private static Set<String> set;
	
	public static void main(String args[]) throws Exception
	{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken()); 
		// n개의 자연수 중에서 m개를 고른 수열
		// 같은 수를 여러 번 골라도 됨
		// 고른 수열은 비내림차순이어야 함
		
		num = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num); // 오름차순 정렬
		
		numArr = new int[m];
		set = new LinkedHashSet<>(); // 작은 수부터 순서대로 저장할 것이므로 순서 유지되는 LinkedHashSet 이용
		
		dfs(0,0);
		
		for(String str : set) {
			bw.write(str + "");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
		
	}
	
	private static void dfs(int depth, int index) {
		
		// 종료조건
		if(depth == m) {
			String str = "";
			for(int number : numArr) {
				str += number + " ";
			}
			set.add(str + "\n");
			
			return;
			
		}
		
		for(int i = index; i < n; i++) {
			numArr[depth] = num[i];
			dfs(depth + 1, i);
		}
		
	}
}
