import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<Integer>();
        for(int i : numbers){
            set.add(i);
        }
        
        for(int i = 0; i < 10; i++){
            if(set.contains(i)) continue;
            answer += i;
        }
        
        return answer;
    }
}