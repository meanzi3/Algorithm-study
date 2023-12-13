import java.util.*;

class Solution {
    
    static HashMap<String, Integer> hMap = new HashMap<>(); // 조합, 주문된 수
    static ArrayList<String> answerList = new ArrayList<>(); // 정답 리스트
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        // course 배열의 수만큼 반복
        for(int i : course){
            // 주문 하나씩 확인
            for(String order : orders){
                char[] chars = order.toCharArray(); // 주문 문자열을 문자 배열로 변환
                Arrays.sort(chars); // 오름차순 미리 정렬
                
                dfs(0, "", chars, i);
            }
            
            if(!hMap.isEmpty()){
                List<Integer> countList = new ArrayList<>(hMap.values()); // 해시맵의 value로 countlist 구성
                int max = Collections.max(countList);
                if(max > 1){
                    for(String key: hMap.keySet()){
                        if(hMap.get(key) == max){
                            answerList.add(key);
                        }
                    }
                }
                
            }
            hMap.clear();
        }
        
        Collections.sort(answerList);
        answer = new String[answerList.size()];
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    static void dfs(int depth, String course, char[] chars, int i){
        
        // 조합한 메뉴의 갯수가 course 배열의 요소의 갯수가 된다면
        if(course.length() == i){
           if(hMap.containsKey(course)) {
               hMap.put(course, hMap.get(course) + 1); // 이미 해시 맵에 있으면 value값 + 1
           } else{
               hMap.put(course, 1); // 없으면 새로 저장
           }
            return ;
        }
        
        
        if(depth >= chars.length){
            return;
        }
        
        dfs(depth + 1, course + chars[depth], chars, i); // 선택 했을 때
        dfs(depth + 1, course, chars, i); // 선택 안했을 때
    }
}