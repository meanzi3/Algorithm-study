class Result {  
  public static int palindromeIndex(String s) {
  // Write your code here
  int left = 0;
  int right = s.length() - 1;

  while(left <= right){
    if(s.charAt(left) != s.charAt(right)){
      break;
    }
    left ++;
    right --;
  } // 투 포인터를 이용하여 문자열이 달라지는 부분을 구함.

  if(left > right){
    return -1;
  } // 이미 팰린드롬이라는 뜻

  int leftCpy = left;
  int rightCpy = right;
  leftCpy ++; // 왼쪽 문자 제거 후 확인

  while(leftCpy < rightCpy){
    if(s.charAt(leftCpy) != s.charAt(rightCpy)){
      return right; // 불일치 하는 부분이 있다면 오른쪽 문자를 제거해야 한다는 뜻
    }
    leftCpy ++;
    rightCpy --;
  }

  return left; // 왼쪽 문자 제거
  }
}
