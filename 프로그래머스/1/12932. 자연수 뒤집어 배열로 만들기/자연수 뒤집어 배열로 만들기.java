class Solution {
    public int[] solution(long n) {
        
        // 입력 받은 값을 String형으로 변환
        String str = Long.toString(n);
        
        // 변환한 문자열을 뒤집는다.
        String reversed = new StringBuilder(str).reverse().toString();
        
        // 뒤집은 문자열을 문자 배열로 변환한다.
        char[] chr = reversed.toCharArray();
        
        // 변환한 문자 배열을 정수 배열로 변환하고 반환한다.
        int[] answer = new int[chr.length];
        for(int i = 0; i < answer.length; i++){
            answer[i] = chr[i] - '0';
        }
        return answer;
    }
}