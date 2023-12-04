class Solution {
    public int[] solution(int brown, int yellow) {
        int width = 0;
        int height = 0;
        
        for(int i = 3; i <= 2499; i++){
            for(int j = 3; j <= i; j++){
                if(((i-2)*(j-2) == yellow) &&(((i*j) - ((i-2)*(j-2))) == brown)){
                    width = i;
                    height = j;
                    break;
                }
            }
        }
        int[] answer = new int[] {width, height};
        return answer;
    }
}