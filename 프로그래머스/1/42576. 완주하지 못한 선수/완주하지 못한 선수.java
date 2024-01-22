import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        
        for(String name : participant){
            // '이름 - 사람 수' 로 map 구성
            // getOrDefault : 찾는 key가 있으면 value를 반환, 없으면 default 값을 반환
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        for(String name : completion){
            // 완주한 사람은 map에서 value 값을 1 빼줌
            // 최종적으로 value가 1인 사람이 남을 것 -> 완주하지 못한 사람
            map.put(name, map.get(name) - 1) ;
            
            if(map.get(name) == 0) map.remove(name);
        }
        
        return map.keySet().iterator().next();
    }
}