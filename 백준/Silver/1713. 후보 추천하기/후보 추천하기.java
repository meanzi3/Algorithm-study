import java.io.*;
import java.util.*;

public class Main {
	
	private static int N; // 사진틀의 개수
	private static int recommendCnt; // 총 추천 횟수
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		recommendCnt = Integer.parseInt(br.readLine());
		
		// (학생번호, 추천수)
		// 삽입된 순서가 유지되는 LinkedHashMap을 사용한다.
		LinkedHashMap<Integer, Integer> students = new LinkedHashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < recommendCnt; i++) {
			int student = Integer.parseInt(st.nextToken());
			
			// 이미 사진 틀에 있다면 추천수만 증가
			if(students.containsKey(student)) {
				students.put(student, students.get(student) + 1);
			} else {
				// 사진 틀이 다 찼다면
				if(students.size() == N) {
					// 추천 수가 최소인 학생의 키를 얻는다.
					int removedStudent = -1;
					int minRecommended = Integer.MAX_VALUE;
					
					for(Map.Entry<Integer, Integer> entry : students.entrySet()) {
						if(entry.getValue() < minRecommended) {
							removedStudent = entry.getKey();
							minRecommended = entry.getValue();
						}
					}
					
					// 삭제
					students.remove(removedStudent);
				}
				
				// 추천 받은 학생을 새로 사진 틀에 추가한다.
				students.put(student, 1);
			}
		}
		
		// 정답 리스트, 정렬
		List<Integer> answer = new ArrayList<>(students.keySet());
		Collections.sort(answer);
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < answer.size(); i++) {
			sb.append(answer.get(i) + " ");
		}
		
		bw.write(sb.toString() + "\n");
		bw.flush();
		bw.close();
		br.close();
		
	}
}
