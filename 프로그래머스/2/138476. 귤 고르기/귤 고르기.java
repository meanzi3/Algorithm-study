import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        // (크기, 갯수)
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        // 갯수를 리스트로 구성, 내림차순 정렬
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
        for(int i = 0; i < list.size(); i++){
            k -= list.get(i); // 갯수만큼 빼기
            answer++; // 종류 수 업데이트
            if(k <= 0) break;
        }
        
        return answer;
    }
}