package Arrays;

/*
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
For example, for arr = [1,2,3], the following are all the permutations of arr:
[1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically
greater permutation of its integer.
More formally, if all the permutations of the array are sorted in one container
according to their lexicographical order, then the next permutation of that
array is the permutation that follows it in the sorted container.
If such arrangement is not possible, the array must be rearranged as the
lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1]
does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.
The replacement must be in place and use only constant extra memory.

Example 1:
Input: nums = [1,2,3]
Output: [1,3,2]

Example 2:
Input: nums = [3,2,1]
Output: [1,2,3]

Example 3:
Input: nums = [1,1,5]
Output: [1,5,1]

Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 100
*/

public class NextPermutation {

    // Approach 1: Brute force - generate all permutations and sort them and return the permutation that is after the input
    // Not efficient at all for large inputs
    // TC => O(N!)

    // Approach 2: Two Pointer
    // TC => O(N)
    public void nextPermutation(int[] nums) {
        // Step 1: Find the first index 'i' from the right such that nums[i] < nums[i + 1]
        // This is the point where the next permutation can be formed
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]) {
            i--; // Keep moving left until a decreasing point is found
        }

        // Step 2: If such an index 'i' exists (i.e., the array is not entirely in descending order)
        if(i >= 0) {
            // Find the next greater element than nums[i] to the right of i
            int j = nums.length - 1;
            while(nums[j] <= nums[i]) {
                j--; // Move left until a number just larger than nums[i] is found
            }
            // Step 3: Swap nums[i] and nums[j] to make a slightly bigger permutation
            swap(nums, i, j);
        }
        // Step 4: Reverse the subarray to the right of i (or the entire array if no such 'i')
        // This ensures the smallest possible ordering after index 'i'
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int nums[], int start, int end) {
        while(start < end) {
            swap(nums, start++, end--);
        }
    }

}
