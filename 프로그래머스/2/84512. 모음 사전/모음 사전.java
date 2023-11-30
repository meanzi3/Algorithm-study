import java.util.*;

class Solution {
    private static final char[] group = new char[] {'A', 'E', 'I', 'O', 'U'};
    
    private void generate(String word, List<String> words){
        words.add(word);
        
        if(word.length() == 5) return;
        
        for(char c : group){
            generate(word + c, words);
        }
    }
    public int solution(String word) {
        List<String> words = new ArrayList<>();
        generate("", words);
        int answer = words.indexOf(word);
        return answer;
    }
}