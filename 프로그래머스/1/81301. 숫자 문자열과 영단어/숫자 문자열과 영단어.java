class Solution {
    private static final String[] words = {
        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };
    public int solution(String s) {
        
        for(int i = 0; i<words.length; i++){
            s = s.replace(words[i], Integer.toString(i));
        }
        
        // 문자열을 정수로 변환
        int answer = Integer.parseInt(s);
        return answer;
    }
}