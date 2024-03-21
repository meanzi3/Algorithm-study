import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length / 2; // 가져갈 수 있는 폰켓몬 수
        
        Set<Integer> set = new HashSet<>(); 
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
            // set에 해당 값이 없으면 추가.
        }
        
        // set의 크기가 n 보다 크다면 답은 n, 
        answer = set.size() > n ? n : set.size();
        return answer;
    }
}