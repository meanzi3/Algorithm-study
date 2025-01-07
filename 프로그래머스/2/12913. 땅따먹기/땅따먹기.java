class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int N = land.length;
        
        int[][] dp = new int[N][4];
        
        for(int i = 0; i < 4; i++){
            dp[0][i] = land[0][i];
        } // 1행 채우기
        
        for(int i = 1; i < N; i++){
            for(int j = 0; j < 4; j++){
                dp[i][j] = land[i][j] + Math.max(dp[i - 1][(j + 1) % 4], Math.max(dp[i - 1][(j + 2) % 4], dp[i - 1][(j + 3) % 4]));
            }
        }

        answer = Math.max(dp[N - 1][0], Math.max(dp[N - 1][1], Math.max(dp[N - 1][2], dp[N - 1][3])));
        
        return answer;
    }
}