class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int pNum = 0;
        int yNum = 0;
        
        for(char c : s.toLowerCase().toCharArray()){
            switch(c) {
                case 'p' : pNum++; break;
                case 'y' : yNum++; break;
            }
        }
        
        return pNum == yNum;
    }
}