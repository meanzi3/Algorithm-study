import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> queue = new LinkedList<>();
        
        // 큐에 인덱스 번호 넣기
        for(int i = 0; i < progresses.length; i++){
            queue.add(i);
        }
        
        List<Integer> result = new ArrayList<>();
        int days = 0; // 현재 시간
        int count = 0; // 동시에 완료되는 작업 셈
        
        while(!queue.isEmpty()){
            int index = queue.poll();
            
            // 작업 기간 구하기
            int expiration = (int) Math.ceil((double)(100 - progresses[index]) / speeds[index]);
            
            if(expiration > days){
                if(days != 0){
                    result.add(count);
                    count = 0;
                }
                days = expiration; 
            }
            count++;
        }
        
        result.add(count);
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}