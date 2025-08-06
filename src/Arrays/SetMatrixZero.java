package Arrays;

/*
Given an m x n integer matrix, matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.

Example 1
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

Constraints:
m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-2^31 <= matrix[i][j] <= 2^31 - 1

Follow up:
A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/

import java.util.HashSet;

public class SetMatrixZero {

    // Approach 1: Using HashSets to mark the 0 rows and columns
    // TC => O(M * N)
    // SC => O(M + N)
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        HashSet<Integer> zeroRows = new HashSet<>();
        HashSet<Integer> zeroCols = new HashSet<>();

        // Mark rows and columns
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                if(matrix[row][col] == 0) {
                    zeroRows.add(row);
                    zeroCols.add(col);
                }
            }
        }

        // set zeroes
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                if(zeroRows.contains(row) || zeroCols.contains(col)) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    // Approach 2: In-Place Marking using First Row and First Column as Flags
    // TC => O(M * N)
    // SC => O(1)
    public void setZeroesOptimized(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Flags to remember if the first row or first column originally had any zeros
        boolean rowZero = false;
        boolean colZero = false;

        // Check if the first column contains any zeros
        for(int i = 0; i < n; i++) {
            if(matrix[i][0] == 0)
                colZero = true;
        }

        // Check if the first row contains any zeros
        for(int i = 0; i < m; i++) {
            if(matrix[0][i] == 0)
                rowZero = true;
        }

        // Use the first row and column to mark zeroes
        for(int row = 1; row < n; row++) {
            for(int col = 1; col < m; col++) {
                if(matrix[row][col] == 0) {
                    matrix[row][0] = 0; // Mark the row
                    matrix[0][col] = 0; // Mark the column
                }
            }
        }

        // Use the markers to set zeroes in the matrix
        for(int row = 1; row < n; row++) {
            for(int col = 1; col < m; col++) {
                if(matrix[row][0] == 0 || matrix[0][col] == 0)
                    matrix[row][col] = 0;
            }
        }

        // If the first column had a zero, set the entire first column to zero
        if(colZero) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

        // If the first row had a zero, set the entire first row to zero
        if(rowZero) {
            for (int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
