class Solution {
    static int[] answer;
    
    // 영역 안의 값이 같은지 다른지 검사.
    private boolean isSame(int x, int y, int size, int[][] arr){
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(arr[j][i] != arr[y][x])
                    return false;
            }
        }
        return true;
    }
    
    private void quad(int x, int y, int size, int[][] arr){
        // 다 같으면
        if(isSame(x, y, size, arr)){
            answer[arr[y][x]]++;
            return;
        }
        
        // 다르면
        
        size = size / 2;
        
        quad(x, y, size, arr);
        quad(x + size, y, size, arr);
        quad(x, y + size, size, arr);
        quad(x + size, y + size, size, arr);
        
    }
    public int[] solution(int[][] arr) {
        answer = new int[2];
        
        quad(0, 0, arr.length, arr);
        
        return answer;
    }
}