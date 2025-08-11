package Arrays_Part_III;

/*
You are given an m x n integer matrix matrix with the following two properties:
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.
You must write a solution in O(log(m * n)) time complexity.

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-10^4 <= matrix[i][j], target <= 10^4
*/

public class SearchA2DMatrix {

    // Approach 1: Staircase Method
    // TC => O(M + N)
    // SC => O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0;
        int col = n - 1;

        while(row < m && col >= 0) {
            if(matrix[row][col] == target)
                return true;
            else if(matrix[row][col] < target)
                row++;
            else if(matrix[row][col] > target)
                 col--;
        }

        return false;
    }

    // Approach: Since the matrix is sorted and we have to do the solution in O(Log(M * N)) so we will be applying Binary Search
    // TC => O(Log(M * N))
    // SC => O(1)
    public boolean searchMatrixBinarySearch(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] == target)
                return true;
            else if(matrix[row][col] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return false;
    }
}
