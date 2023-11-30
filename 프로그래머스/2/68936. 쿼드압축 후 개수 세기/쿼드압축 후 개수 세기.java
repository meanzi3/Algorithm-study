class Solution {
    private static class Count{
        public final int zero;
        public final int one;
        
        public Count(int zero, int one){
            this.zero = zero;
            this.one = one;
        }
        
        // 두 Count 객체를 합함
        public Count add(Count other){
            return new Count(zero + other.zero, one + other.one);
        }
    }
    
    private Count count(int offsetX, int offsetY, int size, int[][] arr){
        
        int h = size / 2;
        
        // 모두 같은 값인지 검사
        for(int x = offsetX; x < offsetX + size; x++){
            for(int y = offsetY; y < offsetY + size; y++){
                if(arr[y][x] != arr[offsetY][offsetX]){
                    // 원소가 다 같은 값이 아니라면
                    return count(offsetX, offsetY, h, arr) 
                        .add(count(offsetX + h, offsetY, h, arr))
                        .add(count(offsetX, offsetY + h, h, arr))
                        .add(count(offsetX + h, offsetY + h, h, arr));
                }
            }
        }
        
        // 같은 값이라면 
        // 1일 때
        if(arr[offsetY][offsetX] == 1){
            return new Count(0, 1);
        }
        // 0일 때
        return new Count(1, 0);
    }
    public int[] solution(int[][] arr) {
        Count count = count(0, 0, arr.length, arr);
        int[] answer = new int[] {count.zero, count.one};
        return answer;
    }
}