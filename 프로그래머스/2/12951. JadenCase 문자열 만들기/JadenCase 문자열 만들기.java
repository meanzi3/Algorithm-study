import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s, " ", true);
        StringBuilder sb = new StringBuilder();
        
        while(st.hasMoreElements()){
            String el = (String) st.nextElement();
            sb.append(el.substring(0, 1).toUpperCase());
            sb.append(el.substring(1, el.length()).toLowerCase());
        }
        
        return sb.toString();
    }
        
}