import java.util.*;

class Solution {
    
    public class Plan {
        String name;
        int start;
        int playTime;
        
        public Plan(String name, String start, String playTime){
            this.name = name;
            String[] time = start.split(":");
            this.start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]); // 분 단위 int형으로 변경
            this.playTime = Integer.parseInt(playTime);
        }
        
        public Plan(String name, int playTime){
            this.name = name;
            this.playTime = playTime;
        }
        
    }
    
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        
        // 시간이 쭉 가다가 시작하기로 한 과제가 있다면 시작 -> priority queue
        // 새로운 과제를 시작해야 한다면 진행 중이던 과제를 멈춤
        // 완료 후 잠시 멈춘 과제가 있으면 이어서 -> 새로 시작해야 하는 과제가 있으면 먼저
        // 멈춰둔 과제가 여러 개라면 가장 최근에 멈춘 과제 부터 -> stack
        
        PriorityQueue<Plan> pq = new PriorityQueue<>(
            (o1, o2) -> (o1.start - o2.start)
        ); // 시작 시간 순
        
        Plan[] plan = new Plan[plans.length];
        for(int i = 0; i < plans.length; i++){
            plan[i] = new Plan(plans[i][0], plans[i][1], plans[i][2]);
            pq.add(plan[i]);
        }
        
        Stack<Plan> stack = new Stack<>();
        
        while(!pq.isEmpty()){
            Plan curr = pq.poll();
            
            String currName = curr.name;
            int currStart = curr.start;
            int currPlayTime = curr.playTime;
            
            // 현재 시각
            int currentTime = currStart;
            
            if(!pq.isEmpty()){
                Plan nextPlan = pq.peek();
                
                // 현재 과제를 끝내고도 다음 과제 시작 까지 시간이 남으면
                if(currentTime + currPlayTime < nextPlan.start){
                    answer.add(currName); // 정답 리스트에 추가
                    currentTime += currPlayTime;  // 현재 시간 갱신
                    // 멈춘 과제가 있으면 남는 시간 동안 진행
                    while(!stack.isEmpty()){
                        Plan stopPlan = stack.pop();
                        
                        // next plan 시작 전까지 끝낼 수 있으면
                        if(currentTime + stopPlan.playTime <= nextPlan.start){
                            answer.add(stopPlan.name); // 정답 리스트에 추가
                            currentTime += stopPlan.playTime; // 현재 시간 갱신
                            continue; // 다음 스택 확인
                        } else {
                            // 남은 시간 갱신 후 stack에 다시 추가
                            int time = stopPlan.playTime - (nextPlan.start - currentTime);
                            stack.push(new Plan(stopPlan.name, time));
                            break; // 스택 확인 종료
                        }
                    }
                }
                // 현재 과제를 끝낸 시간과 새로운 과제 시작 시간이 같다면
                else if(currStart + currPlayTime == nextPlan.start){
                    answer.add(currName); // 정답 리스트에 추가
                    continue;
                }
                // 새로운 과제 시작 전 현재 과제를 못 끝낸다면
                else {
                    int time = nextPlan.start - currentTime;
                    stack.push(new Plan(currName, currPlayTime - time));
                    // 남은 시간 갱신 후 stack에 저장
                }
            }
            
            // 더 이상 남아있는 새로운 과제가 없다면
            else {
                // stack에 있는 과제도 없으면
                if(stack.isEmpty()){
                    currentTime += currPlayTime;
                    answer.add(currName);
                } else {
                    answer.add(currName);
                    while(!stack.isEmpty()){
                        Plan stop = stack.pop();
                        answer.add(stop.name);
                    }
                }
            }
        }
        
        // 과제를 끝낸 순서대로 리턴
        return answer.toArray(new String[0]);
        // Object[] 배열을 직접 String[] 배열로 변환할 수 없음. 
    }
}