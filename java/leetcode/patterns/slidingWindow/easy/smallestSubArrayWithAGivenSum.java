package slidingWindow.easy;

/*
Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous 
subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.

Input: [2, 1, 5, 2, 3, 2], S=7 
Output: 2
Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
*/

// go through the array and record the length of the longest one with sum = k
class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr) {
    int windowStart = 0;
    int minLen = Integer.MAX_VALUE;
    int winLen;
    int winSum = 0;
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      winSum += arr[windowEnd]; // add the next element to the sum
      while (winSum >= S) {
        winLen = windowEnd - windowStart + 1; // current length of window
        minLen = Math.min(winLen, minLen);  // choose the smaller one to be min length
        winSum -= arr[windowStart];  // subtract the element going out as window slides
        windowStart++; // shrink the window by moving start forward
      } 
    }
    return minLen == Integer.MAX_VALUE ? 0 : minLen;
  }
// Time Complexity #
// The time complexity of the above algorithm will be O(N). 
// The outer for loop runs for all elements and the inner while loop processes each element only once, 
// therefore the time complexity of the algorithm will be O(N+N) which is asymptotically equivalent to O(N).

// Space Complexity #
// The algorithm runs in constant space O(1).

  public static void main(String[] args) {
    int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
    System.out.println("Smallest subarray length: " + result);
    result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
    System.out.println("Smallest subarray length: " + result);
    result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
    System.out.println("Smallest subarray length: " + result);
  }
}