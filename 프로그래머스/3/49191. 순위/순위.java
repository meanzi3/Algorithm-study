class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] dp = new int[n + 1][n + 1];
        
        for(int i = 0; i < results.length; i++){
            int A = results[i][0];
            int B = results[i][1];
            
            dp[A][B] = 1; // A가 B에게 이김
            dp[B][A] = -1; // B가 A에게 짐
        }
        
        // 플로이드 워셜로 나머지 추측 가능한 승패 구하기
        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n ; k++){
                    if(dp[i][k] == 1 && dp[k][j] == 1){
                        dp[i][j] = 1;
                        dp[j][i] = -1;
                    }
                    if(dp[i][k] == -1 && dp[k][j] == -1){
                        dp[i][j] = -1;
                        dp[j][i] = 1;
                    }
                }
            }
        }
        
        // 각 선수는 n-1개의 승패 정보가 있어야 순위를 확정 지을 수 있음.
        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j = 1; j <= n; j++){
                if(dp[i][j] != 0) cnt++;
            }
            if(cnt == n-1) answer++;
        }
        
        
        return answer;
    }
}