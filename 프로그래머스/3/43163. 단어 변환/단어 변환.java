import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        
        Set<String> visited = new HashSet<>();
        visited.add(begin);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String current = queue.poll();
                if(current.equals(target)){
                    return answer;
                }
                
                for(String word : words){
                    if(!visited.contains(word) && isOneDiff(current, word)){
                        visited.add(word);
                        queue.offer(word);
                    }
                }
            }
            answer++;
        }
        
        return 0;
    }
    
    private static boolean isOneDiff(String word1, String word2){
        int diffCount = 0;
        for(int i = 0; i < word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)){
                diffCount++;
            }
        }
        return diffCount == 1;
    }
}