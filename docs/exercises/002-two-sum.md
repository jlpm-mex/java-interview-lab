---
exercise: 002
title: Two Sum
status: Complete
concept: HashMap
time_complexity: O(n)
space_complexity: O(n)
---

# 002 — Two Sum

**Status:** Completed

## Problem

Given an array of integers `nums` and an integer `target`, return the indices of two distinct elements whose sum equals `target`.

Assume exactly one valid solution exists and the same element cannot be used twice.

## Examples

| Input                               | Output   |
|-------------------------------------|----------|
| `nums = [2, 7, 11, 15], target = 9` | `[0, 1]` |
| `nums = [3, 2, 4], target = 6`      | `[1, 2]` |
| `nums = [3, 3], target = 6`         | `[0, 1]` |

## Approach

Use a `HashMap` to store each previously visited number and its index.

For each element, calculate its complement (`target - nums[i]`) and check whether that complement exists in the map. If it does, return the stored index and the current index. Otherwise, store the current number and its index.

The complement is checked before inserting the current element to prevent using the same element twice.

## Complexity Analysis

- **Time Complexity:** O(n) expected, assuming expected O(1) hash map operations.
- **Space Complexity:** O(n), since the map may store up to n elements.

Where `n` is the length of the input array.

## Edge Cases

- Duplicate values, such as `[3, 3]`.
- Negative numbers and zero.
- No valid solution, if the method's contract allows that case.
- Null or insufficient input, according to the method's input contract.

## Tests

Automated tests cover the examples above, duplicate values, negative numbers, and invalid inputs where applicable.

See [`TwoSumTest.java`](../../src/test/java/algorithms/TwoSumTest.java).

## Implementation

See [`TwoSum.java`](../../src/main/java/algorithms/TwoSum.java).

## Key Takeaways

- A hash map can reduce a brute-force O(n²) solution to expected O(n) time.
- Checking the complement before inserting the current element prevents reusing the same index.
