package Arrays_Part_II;

/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function,
but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n,
where the first m elements denote the elements that should be merged,
and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Example 2:
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].

Example 3:
Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1.
The 0 is only there to ensure the merge result can fit in nums1.


Constraints:
nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-10^9 <= nums1[i], nums2[j] <= 10^9

Follow up: Can you come up with an algorithm that runs in O(m + n) time?
*/

import java.util.Arrays;

public class MergeSortedArray {

    // Approach 1: Brute Force - Copy the first m elements of nums1 and all elements of nums2 into new array
    // Sort the result array and copy the sorted values back into nums1;
    // TC => O((M + N)Log(M + N))
    // SC => O(M + N)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        for (int i = 0; i < m; i++)
            res[i] = nums1[i];
        for (int i = 0; i < n; i++)
            res[m + i] = nums2[i];
        Arrays.sort(res);
        for(int i = 0; i < m + n; i++) {
            nums1[i] = res[i];
        }
    }

    // Approach: Two Pointer - tracking from the end of both the arrays and add at the end of nums1 if the value is greater
    // TC => O(M + N)
    // SC => O(1)
    public void mergeTwoPointer(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // index with last valid value in nums1
        int j = n - 1; // last index in nums2
        int k = m + n - 1; // last index in nums1
        while(j >= 0) {
            if(i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
                k--;
            } else {
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }
    }
}
