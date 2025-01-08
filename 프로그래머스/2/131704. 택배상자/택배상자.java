import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        int n = order.length; // 택배 상자 개수
        
        int orderIndex = 0; // 순서 인덱스
        
        Stack<Integer> stack = new Stack<>(); // 보조 컨테이너 벨트 스택
        
        for(int i = 1; i <= n; i++){
            stack.push(i); // 보조 컨테이너 벨트에 넣기
            
            while(!stack.isEmpty()){
                // 보조 컨테이너 벨트의 맨 앞 상자가 순서와 일치하는지
                if(stack.peek() == order[orderIndex]){
                    stack.pop();
                    answer++;
                    orderIndex++; // 싣기
                } else { // while문 탈출
                    break;
                }
            }
        }
        
        return answer;
    }
}