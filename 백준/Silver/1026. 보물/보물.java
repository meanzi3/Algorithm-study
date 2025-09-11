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

		int N = Integer.parseInt(br.readLine()); // 배열 A, B의 크기
		int[] A = new int[N];
		int[] B = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		// S의 값을 가장 작게 만들기 위해
		// A의 큰값 * B의 작은값 + ... + A의 작은값 B의 큰값
		// 문제에서 B는 재배열하지 않고, A만 재배열 하라고 했지만
		// S만 구하면 되므로 둘 다 정렬 한 뒤 S 구해주면 됨.
		
		// A는 오름차순 정렬
		Arrays.sort(A);
		
		// B는 내림차순 정렬
		B = Arrays.stream(B).boxed().sorted(Collections.reverseOrder())
				.mapToInt(Integer::intValue).toArray();
		
		// S 구하기
		int S = 0;
		for(int i = 0; i < N; i++) {
			S += (A[i] * B[i]);
		}
		
		bw.write(S + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
