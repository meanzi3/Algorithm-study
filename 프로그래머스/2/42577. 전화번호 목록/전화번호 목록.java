import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book); // 오름차순 정렬
        
        // 뒤에거가 앞에걸로 시작하는 지 : startsWith() 이용
        for(int i = 0; i < phone_book.length - 1; i++){
            if(phone_book[i+1].startsWith(phone_book[i]))
               return false;
        }
        
        return answer;
    }
}