class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            int sum = 0;
            for(int j = 1; j <= i; j++){
                // 약수일 때
                if(i % j == 0){
                    sum++;
                }
            }
            
            // 약수의 개수가 짝수면 더한다.
            if(sum % 2 == 0) answer += i;
            
            // 약수의 개수가 홀수면 뺀다
            else answer -= i;
            
        }
        return answer;
    }
}