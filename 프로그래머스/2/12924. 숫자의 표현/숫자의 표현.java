class Solution {
    public int solution(int n) {
        int answer = 1; // 자기 자신 무조건 포함하기
        int sum = 0;
        
        if(n == 1 || n == 2){
            return answer;
        } // 1이나 2일 경우는 무조건 1개
        
        for(int i = 1; i < n / 2 + 1; i++){
            sum = 0;
            int start = i; // 시작 숫자
            while(sum < n){
                sum += start++; 
                if(sum == n) answer++;
            }
            
        }
        return answer;
    }
    
}