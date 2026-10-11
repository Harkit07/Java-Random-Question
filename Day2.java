
public class Day2 {

    // Q1. Buy and Sell Stock (Day 2) - O(n)
    public static int maxProfit(int[] prices) {
        // TODO: write your code here
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > buyPrice) {
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(profit, maxProfit);
            } else {
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }

    // Q2. String Compression (Day 3) - O(n), use StringBuilder
    public static String compress(String str) {
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            res.append(str.charAt(i));
            if (count > 1) {
                res.append(count);
            }
        }
        return res.toString();
    }

    // Q3. Count Set Bits (Day 4) - O(log n)
    public static int countSetBits(int n) {
        int res = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                res++;
            }
            n = n >> 1;
        }
        return res;
    }

    // Q4. Power of n, optimized recursion (Day 6) - O(log n)
    public static long power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        long halfPow = power(x, n / 2);
        long halfPowSq = halfPow * halfPow;
        if (n % 2 != 0) {
            halfPowSq *= x;
        }
        return halfPowSq;
    }

    public static int searchRotatedUtil(int arr[], int tar, int si, int ei) {
        if (si > ei) {
            return -1;
        }
        int mid = si + (ei - si) / 2;
        if (arr[mid] == tar) {
            return mid;
        }
        if (arr[si] <= arr[mid]) {
            if (arr[si] <= tar && tar <= arr[mid]) {
                return searchRotatedUtil(arr, tar, si, mid - 1);
            } else {
                return searchRotatedUtil(arr, tar, mid + 1, ei);
            }
        } else {
            if (arr[mid] <= tar && tar <= arr[ei]) {
                return searchRotatedUtil(arr, tar, mid + 1, ei);
            } else {
                return searchRotatedUtil(arr, tar, si, mid - 1);
            }
        }

    }

    // Q5. Search in Rotated Sorted Array (Day 7) - O(log n)
    public static int searchRotated(int[] arr, int target) {
        return searchRotatedUtil(arr, target, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        // Q1. Buy and Sell Stock
        // prices[i] = price of a stock on day i. Buy once, sell once later.
        // Find the maximum profit (0 if no profit is possible).
        int[] prices = {7, 1, 5, 3, 6, 4}; //Output -> 5 (buy at 1, sell at 6)
        System.out.println(maxProfit(prices));

        // Q2. String Compression
        // Compress consecutive repeating characters as char + count.
        // If a character appears only once, do not add the count.
        String str = "aaabbc"; //Output -> a3b2c
        System.out.println(compress(str));

        // Q3. Count Set Bits
        // Count the number of 1s in the binary form of n.
        int num = 13; //Output -> 3 (13 = 1101)
        System.out.println(countSetBits(num));

        // Q4. Power of n (Optimized)
        // Calculate x^n using recursion in O(log n).
        // Hint: x^n = (x^(n/2))^2, and multiply by x once more if n is odd.
        int x = 2, n = 10; //Output -> 1024
        System.out.println(power(x, n));

        // Q5. Search in Rotated Sorted Array
        // A sorted array is rotated at some pivot. Return the index of target,
        // or -1 if not found. Must be O(log n), so use modified binary search.
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0; //Output -> 4
        System.out.println(searchRotated(arr, target));
    }
}
