import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        int answer = 0;
        int sum = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int truck : truck_weights){
            
            while(true){
                // 다리에 아무 트럭도 없을 때
                if(q.isEmpty()){
                    q.offer(truck);
                    sum += truck;
                    answer++;
                    break;
                } else if(q.size() == bridge_length) { // 다리에 트럭이 다 찼을 때
                    sum -= q.poll();
                } else { // 다리에 자리가 있을 때 
                    if(sum + truck <= weight){ // 다음 트럭 추가할 수 있을 때
                        q.offer(truck);
                        sum += truck;
                        answer++;
                        break;
                    } else { // 다음 트럭을 추가할 수 없을 때
                        q.offer(0);
                        answer++;
                    }
                }
            }
        } // 마지막 트럭까지 다리에 추가되면 끝남
        
        // 마지막 트럭이 트럭을 다 지나는 시간 추가
        answer += bridge_length;
        
        return answer;
    }
}