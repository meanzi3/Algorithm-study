import java.util.*;

class Solution {
    
    
    
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 일단 체육복이 있는 학생 수
        answer += (n - lost.length);
        
        // lost 학생이 여벌이 있는 경우
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(reserve[j] == -1) continue;
                if(lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
                
            }
        }
        
        // lost 학생 앞 뒤로 여벌 있는 학생이 있는 경우
        for(int i = 0; i < lost.length; i++){
            if(lost[i] == -1) continue;
            for(int j = 0; j < reserve.length; j++){
                if(reserve[j] == -1) continue;
                if(lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    answer++;  
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}