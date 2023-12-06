import java.util.*;

class Solution {
    
    private boolean isPrime(int num){
        if(num <= 1) return false;
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
    
    private void getPrimes(int num, int[] numbers, boolean[] isUsed, Set<Integer> primes){
        
        // 현재까지 만든 수가 소수면 집합에 추가
        if(isPrime(num)) primes.add(num);
        
        for(int i = 0; i < numbers.length; i++){
            if(isUsed[i]) continue;
            int nextNum = num * 10 + numbers[i];
            // 종이 조각 사용여부 갱신
            isUsed[i] = true;
            
            getPrimes(nextNum, numbers, isUsed, primes);
            
            isUsed[i] = false;
        }
    }
    
    public int solution(String numbers) {
        
        Set<Integer> primes = new HashSet<>();

        int[] nums = numbers.chars()
            .map(c -> c - '0')
            .toArray();
        
        getPrimes(0, nums, new boolean[nums.length], primes);
        
        int answer = primes.size();
        return answer;
    }
}