import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        // 종류를 키, 갯수를 value로
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        } 
        
        // n개 중에 하나 고르는 경우 + 안고르는 경우
        for(int n : map.values()){
            answer *= n+1;
        }
        
        // 하나도 안고르는 경우 빼줌
        return answer - 1;
        
    }
}