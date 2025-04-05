import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        
        // n을 더하던가, 2를 곱하던가, 3을 곱하던가

        // dp[i] = x를 i로 만들기 위한 최소 횟수 저장
        int[] dp = new int[y+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;
        
        for(int i = x; i <= y; i++){
            
            // 최솟값을 아직 구하지 않았다면 넘어감
            if(dp[i] == Integer.MAX_VALUE)
                continue;
            
            // 최솟값 비교, 갱신
            if(i + n <= y)
                dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
            if(i * 2 <= y)
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            if(i * 3 <= y)
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            
        }
        
        // 최솟값을 구할 수 없으면 -1 반환
        if(dp[y] == Integer.MAX_VALUE)
            return -1;
        
        return dp[y];
    }
}