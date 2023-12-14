class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxW = 0;
        int maxH = 0;
        
        for(int i = 0; i < sizes.length; i++){
            
            // 큰 길이를 무조건 가로로 회전시키기
            if(sizes[i][0] < sizes[i][1]){
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
            
            // 최대 구하기
            if(sizes[i][0] > maxW){
                maxW = sizes[i][0];
            }
            if(sizes[i][1] > maxH){
                maxH = sizes[i][1];
            }
            
        }
        
        answer = maxW * maxH;
        
        return answer;
    }
}