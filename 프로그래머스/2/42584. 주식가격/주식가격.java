import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> stack = new Stack<>();
        
        // for문을 돌면서 떨어졌을 경우에는 answer에 넣고, 증가하거나 동일할 경우에는 stack에 넣는다. 
        for(int i = 0; i < prices.length; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int index = stack.pop();
                answer[index] = i - index;
            }
            
            stack.push(i);
        }
        
        
        while(!stack.isEmpty()){
            int index = stack.pop();
            answer[index] = prices.length - index - 1;
        }
        
        return answer;
    }
}