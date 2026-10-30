---
exercise: 002
title: Two Sum
status: Completed
concept: HashMap
time_complexity: O(n)
space_complexity: O(n)
---

# 002 — Two Sum

**Status:** Completed

## Problem

Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to `target`.

You may assume that each input has exactly one valid solution, and you cannot use the same element twice.

Return the indices in any order.

## Approach

Use a `HashMap` to store previously visited numbers and their corresponding indices.

Iterate through the array and calculate the complement needed to reach the target:

`complement = target - nums[i]`

For each element:

1. Calculate the complement.
2. Check whether the complement already exists in the HashMap.
3. If it exists, return the index of the complement and the current index.
4. Otherwise, store the current number and its index in the HashMap.

This approach avoids nested loops by using the HashMap for efficient lookups.

## Implementation

**Class:** `TwoSum.java`

**Method:** `twoSum(int[] nums, int target)`

**Data Structure:** `HashMap<Integer, Integer>`

See [`TwoSum.java`](../../src/main/java/TwoSum.java)

## Complexity Analysis

| Metric | Complexity | Explanation |
|---|---|---|
| Time | O(n) expected | The array is traversed once, with expected O(1) HashMap lookups and insertions. |
| Space | O(n) | In the worst case, the HashMap stores up to n elements. |

## Testing

**Test class:** `TwoSumTest.java`

The test suite uses JUnit 5 with `@ParameterizedTest` and `@MethodSource` to validate different scenarios.

See [`TwoSumTest`](../../src/test/java/TwoSumTest.java)

### Valid test cases

- Valid pair of numbers.
- Multiple valid solutions, returning the first match found.
- Array containing exactly two elements.
- Solution located in the middle of the array.
- Negative numbers.
- Sum involving zero.
- Two negative numbers.
- Solution located at the beginning of the array.
- Solution located at the end of the array.

### Invalid test cases

- Empty array.
- Null array.
- Array containing only one element.
- No valid pair found.

Invalid inputs are expected to throw `IllegalArgumentException`.

## Decisions

- **HashMap over nested loops:** A HashMap reduces the expected time complexity from O(n²) to O(n), at the cost of additional space.
- **Complement lookup before insertion:** Checking whether the complement exists before storing the current element prevents using the same array index twice.
- **Store values and indices:** The HashMap uses the array value as the key and its index as the value, allowing the method to return the original indices.
- **Return the first match:** The implementation returns the first valid pair found during the array traversal.