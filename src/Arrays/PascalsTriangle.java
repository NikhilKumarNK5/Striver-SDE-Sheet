package Arrays;

/*
Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:
Input: numRows = 1
Output: [[1]]

Constraints:

1 <= numRows <= 30
*/

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    // Approach 1: Brute Force - building each row and filling element up to n rows
    // TC => O(N^2)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i)
                    row.add(1);
                else
                    row.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
            }
            list.add(row);
        }
        return list;
    }

    // Approach 2: Combinatorics Approach
    /*
        Dry Run for generate(5):

        numRows = 5
        We want to generate Pascal's Triangle with 5 rows.

        ------------------------------------------------------
        i = 0
        Initialize: val = 1
        j = 0 → row = [1]
        Final row: [1]
        list = [[1]]

        ------------------------------------------------------
        i = 1
        Initialize: val = 1
        j = 0 → row = [1], val = 1 * (1 - 0) / (0 + 1) = 1
        j = 1 → row = [1, 1]
        Final row: [1, 1]
        list = [[1], [1, 1]]

        ------------------------------------------------------
        i = 2
        Initialize: val = 1
        j = 0 → row = [1], val = 1 * (2 - 0) / (0 + 1) = 2
        j = 1 → row = [1, 2], val = 2 * (2 - 1) / (1 + 1) = 1
        j = 2 → row = [1, 2, 1]
        Final row: [1, 2, 1]
        list = [[1], [1, 1], [1, 2, 1]]

        ------------------------------------------------------
        i = 3
        Initialize: val = 1
        j = 0 → row = [1], val = 1 * (3 - 0) / (0 + 1) = 3
        j = 1 → row = [1, 3], val = 3 * (3 - 1) / (1 + 1) = 3
        j = 2 → row = [1, 3, 3], val = 3 * (3 - 2) / (2 + 1) = 1
        j = 3 → row = [1, 3, 3, 1]
        Final row: [1, 3, 3, 1]
        list = [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1]]

        ------------------------------------------------------
        i = 4
        Initialize: val = 1
        j = 0 → row = [1], val = 1 * (4 - 0) / (0 + 1) = 4
        j = 1 → row = [1, 4], val = 4 * (4 - 1) / (1 + 1) = 6
        j = 2 → row = [1, 4, 6], val = 6 * (4 - 2) / (2 + 1) = 4
        j = 3 → row = [1, 4, 6, 4], val = 4 * (4 - 3) / (3 + 1) = 1
        j = 4 → row = [1, 4, 6, 4, 1]
        Final row: [1, 4, 6, 4, 1]
        list = [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]

        ------------------------------------------------------

        Final Output:
        [
          [1],
          [1, 1],
          [1, 2, 1],
          [1, 3, 3, 1],
          [1, 4, 6, 4, 1]
        ]
    */
    // TC => O(N^2)
    public List<List<Integer>> generateUsingCombinatorics(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            long val = 1;
            for(int j = 0; j <= i; j++) {
                row.add((int) val);
                val = val * (i - j) / (j + 1);
            }
            list.add(row);
        }
        return list;
    }
}
