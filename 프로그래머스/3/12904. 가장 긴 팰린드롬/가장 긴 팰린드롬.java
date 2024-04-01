class Solution {
    public int solution(String s) {
        int maxLength = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            // 팰린드롬이 홀수 길이인 경우
            int len1 = expandAroundCenter(s, i, i);
            // 팰린드롬이 짝수 길이인 경우
            int len2 = expandAroundCenter(s, i, i + 1);
            maxLength = Math.max(maxLength, Math.max(len1, len2));
        }
        
        return maxLength;
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 팰린드롬이 끝날 때 left와 right는 실제로 한 칸씩 더 나아가게 되므로 (right - 1) - (left + 1) + 1 = right - left - 1의 길이가 팰린드롬의 길이
        return right - left - 1;
    }
}
