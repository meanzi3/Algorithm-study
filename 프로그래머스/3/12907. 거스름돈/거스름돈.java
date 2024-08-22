class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        
        int[][] dp = new int[money.length+1][n+1]; // dp 배열 생성
        
        for(int i = 1 ; i < dp.length; i++){
            for(int j = 0 ; j < dp[0].length; j++){    
                if(j == 0){
                    // 초기값 세팅
                    dp[i][j] = 1;
                } else if (j - money[i - 1] >= 0){
                    // 이전의 동전들 + 현재 동전으로 만들 수 있는 경우
                    dp[i][j] = dp[i - 1][j] + dp[i][j - money[i - 1]] % 1000000007;
                } else{
                    // 이전의 동전들로만 만들 수 있는 경우
                    dp[i][j] = dp[i - 1][j] % 1000000007;
                }
            }
        }
        
        answer = dp[money.length][n];
        
        return answer;
    }
}