class Solution {
    public String solution(String s, int n) {
        
        // 입력 받은 문자열의 모든 문자에 대해서 반복한다.
        StringBuilder builder = new StringBuilder();
        for(char c : s.toCharArray()){
            // 알파벳이 아닌 경우, 문자를 그대로 이어 붙인다. (공백)
            if(!Character.isAlphabetic(c))  {
                builder.append(c);
            }
            // 알파벳인 경우, n만큼 밀어 이어 붙인다.
            else{
                // 대소문자 구분
                int offset = Character.isUpperCase(c) ? 'A' : 'a';
                int position = c - offset; // 알파벳의 변환된 값을 계산
                // position을 n만큼 밀어준다.
                position = (position + n) % ('Z' - 'A' + 1); // 마지막 위치에 도달할 시 0부터 다시 시작.
                // 처음에 구한 offset과 position을 이용해 n만큼 밀린 문자를 만들어 붙인다.
                builder.append((char) (offset + position));
                  
            }
        }
        
        return builder.toString();
    }
}