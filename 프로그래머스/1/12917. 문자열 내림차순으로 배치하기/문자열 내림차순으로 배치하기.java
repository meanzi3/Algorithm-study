import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        // s.chars().boxed() // Stream<Integer>로 변환
        //     .sorted((v1, v2) -> v2 - v1) // 내림차순 정렬
        //     .collect(StringBuilder::new,
        //             StringBuilder::appendCodePoint,
        //             StringBuilder::append)
        //     .toString();
        
        char[] array = s.toCharArray();
        Arrays.sort(array); // 오름차순 정렬
        answer = new StringBuilder(new String(array)).reverse().toString();
        // 역순으로 
        
        return answer;
    }
}