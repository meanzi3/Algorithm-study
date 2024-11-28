class Result {
  public static int truckTour(List<List<Integer>> petrolpumps) {
    // Write your code here
    // 그리디로 최선의 답을 구한다.

    int size = petrolpumps.size();
    int remain = 0; // 지정한 시작 지점부터 현재 지점까지 왔을 때 남은 연료
    int start = 0; // 시작 지점

    for(int i = 0; i < size; i++){
      remain += petrolpumps.get(i).get(0) - petrolpumps.get(i).get(1);

      // 현재 연료로 다음 가솔린까지 갈 수 있는지
      if(remain < 0){
        // 갈 수 없다면
        start = i + 1; // 다음 인덱스를 시작 지점으로
        remain = 0; // 남은 연료 0으로 초기화
      }
    }

    return start;
  }
}