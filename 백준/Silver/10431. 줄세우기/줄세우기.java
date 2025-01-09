import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	private static int P; // 테스트 케이스의 수
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		P = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int[] students;
		int testNum;
		int testResult;
		
		for(int i = 0; i < P; i++) {
			
			students = new int[20];
   			st = new StringTokenizer(br.readLine(), " ");
   			testNum = Integer.parseInt(st.nextToken());
   			testResult = 0;
   			
   			// 입력값 저장
			for(int j = 0; j < 20; j++) {
				students[j] = Integer.parseInt(st.nextToken());
			}
			
			// 시뮬레이션
			for(int j = 0; j < 20; j++) {
				for(int k = 0; k < j; k++) {
					if(students[j] < students[k]) {
						testResult++;
					}
				}
			}
			
			bw.write(testNum + " " + testResult + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
