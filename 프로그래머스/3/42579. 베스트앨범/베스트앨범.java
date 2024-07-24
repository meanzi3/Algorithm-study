import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        // (장르, 장르별 총 재생 횟수)
        Map<String, Integer> numMap = new HashMap<>();
        
        // (장르(장르에 속하는 노래, 재생 횟수))
        Map<String, Map<Integer, Integer>> musicMap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            numMap.put(genres[i], numMap.getOrDefault(genres[i], 0) + plays[i]);
            
            if(!musicMap.containsKey(genres[i])) {
                musicMap.put(genres[i], new HashMap<>());
            }
            
            musicMap.get(genres[i]).put(i, plays[i]);
        }
        
        // 총 재생 횟수로 내림차순 정렬
        List<String> genresSet = new ArrayList<>(numMap.keySet());
        Collections.sort(genresSet, (s1, s2) -> numMap.get(s2) - numMap.get(s1));
    
        for(String key : genresSet){
            Map<Integer, Integer> map = musicMap.get(key);
            // 노래 별 재생 횟수로 내림차순 정렬
            List<Integer> musicSet = new ArrayList<>(map.keySet());
            Collections.sort(musicSet, (s1, s2) -> map.get(s2) - map.get(s1));
            
            // 정답 배열에 노래 번호 넣기
            answer.add(musicSet.get(0));
            
            // 2개 이상이면 하나 더 넣기
            if(map.size() > 1) {
                answer.add(musicSet.get(1));
            }
            
        }
        
        // list to array
        return answer.stream().mapToInt(i -> i).toArray();
    }
}