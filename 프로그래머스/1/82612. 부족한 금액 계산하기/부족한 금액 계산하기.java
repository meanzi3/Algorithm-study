class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long needMoney = 0;

        for(int i = 1; i <= count; i++){
            needMoney += (i * price);
        }
        
        if((money - needMoney) < 0) answer = (money - needMoney) * -1;
        else answer = 0;
        
        return answer;
    }
}