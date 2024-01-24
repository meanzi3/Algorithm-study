import java.util.*;

class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        char[] beforeChar = before.toCharArray();
        char[] afterChar = after.toCharArray();
        
        Arrays.sort(beforeChar);
        Arrays.sort(afterChar);
        
        if(String.valueOf(beforeChar).equals(String.valueOf(afterChar)))
            answer = 1;
        
        return answer;
    }
}