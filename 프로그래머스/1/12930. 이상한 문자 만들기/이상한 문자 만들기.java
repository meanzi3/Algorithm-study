class Solution {
    public String solution(String s) {
        String answer = "";
        
        // 입력 받은 모든 문자열에 대해 반복한다.
        StringBuilder builder = new StringBuilder();
        boolean toUpper = true;
        for(char c : s.toCharArray()){
            // 공백 문자일 경우 그대로 이어붙이고
            if(!Character.isAlphabetic(c)){
                builder.append(c);
                // 공백 다음 문자는 무조건 대문자
                toUpper = true;
            } 
            // 공백이 아닐 경우 대/소문자 변환하여 이어붙이고
            else{
                if(toUpper){
                    builder.append(Character.toUpperCase(c));
                } else{
                    builder.append(Character.toLowerCase(c));
                }
                // 그 다음 문자는 앞서 변환한 문자와 반대
                toUpper = !toUpper;
            }
        }
        
        return builder.toString();
    }
}