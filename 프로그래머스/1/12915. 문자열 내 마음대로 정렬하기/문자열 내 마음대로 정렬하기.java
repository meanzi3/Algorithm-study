import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        
        Arrays.sort(strings, (s1, s2) -> {
            if(s1.charAt(n) != s2.charAt(n)){
                return s1.charAt(n) - s2.charAt(n);
            }
            return s1.compareTo(s2);
        });
        
        answer = strings;
        return answer;
    }
}