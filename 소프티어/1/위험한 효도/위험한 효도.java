import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); 
        
        int a = sc.nextInt(); // 뒤돌아있는 시간
        int b = sc.nextInt(); // 앞을 보고 있는 시간
        // 술래를 터치한 순간 a와 b가 바뀐다. 
        
        int d = sc.nextInt(); // 술래와 남우 사이 거리
        int dd = d; // 남은 거리 계산에 이용

        int answer = 0; // 정답, 총 걸리는 시간 

        // 터치할 때 까지
        while(dd > 0){
            if(dd - a > 0){
                dd = dd - a; // 남은 거리 갱신
                answer += a; // 뒤 돌아 있는 동안 가는 시간             
                answer += b; // 앞을 보는 동안 가는 시간
            } else{
                answer += dd; // 남은 거리 만큼 가서 터치
                dd = 0;
            }
        }

        // 터치 후
        dd = d;
        while(dd > 0){
            if(dd - b > 0){
                dd = dd - b; // 남은 거리 갱신
                answer += b; // 뒤 돌아 있는 동안 가는 시간             
                answer += a; // 앞을 보는 동안 가는 시간
            } else{
                answer += dd; // 남은 거리 만큼 가서 터치
                dd = 0;
            }
        }

        System.out.println(answer);
    }
}