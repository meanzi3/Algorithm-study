import java.util.*;

class Result {
  /*
  * Complete the 'flippingMatrix' function below.
  *
  * The function is expected to return an INTEGER.
  * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
  */
  public static int flippingMatrix(List<List<Integer>> matrix) {
    // Write your code here
    int n = matrix.size();
    int max = 0;

    for(int i = 0; i < n/2; i++){
      for(int j = 0; j < n/2; j++){
        max += Math.max(matrix.get(i).get(j), Math.max(matrix.get(i).get(n-1-j), Math.max(matrix.get(n-1-i).get(j), matrix.get(n-1-i).get(n-1-j))));
      }
    }

    return max;
  }
}
