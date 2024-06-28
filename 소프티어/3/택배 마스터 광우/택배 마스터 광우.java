import java.io.*;
import java.util.*;

public class Main {

    private static int N, M, K;
    private static int[] rails;
    private static boolean[] visited;
    private static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 레일 개수
        M = sc.nextInt(); // 택배 바구니 무게
        K = sc.nextInt(); // 일의 시행 횟수

        rails = new int[N]; // 택배 레일의 전용 무게

        for(int i = 0; i < N; i++){
            rails[i] = sc.nextInt();
        }

        visited = new boolean[N];
        answer = Integer.MAX_VALUE;

        int[] newRails = new int[N]; // 새로 정의할 레일 순서
        
        // dfs 탐색
        dfs(0, newRails);

        System.out.println(answer);
        
    }

    // 레일 순서 정하기 (순열 만들기)
    private static void dfs(int depth, int[] newRails){
        // 종료 조건
        if(depth == N){
            // 새로 정의된 배열로 무게 구하기
            int weight = getWeight(newRails);
            // 최솟값 갱신
            answer = Math.min(answer, weight);
            return;
        }

        // 순열 만들기
        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                newRails[depth] = rails[i];
                dfs(depth + 1, newRails);
                // 백트래킹
                visited[i] = false;
            }
        }
    }

    // 들어야 하는 무게 구하기
    private static int getWeight(int[] newRails){
        int idx = 0;
        int result = 0; // 총 무게
        for(int i = 0; i < K; i++){
            int weight = 0; // 한 번에 담을 무게
            while(weight + newRails[idx] <= M){ // 택배 바구니 무게 넘는지 확인
                weight += newRails[idx];
                idx = (idx + 1) % N; // 인덱스 조정
            }
            result += weight;
        }
        return result;
    }
}