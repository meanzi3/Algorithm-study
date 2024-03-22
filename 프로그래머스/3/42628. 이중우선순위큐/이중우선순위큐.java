import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < operations.length; i++){
            if(operations[i].charAt(0) == 'I'){
                minHeap.add(Integer.parseInt(operations[i].substring(2)));
                maxHeap.add(Integer.parseInt(operations[i].substring(2)));
            } else if(operations[i].equals("D 1")){
                minHeap.remove(maxHeap.poll()); // maxHeap 에서 최대값 삭제, 리턴하고 minHeap에서도 같은 값을 삭제
            } else{
                maxHeap.remove(minHeap.poll()); // minHeap 에서 최소값 삭제, 리턴하고 maxHeap에서도 같은 값을 삭제
            }
        }
        
        if(minHeap.isEmpty()){
            answer = new int[] {0,0}; 
        } else{
            answer = new int[] { maxHeap.peek(), minHeap.peek()};
        }
        return answer;
    }
}