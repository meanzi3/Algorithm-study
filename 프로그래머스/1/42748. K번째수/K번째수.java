import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < answer.length; i++){
            int[] command = commands[i];
            
            // 부분 배열 만들고 정렬
            int[] sub = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(sub);
            
            // 정답 배열에 담기
            answer[i] = sub[command[2] - 1];
        }
        
        return answer;
    }
}