---
exercise: 001
title: Detect Duplicates
status: Completed
concept: HashSet
time_complexity: O(n)
space_complexity: O(n)
---

# 001 — Detect Duplicates

**Status:** Completed

## Problem

Write a Java method that receives a list of integers and returns `true` if any number appears more than once; otherwise, it returns `false`.

## Constraints

- Use Java.
- Try to solve it in a maximum of 15 minutes.
- You may use Java's standard collections.

## Examples

| Input          | Output  | Explanation                            |
|----------------|---------|----------------------------------------|
| `[1, 2, 3, 4]` | `false` | No elements are duplicated.            |
| `[1, 2, 3, 2]` | `true`  | The number `2` appears more than once. |
| `[5, 5, 5]`    | `true`  | All elements are equal.                |
| `[]`           | `false` | An empty list contains no duplicates.  |

## Approach

Use a `HashSet` to keep track of the numbers already encountered.

Iterate through the list and attempt to add each number to the set. If `add()` returns `false`, the number already exists in the set, so a duplicate has been found. Return `true` immediately.

If the iteration finishes without finding a duplicate, return `false`.

This approach avoids processing the remaining elements once a duplicate is detected.

## Complexity Analysis

- **Time Complexity:** `O(n)` average case, where `n` is the number of elements. Each element is processed at most once, and `HashSet` operations take constant time on average.
- **Space Complexity:** `O(k)`, where `k` is the number of distinct elements stored in the set. In the worst case, the set contains all `n` elements, resulting in `O(n)` space.

## Edge Cases

| Category                   | Input          | Expected                       | What does it validate?                                |
|----------------------------|----------------|--------------------------------|-------------------------------------------------------|
| Empty list                 | `[]`           | `false`                        | No elements are available to compare.                 |
| Single element             | `[7]`          | `false`                        | A single element cannot be duplicated.                |
| Duplicate at the beginning | `[5, 5, 2, 3]` | `true`                         | Early termination when a duplicate is found.          |
| Duplicate at the end       | `[1, 2, 3, 2]` | `true`                         | Detection after processing several distinct elements. |
| All elements equal         | `[5, 5, 5]`    | `true`                         | Repeated occurrences of the same value.               |
| Negative numbers           | `[-1, -2, -1]` | `true`                         | Duplicate detection with negative values.             |
| Null input                 | `null`         | Depends on the method contract | Explicit handling or rejection of invalid input.      |

## Tests

Automated tests cover the examples above, single-element lists, empty lists, duplicate values, negative numbers, and null input according to the method's defined contract.

See [`ContainsDuplicateTest.java`](../../src/test/java/ContainsDuplicateTest.java).

## Implementation

See [`ContainsDuplicate.java`](../../src/main/java/ContainsDuplicate.java).

## Key Takeaways

- A `HashSet` is a natural choice when uniqueness matters and duplicate detection is the goal.
- The return value of `Set.add()` can be used to detect duplicates without a separate lookup.
- Returning immediately when a duplicate is found avoids unnecessary iterations.
- Average time complexity is `O(n)`, with worst-case auxiliary space complexity of `O(n)`.
- The behavior for `null` input should be explicitly defined and tested.