import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
//         // 처음 무적권의 갯수만큼 pq에 넣기
//         for(int i = 0; i < k; i++){
//             pq.offer(enemy[i]);
//         }
        
//         // pq에 있는 제일 작은 값과 다음 단게의 적의 수 비교
//         int idx = k;
//         while(idx < enemy.length && n >= enemy[idx]){ // 게임 종료 전까지 반복
//             if(pq.peek() < enemy[idx]) {
//                 // pq에 있는 값이 더 작다면? -> 해당 단계에 무적권을 쓰는게 이득이다. pq에 있는 단계는 그냥 막기.
//                 n -= pq.poll();
//                 // pq에 새로 다음 단계 값을 넣어준다.
//                 pq.offer(enemy[idx]);
//                 answer++;
//             } else {
//                 // 그 외의 경우? -> 해당 단계는 무적권을 쓰면 손해다. 그냥 막기.
//                 n -= enemy[idx];
//                 answer++;
//             }
//             idx++; // 다음 라운드 검사
//         }
        
        for(int i = 0; i < enemy.length; i++){
            if(k > 0){
                pq.offer(enemy[i]);
                k--;
            }   // 처음 무적권의 갯수만큼 pq에 넣기
            else { // 무적권을 다 쓰면
                int enemys = enemy[i]; // 막을 적의 수
                if(pq.peek() < enemy[i]) {
                    // pq에 있는 값이 더 작다면? -> 해당 단계에 무적권을 쓰는게 이득이다. pq에 있는 단계는 그냥 막기.
                    enemys = pq.poll();
                    pq.offer(enemy[i]);
                } 
                
                // 남은 병사 수가 더 많은 지 비교
                if(n >= enemys){
                    n -= enemys; // 병사 수 빼기
                } else  break;
            }
            answer++ ;
        }
        
        return answer;
    }
}