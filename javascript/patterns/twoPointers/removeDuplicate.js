/*
EASY

Problem Statement #
Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing the duplicates in-place return the length of the subarray that has no duplicate in it.

Example 1:

Input: [2, 3, 3, 3, 6, 9, 9]
Output: 4
Explanation: The FIRST FOUR ELEMENTS after removing the duplicates will be [2, 3, 6, 9].
*/

const remove_duplicates = function(arr) {
  let nextNonDuplicate = 1; // the index of the element that should not be duplicate
  for (let i = 1; i < arr.length; i++)
  {
    // if not duplicate then mark the current num as nonDuplicatedIndex and increment nonDuplicateIndex
    if (arr[nextNonDuplicate - 1] !== arr[i]) { // at 0 !== 1 -> not duplicate
      arr[nextNonDuplicate] = arr[i] // set at 1 = at 1
      nextNonDuplicate += 1; // nextduplicate = 2
    }
  }
  return nextNonDuplicate;
};

/*
Time Complexity #
The time complexity of the above algorithm will be O(N)O(N), where ‘N’ is the total number of elements in the given array.

Space Complexity #
The algorithm runs in constant space O(1)O(1).
*/