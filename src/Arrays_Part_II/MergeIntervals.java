package Arrays_Part_II;

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

Constraints:
1 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= starti <= endi <= 10^4
*/

import java.util.Arrays;
import java.util.ArrayList;

public class MergeIntervals {

    // Approach: Sort the given 2D matrix based upon the start index and then compare currentStart and currentEnd with the future ones and if they overlap then merge otherwise push into the result Arraylist
    // TC => O(NLogN)
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            return Integer.compare(a[0], b[0]);
        });

        int currS = intervals[0][0];
        int currE = intervals[0][1];

        ArrayList<int[]> res = new ArrayList<>();

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= currE) {
                currE = Math.max(currE, intervals[i][1]);
            } else {
                res.add(new int[]{currS, currE});
                currS = intervals[i][0];
                currE = intervals[i][1];
            }
        }
        res.add(new int[]{currS, currE});

        int[][] ans = new int[res.size()][2];

        for(int i = 0; i < res.size(); i++) {
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }

        return ans;
    }
}
