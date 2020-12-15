package slidingWindow.medium;


import java.util.HashMap;
import java.util.Map;

/* 
Given an array of characters where each character represents a fruit tree, you are given two baskets and 
your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can 
have only one type of fruit.

You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from 
each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.

Write a function to return the maximum number of fruits in both the baskets.

Input: Fruit=['A', 'B', 'C', 'A', 'C']
Output: 3
Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
*/

/*
given an array of string, substring that have maximum number of 2 characters
1. go through array and at each increment 
*/

class MaxFruitCountOf2Types {
  public static int findLength(final char[] arr) {
    Map<Character, Integer> charCount = new HashMap<>();
    int winStart = 0;
    int maxNum = 0;
    for (int winEnd = 0; winEnd < arr.length; winEnd++) {
      char rightChar = arr[winEnd];
      charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);
      // shrink the window until size is == 2
      while (charCount.size() > 2) {
        char leftChar = arr[winStart];
        charCount.put(leftChar, charCount.getOrDefault(leftChar, 0) - 1);
        if (charCount.get(leftChar) == 0) {
          charCount.remove(leftChar);
        }
        winStart++;
      }

      maxNum = Math.max(maxNum, winEnd - winStart + 1);

    }
    return maxNum;
  }

  public static void main(final String[] args) {
    System.out.println("Maximum number of fruits: " + 
                          MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
    System.out.println("Maximum number of fruits: " + 
                          MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
  }
}



