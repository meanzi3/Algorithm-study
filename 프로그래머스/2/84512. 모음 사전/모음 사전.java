import java.util.*;

class Solution {
    private static final char[] group = new char[] {'A', 'E', 'I', 'O', 'U'};
    
    private List<String> generate(String word){
        List<String> words = new ArrayList<>();
        words.add(word);
        
        if(word.length() == 5) return words;
        
        for(char c : group){
            words.addAll(generate(word + c));
        }
        
        return words;
    }
    public int solution(String word) {
        int answer = generate("").indexOf(word);
        return answer;
    }
}