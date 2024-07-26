class Solution {
    private static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        // depth, target, numbers, 만든 숫자 num
        dfs(0, target, numbers, 0);
        
        return answer;
    }
    
    private void dfs(int depth, int target, int[] numbers, int num) {
        // 종료 조건
        if(depth == numbers.length){
            // 만든 수가 target이라면 경우의 수 ++
            if(num == target){
                answer++;
                return;
            }
            return;
        }
        
        // 더하거나 뺴거나
        dfs(depth + 1, target, numbers, num + numbers[depth]);
        dfs(depth + 1, target, numbers, num - numbers[depth]);
    }
}