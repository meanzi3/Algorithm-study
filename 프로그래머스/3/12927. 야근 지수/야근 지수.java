import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        // 큰 값 부터 우선순위
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int sum = 0; // 작업량 합
        
        for(int i = 0; i < works.length; i++){
            pq.add(works[i]);
            sum += works[i];
        }
        
        // n 보다 작거나 같으면 바로 0 리턴
        if(sum <= n){
            return 0;
        }
        
        while(n > 0){
            int tmp = pq.poll();
            tmp--;
            pq.add(tmp);
            n--;
        }
        
        int size = pq.size();
        for(int i = 0; i < size; i ++){
            int tmp = pq.poll();
            answer += (tmp*tmp);
        }
        
        
        return answer;
    }
}