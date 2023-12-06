import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        // 중복 제거, 합을 저장할 집합
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        answer = set.stream().mapToInt(Integer::intValue).sorted().toArray();
        
        return answer;
    }
}