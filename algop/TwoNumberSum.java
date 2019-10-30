package algop;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Input: [3, 5, -4, 8, 11, 1, -1, 6], 10
 * Returns: [-1, 11]
 * Solve in 0(n) time, O(n) space
 */

public class TwoNumberSum {
  public static int[] solve(int[] array, int targetSum) {
    HashMap<Integer, Boolean> values = new HashMap<Integer, Boolean>();
    for (int cur : array) {
      int potentialMatch = targetSum - cur;
      if (values.containsKey(potentialMatch)) {
        return cur > potentialMatch
          ? new int[] {potentialMatch, cur}
          : new int[] {cur, potentialMatch};
      }
      values.put(cur, true);
    }
    return new int[0];
  }

  public static void main(String[] args) {
    int[] input = {3, 5, -4, 8, 11, 1, -1, 6};
    String solution = Arrays.toString(solve(input, 10));

    System.out.println(solution);
  }
}
