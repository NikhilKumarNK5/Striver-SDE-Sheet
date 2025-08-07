package Arrays;

/*
Given an array nums with n objects colored red, white, or blue,
sort them in-place so that objects of the same color are adjacent,
 with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]

Constraints:
n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
Follow up: Could you come up with a one-pass algorithm using only constant extra space
*/

public class SortColors {

    // Approach 1: Brute Force (take extra array)
    // As we know we can either have 0, 1 or 2 as elements so we are traversing in that fashion
    // TC => O(N)
    // SC => O(N)
    public void sortColors(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int start = 0;
        int end = n - 1;

        for(int num : nums) {
            if(num == 0)
                res[start++] = 0;
            else if(num == 2)
                res[end--] = 2;
        }

        // fill the rest with 1
        while(start <= end) {
            res[start++] = 1;
        }

        System.arraycopy(res, 0, nums, 0, n);
    }

    // Approach 2: In-place - Using Three Pointers
    // TC => O(N)
    // SC => O(1)
    public void sortColorsOptimised(int[] nums) {
        int n = nums.length;
        int start = 0;
        int mid = 0;
        int end = n - 1;

        while(mid <= end) {
            switch(nums[mid]) {
                case 0:
                    // if the element at mid is 0 then swap it with the start element
                    swap(nums, start, mid);
                    start++;
                    mid++;
                    break;
                case 1:
                    // if the element at mid is 1 then keep it at mid and move ahead
                    mid++;
                    break;
                case 2:
                    // if the element at mid is 2 then swap it with the end element
                    swap(nums, mid, end);
                    end--;
                    break;
            }
        }
    }

    private void swap(int[] nums, int s, int e) {
        int temp = nums[s];
        nums[s] = nums[e];
        nums[e] = temp;
    }
}
