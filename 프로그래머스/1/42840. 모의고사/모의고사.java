import java.util.stream.*;

class Solution {
    
    private static final int[][] Rule = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };
    
    private int getAnswers(int person, int problem){
        int[] rule = Rule[person];
        int index = problem % rule.length;
        return rule[index];
    }
    
    public int[] solution(int[] answers) {
                
        int score[] = new int[3]; // 맞힌 갯수 저장
        int max = 0;
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < answers.length; j++){
                if(getAnswers(i, j) == answers[j]){
                  score[i]++;
                } 
            }
            if(score[i] > max) max = score[i];
        }
    
//         // score 배열 돌면서 max인 사람 찾아서 answer 배열에 저장
//         List<Integer> answerList = new ArrayList<>();
//         for(int i = 0; i < 3; i++){
//             // 여러 명이면?? return 값을 오름차순 정렬.....
//             if(score[i] == max){
//                 answerList.add(i + 1);
//             }
//         }
        
//         int[] answer = answerList.stream()
//             .mapToInt(i -> i)
//             .toArray();
        
//         return answer;
        
        final int maxCorrects = max;
        return IntStream.range(0, 3)
            .filter(i -> score[i] == maxCorrects)
            .map(i -> i + 1)
            .toArray();
    }
}