class Solution {
    
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        // 배열, depth, target 숫자, 지금까지 만든 숫자로 dfs한다.
        dfs(numbers, 0, target, 0);
        
        return answer;
    }
    
    private static void dfs(int[] numbers, int depth, int target, int result){
        // 배열 끝까지 가면 종료
        if(depth == numbers.length){
            if(result == target){
                // 만든 숫자가 target 숫자와 같으면 answer + 1
                answer ++;
            }
            // 종료
            return ;
        }
        
        // 다음 숫자를 더했을 때
        dfs(numbers, depth+1, target, result + numbers[depth]);
        // 다음 숫자를 뺏을 때
        dfs(numbers, depth+1, target, result - numbers[depth]);
        
    }
}
