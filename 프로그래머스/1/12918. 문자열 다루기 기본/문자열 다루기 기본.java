class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if(!s.matches("[0-9]{4}|[0-9]{6}")) answer = false;
        return answer;
    }
}