class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length - 1];
        int min = Integer.MAX_VALUE;
        
        if(arr.length == 1){
            return new int[] {-1};
        } 
        
        // 가장 작은 수 찾기
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min) min = arr[i];
        }
        
        // 정답 배열 인덱스
        int index = 0;
        
        for(int i = 0; i < arr.length ; i++){
            if(arr[i] != min){
                answer[index++] = arr[i];
            }
        }
        return answer;

    }
}