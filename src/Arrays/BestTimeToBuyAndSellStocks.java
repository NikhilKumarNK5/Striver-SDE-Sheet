package Arrays;

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock
and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction.
If you cannot achieve any profit, return 0.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.

Constraints:
1 <= prices.length <= 10^5
0 <= prices[i] <= 10^4
*/

public class BestTimeToBuyAndSellStocks {
    // Approach 1: Brute Force - try every possible pair
    // TC = > O(N^2) - results in TLE
    // Sc => O(1)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0; // in case of no transaction it should be 0
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(prices[j] - prices[i] > maxProfit)
                    maxProfit = prices[j] - prices[i];
            }
        }
        return maxProfit;
    }

    // Approach 2: Optimized Linear Approach
    // TC => O(N)
    // SC => O(1)
    public int maxProfitOptimized(int[] prices) {
        int n = prices.length;
        int buyPrice = prices[0]; // initial buy price
        int maxProfit = 0;


        for(int i = 1; i < n; i++) {
            if(prices[i] < buyPrice)
                buyPrice = prices[i]; //  if we find any price that is less than the current buy price then we make that the buyprice
            else {
                int currProfit = prices[i] - buyPrice; // calculates the currentProfit
                maxProfit = Math.max(maxProfit, currProfit); // calculates the maxProfit
            }
        }

        return maxProfit;
    }
}
