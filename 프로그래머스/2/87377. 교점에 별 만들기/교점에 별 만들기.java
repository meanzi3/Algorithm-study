import java.util.*;

class Solution {
    // 좌표 객체
    private static class Point{
        public final long x, y;
        
        private Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }

    // 정수인 교점 좌표 객체 반환 함수
    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2){
        // 교점 구하기
        double x = (double) (b1 * c2 - c1 * b2) / (a1 * b2 - b1 * a2);
        double y = (double) (c1 * a2 - a1 * c2) / (a1 * b2 - b1 * a2);
        
        // 정수일 때만
        if(x % 1 != 0 || y % 1 != 0) return null;
        
        // 교점 좌표 객체 반환
        return new Point((long)x, (long)y);
    }
    
    // 리스트에 저장된 교점들에 대해 x, y 좌표의 최댓값, 최솟값 구하기
    private Point getMinimumPoint(List<Point> points){
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        
        for(Point p : points){
            if(p.x < x) x = p.x;
            if(p.y < y) y = p.y;
        }
        
        return new Point(x, y);
    }
    private Point getMaximumPoint(List<Point> points){
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        
        for(Point p : points){
            if(p.x > x) x = p.x;
            if(p.y > y) y = p.y;
        }
        
        return new Point(x, y);
    }
    
    public String[] solution(int[][] line) {
        // 교점좌표 저장할 리스트
        List<Point> points = new ArrayList<>();
    
        // 입력 받은 모든 직선 쌍에 대해 반복
        for(int i = 0; i < line.length; i++){
            for(int j = i+1; j < line.length; j++){
                // 정수인 교점 좌표 리스트에 저장
                Point intersection = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if (intersection != null){
                    points.add(intersection);
                }
            }
        }
    
        Point minimum = getMinimumPoint(points);
        Point maximum = getMaximumPoint(points);
    
        // 별 그릴 2차원 배열의 크기 결정
        int width = (int) (maximum.x - minimum.x + 1);
        int height = (int) (maximum.y - minimum.y + 1);
    
        // 별 그릴 2차원 배열 선언, .으로 초기화
        char[][] arr = new char[height][width];
        for(char[] row : arr){
            Arrays.fill(row, '.');
        }
    
        // 별 그리기
        for(Point p : points){
            int x = (int) (p.x - minimum.x);
            int y = (int) (maximum.y - p.y);
            arr[y][x] = '*';
        }
    
        // 결과 반환
        String[] result = new String[arr.length];
        for(int i = 0; i < result.length; i++){
            result[i] = new String(arr[i]);
        }
        return result;
    }
}