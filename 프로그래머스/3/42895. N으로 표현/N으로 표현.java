import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        // 리스트 초기화 - N을 i번 사용했을 때 만들 수 있는 수를 set에 저장
        List<Set<Integer>> dp = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            dp.add(new HashSet<>());
        } // 최대 8까지
        
        dp.get(1).add(N); // 1번 사용했을 때는 N만 만들 수 있음
        
        for(int i = 2; i < 9; i++){
            Set<Integer> currentSet = dp.get(i);
            for(int j = 1; j <= i; j++){
                // dp[i] = dp[j] 사칙연산 dp[i-j]
                Set<Integer> set1 = dp.get(j);
                Set<Integer> set2 = dp.get(i-j);
                
                for(int Num1 : set1){
                    for(int Num2 : set2){
                        currentSet.add(Num1 + Num2);
                        currentSet.add(Num1 - Num2);
                        currentSet.add(Num1 * Num2);
                            
                        if(Num1 != 0 && Num2 != 0){
                            currentSet.add(Num1 / Num2);
                        }
                    }
                }
            }
            
            // N을 그대로 붙이는 경우 추가
            String string = "";
            for(int k = 0; k < i; k++){
                string += N;
            }
            
            currentSet.add(Integer.parseInt(string));
        }
        
        // 최소값 구함
        for(Set<Integer> set : dp){
            if(set.contains(number)){
                return dp.indexOf(set);
            }
        }
        
        return -1;
    }
}