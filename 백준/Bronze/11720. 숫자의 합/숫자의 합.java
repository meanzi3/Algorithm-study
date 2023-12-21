import java.util.*;

public class Main{
 public static void main(String[] args)   {
     Scanner sc = new Scanner(System.in);
     
     // 입력값 저장
     int N = sc.nextInt();
     String sNum = sc.next();
     
     // 문자 배열로 변환
     char[] cNum = sNum.toCharArray();
     
     int sum = 0;
     for(int i = 0; i < cNum.length; i++){
         sum += cNum[i] - '0'; // 정수형으로 변환 후 합계 구하기
     }
     
     System.out.print(sum);
 }
}