---
exercise: 003
title: First Non-Repeating Character
status: Completed
concept: HashMap
time_complexity: O(n)
space_complexity: O(k)
---

# 003 — First Non-Repeating Character

**Status:** Completed

## Problem

Write a Java method that receives a string and returns the first character that appears exactly once in the string.

If every character appears more than once, return an appropriate value indicating that no non-repeating character exists.

## Constraints

- Use Java.
- Try to solve it in a maximum of 15 minutes.
- You may use Java's standard collections.
- Preserve the original order of characters when determining the first non-repeating character.

## Examples

| Input            | Output       | Explanation                                                   |
|------------------|--------------|---------------------------------------------------------------|
| `"leetcode"`     | `'l'`        | The character `'l'` appears only once and occurs first.       |
| `"loveleetcode"` | `'v'`        | The character `'v'` is the first character that appears once. |
| `"aabb"`         | No character | Every character appears more than once.                       |
| `"a"`            | `'a'`        | The only character appears once.                              |
| `""`             | No character | The string is empty.                                          |

## Approach

Use a frequency map to count how many times each character appears in the string.

First, iterate through the string and store each character's frequency in a `HashMap<Character, Integer>`.

Then, iterate through the string a second time, preserving the original character order. Return the first character whose frequency is exactly one.

If no character satisfies this condition, return the value defined by the method contract to indicate that no result exists.

The two-pass approach separates frequency counting from identifying the first non-repeating character.

## Complexity Analysis

Let `n` be the length of the string.

- **Time Complexity:** `O(n)`, because the algorithm traverses the string twice, and hash map operations take constant time on average.
- **Space Complexity:** `O(k)`, where `k` is the number of distinct characters stored in the map. In the worst case, `k` is proportional to `n`, resulting in `O(n)` space.

## Edge Cases

| Category                       | Input       | Expected                       | What does it validate?                                                                            |
|--------------------------------|-------------|--------------------------------|---------------------------------------------------------------------------------------------------|
| Empty string                   | `""`        | No character                   | Handling an empty input.                                                                          |
| Single character               | `"a"`       | `'a'`                          | A character that appears exactly once.                                                            |
| All characters repeated        | `"aabb"`    | No character                   | No valid result exists.                                                                           |
| First character is unique      | `"abcabc"`  | No character                   | All characters repeat despite the initial ordering.                                               |
| Unique character in the middle | `"aabbcdd"` | `'c'`                          | Finding a unique character after repeated characters.                                             |
| Multiple unique characters     | `"abcd"`    | `'a'`                          | Returning the first unique character.                                                             |
| Null input                     | `null`      | Depends on the method contract | Explicit handling or rejection of invalid input.                                                  |

## Tests

Automated tests should cover the examples above, empty strings, single-character strings, strings with no non-repeating characters, multiple unique characters, case sensitivity, and null input according to the method's defined contract.

See [`FindFirstNonRepeatingTest.java`](../../src/test/java/FindFirstNonRepeatingTest.java).


## Implementation

See [`FindFirstNonRepeating.java`](../../src/main/java/FindFirstNonRepeating.java).

## Key Takeaways

- A frequency map is useful when an algorithm needs to count occurrences of elements.
- Two passes allow frequency counting and order-preserving identification to be handled separately.
- The original string must be traversed in order to guarantee that the first non-repeating character is returned.
- Average time complexity is `O(n)`, with auxiliary space complexity of `O(k)`.
- The method contract should clearly define what happens when no non-repeating character exists or when the input is `null`.