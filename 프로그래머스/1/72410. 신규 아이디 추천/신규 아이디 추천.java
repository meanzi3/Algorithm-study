class Solution {
    public String solution(String new_id) {
        String answer = "";
        // 1단계
        new_id = new_id.toLowerCase();
        
        // 2단계
        new_id = new_id.replaceAll("[^a-z0-9\\-_.]", "");
        
        // 3단계
        new_id = new_id.replaceAll("\\.{2,}", ".");
        
        // 4단계
        new_id = new_id.replaceAll("^\\.+|\\.+$","");
        
        // 5단계
        if(new_id.equals("")) new_id = "a";
        
        // 6단계
        if(new_id.length() >= 16){
            // 첫 15개 빼고 제거
            new_id = new_id.substring(0, 15);
            
            // 마침표가 끝에 있으면 제거
            new_id = new_id.replaceAll("\\.+$","");
        }
        
        // 7단계
        while(new_id.length() < 3){
            // 마지막 문자를 길이가 3이 될때까지 반복
            new_id += new_id.charAt(new_id.length() -1);
        }
        
        answer = new_id;
        return answer;
    }
}