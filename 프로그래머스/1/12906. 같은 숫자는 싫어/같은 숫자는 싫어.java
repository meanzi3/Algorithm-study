import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        
        int curr = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == curr) continue;
            else{
                curr = arr[i];
                q.add(curr);
            }
        }
        
        for(Integer i : q){
            result.add(i);
        }
        
        // int resultSize = q.size();
        // for(int i = 0; i < resultSize; i++){
        //     result.add(q.poll());
        // }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}