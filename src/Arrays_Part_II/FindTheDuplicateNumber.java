package Arrays_Part_II;

/*
Given an array of integers nums containing n + 1 integers
where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and using only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3

Example 3:
Input: nums = [3,3,3,3,3]
Output: 3

Constraints:
1 <= n <= 10^5
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely
one integer which appears two or more times.

Follow up:
How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?
*/

import java.util.Arrays;
import java.util.HashSet;

public class FindTheDuplicateNumber {

    // Approach 1: Brute Force - compare each element with every other element and return the number if it is duplicate
    // TC => O(N^2) -> TLE
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j])
                    return nums[i];
            }
        }
        return -1; // never reaches here as duplicate exists in the given array as per the question
    }

    // Approach 2: Sort the array and compare the adjacent elements
    // TC => O(NLogN)
    // SC => O(N) -> we are not allowed to modify the array
    public int findDuplicateSorting(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        for(int i = 0; i < sorted.length - 1; i++) {
            if(sorted[i] == sorted[i + 1])
                return sorted[i];
        }
        return -1; // never reaches here as duplicate exists in the given array as per the question
    }

    // Approach 3: Using HashSet
    // Store the elements of the array in a set and return the element if it already exists in the set
    // TC => O(N)
    // SC => O(N)
    public int findDuplicateSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i]))
                return nums[i];
            else
                set.add(nums[i]);
        }
        return -1; // never reaches here as duplicate exists in the given array as per the question
    }

    // Approach 4: Two pointer (fast and slow pointer) - Floyd’s Tortoise and Hare algorithm (to detect cycles)
    // TC => O(N)
    // SC => O(1)
    public int findDuplicateTwoPointer(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        slow = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
