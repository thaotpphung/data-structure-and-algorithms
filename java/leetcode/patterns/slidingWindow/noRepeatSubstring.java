package patterns.slidingWindow;


/*
HARD
Given a string, find the length of the longest substring which has no repeating characters.

Input: String="aabccbb"
Output: 3
Explanation: The longest substring without any repeating characters is "abc".

*/

// go throught the string, increment char count, 

import java.util.*;

class NoRepeatSubstring {
  public static int findLength(String str) {
    int maxLength = 0;
    int windowStart = 0;
    Map<Character, Integer> charIndexMap = new HashMap<>();
    // try to extend the range [windowStart, windowEnd]
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      // if the map already contains the 'rightChar', => repetition => need to shrink window
      if (charIndexMap.containsKey(rightChar)) {
        if (charIndexMap.get(rightChar) >= windowStart ) {
          windowStart = charIndexMap.get(rightChar) + 1;
        }
      }
      charIndexMap.put(rightChar, windowEnd); // insert the 'rightChar' into the map
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
    }
    return maxLength;
  }
  public static void main(String[] args) {
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
  }
}
