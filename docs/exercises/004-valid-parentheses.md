---
exercise: 004
title: Valid Parentheses
status: Completed
concept: Deque as stack
time_complexity: O(n)
space_complexity: O(n)
---

# 004 — Valid Parentheses

**Status:** Completed

## Problem

Given a string `s` containing only the following characters: `(`, `)`, `{`, `}`, `[`, `]`, `<`, `>`, determine whether the string is valid.

A string is considered valid if:

1. Every opening bracket is closed by the same type of bracket.
2. Opening brackets are closed in the correct order.
3. Every closing bracket has a corresponding opening bracket.

## Constraints

 - The input string contains only the eight bracket characters listed above.
 - The input string is not null.
 - An empty string is considered valid.


## Examples

| Input      | Output  |
|------------|---------|
| `"()"`     | `true`  |
| `"()[]{}"` | `true`  |
| `"{[]}"`   | `true`  |
| `"(]"`     | `false` |
| `"([)]"`   | `false` |
| `"((("`    | `false` |
| `""`       | `true`  |

## Approach
Use a Deque as a stack to keep track of opening brackets while iterating through the input string.

For each character:

- If it is an opening bracket, push it onto the stack.

- If it is a closing bracket, first check whether the stack is empty. If it is, return false.

Otherwise, check whether the closing bracket matches the opening bracket at the top of the stack. If they match, pop the opening bracket. Otherwise, return false.

After processing all characters, return true only if the stack is empty, meaning that all opening brackets have been properly closed.

## Complexity Analysis

- **Time Complexity:** O(n), where n is the length of the input string.
  Each character is processed at most once, and stack operations take O(1)
  time under the usual assumptions.

- **Space Complexity:** O(n) in the worst case.
  The stack may store all opening brackets, for example, when the input
  consists entirely of opening brackets such as `"((((("`.

## Edge Cases

| Category                                             | Input        | Expected | What does it validate?                                                    |
|------------------------------------------------------|--------------|----------|---------------------------------------------------------------------------|
| Empty string                                         | `""`         | `true`   | No invalid or unmatched brackets.                                         |
| Single opening bracket                               | `"("`        | `false`  | An opening bracket remains unmatched.                                     |
| Single closing bracket                               | `")"`        | `false`  | A closing bracket is encountered when the stack is empty.                 |
| Repeated opening brackets                            | `"((("`      | `false`  | Detects unmatched opening brackets at the end.                            |
| Repeated closing brackets                            | `")))"`      | `false`  | Detects closing brackets without corresponding opening brackets.          |
| Valid pair                                           | `"()"`       | `true`   | Basic valid case.                                                         |
| Mismatched bracket types                             | `"(]"`       | `false`  | The closing bracket does not match the opening bracket.                   |
| Incorrect order                                      | `"([)]"`     | `false`  | Having the same number of opening and closing brackets is not sufficient. |
| Consecutive pairs                                    | `"()[]{}"`   | `true`   | The stack becomes empty between pairs.                                    |
| Correct nesting                                      | `"{[]}"`     | `true`   | Respects the LIFO (Last In, First Out) order.                             |
| Extra closing bracket at the end                     | `"()())"`    | `false`  | A closing bracket is encountered when the stack is empty.                 |
| Unbalanced opening and closing brackets              | `"(()"`      | `false`  | An opening bracket remains unmatched.                                     |
| Extra closing bracket followed by an opening bracket | `"())("`     | `false`  | Detects an extra closing bracket before the final opening bracket.        |
| Deep nesting                                         | `"({[()]})"` | `true`   | Handles multiple levels of nesting.                                       |
| Crossed brackets                                     | `"({[)]}"`   | `false`  | Detects a mismatched closing bracket within nested brackets.              |

## Tests

Automated tests cover the examples above, Empty string, Single opening and closing bracket, Repeated opening
and closing brackets, Valid pair, Mismatched bracket types, Incorrect order, Consecutive pairs, Correct nesting,
Extra closing bracket at the end, Unbalanced opening and closing brackets, Extra closing bracket followed by an opening bracket,
deep nesting, and Crossed brackets. 

See [`ValidParenthesesTest.java`](../../src/test/java/ValidParenthesesTest.java).

## Implementation

See [`ValidParentheses.java`](../../src/main/java/ValidParentheses.java).

## Key Takeaways

- `Deque:` as a stack: Deque is a double-ended queue interface in Java that supports insertion and removal at both ends. By using push(), peek(), and pop(), it can be used as a stack with LIFO (Last In, First Out) behavior, making it suitable for tracking opening brackets.
- `Map for bracket matching:` A Map provides an efficient way to associate each opening bracket with its corresponding closing bracket. With a HashMap, lookups take O(1) time on average, simplifying bracket matching.