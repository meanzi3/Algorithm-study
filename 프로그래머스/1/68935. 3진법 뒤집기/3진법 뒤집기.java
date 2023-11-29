class Solution {
    public int solution(int n) {
        
        // n을 3진법으로 포현된 문자열로 변환
        String str = Integer.toString(n, 3);
        
        // 변환한 문자열을 그대로 뒤집는다. (StringBuilder 이용)
        String reversed = new StringBuilder(str).reverse().toString();
        
        // 뒤집은 문자열을 정수(10진법)로 표현하고 return
        int answer = Integer.parseInt(reversed, 3);
        return answer;
    }
}