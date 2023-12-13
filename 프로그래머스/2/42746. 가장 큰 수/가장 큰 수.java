import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
       
        String answer = Arrays.stream(numbers)
                            .mapToObj(String::valueOf)
                            .sorted((s1, s2) -> (s2+s1).compareTo(s1+s2))
                            .collect(Collectors.joining(""))
                            .replaceAll("^0+", "0");
        return answer;
    }
}