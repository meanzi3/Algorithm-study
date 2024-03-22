class Solution {
    static int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        
        boolean[] visited = new boolean[words.length];
        dfs(0, 0, begin, target, words, visited);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    private static void dfs(int index, int count, String begin, String target, String[] words, boolean[] visited){
        // 종료 조건
        if(begin.equals(target)){
            answer = Math.min(answer, count);
        }
        for(int i = 0; i < words.length; i++){
            // 이미 방문했거나, 1글자 차이가 아니거나, answer가 count보다 작다면 
            if(visited[i] || !checkWord(begin, words[i]) || answer <= count){
                continue;
            }
            visited[i] = true;
            dfs(i, count + 1, words[i], target, words, visited);
            visited[i] = false;
        }
    }
    
    // 한 단어만 다른지 확인하는 함수
    private static boolean checkWord(String s1, String s2){
        int difference = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i))    difference++;
        }
        
        if(difference > 1) return false;
        return true;
    }
}