class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
 
        // s가 "1"이 될 때까지 반복
        while(!s.equals("1")) {

          int ones = 0;
          for(int i=0; i<s.length(); i++) {
            // 0의 갯수 세기, 배열에 저장
            if(s.charAt(i) == '0') answer[1]++;
            // 1의 갯수 세기
            else ones++;
          }

          // 1의 갯수로 2진 변환
          s = Integer.toString(ones, 2);
          answer[0]++;
        }
        return answer;
    }
}