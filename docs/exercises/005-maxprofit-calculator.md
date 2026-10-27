---
exercise: 005
title: Best Time to Buy and Sell Stock
status: Completed
concept: Operations order
time_complexity: O(n)
space_complexity: O(1)
---

# 005 — Best Time to Buy and Sell Stock

**Status:** Completed

## Problem

You are given an array `prices` where `prices[i]` represents the price of a stock on the `i`-th day.

You want to maximize your profit by choosing one day to buy the stock and a different day in the future to sell it.

Return the maximum profit you can achieve from this transaction. If no profitable transaction is possible, return `0`.

You must buy before you sell.

## Constraints

- `1 <= prices.length <= 10⁵`
- `0 <= prices[i] <= 10⁴`
- You must buy before selling.
- Target time complexity: `O(n)`.

## Examples

| Input                    | Output | Explanation                                       |
|--------------------------|--------|---------------------------------------------------|
| `prices = [7,1,5,3,6,4]` | `5`    | Buy at `1` and sell at `6`. Profit = `6 - 1 = 5`. |
| `prices = [7,6,4,3,1]`   | `0`    | No profitable transaction is possible.            |
| `prices = [2,4,1]`       | `2`    | Buy at `2` and sell at `4`. Profit = `4 - 2 = 2`. |
| `prices = [3,3,3,3]`     | `0`    | No positive profit is possible.                   |

## Approach

First, validate that the input array is not `null` or empty. If either condition is met, throw an `IllegalArgumentException`.

Initialize `minPrice` with the first price in the array and `maxProfit` with `0`.

Iterate through the array starting at index `1`, since the first price has already been assigned to `minPrice`.

For each price:

1. Calculate the potential profit by subtracting `minPrice` from the current price.
2. Update `maxProfit` if the potential profit is greater than the current maximum.
3. Update `minPrice` if the current price is lower than the minimum price found so far.

By calculating the potential profit before updating `minPrice`, the algorithm evaluates selling at the current price using a minimum price from an earlier day.

## Complexity Analysis

- **Time Complexity:** `O(n)`, where `n` is the length of the `prices` array. Each element is processed once.
- **Space Complexity:** `O(1)`, because the algorithm uses a constant number of additional variables, regardless of the input size.

## Edge Cases

| Category                 | Input         | Expected                   | What does it validate?                                                 |
|--------------------------|---------------|----------------------------|------------------------------------------------------------------------|
| Empty array              | `[]`          | `IllegalArgumentException` | Empty input is rejected.                                               |
| Single price             | `[1]`         | `0`                        | A transaction requires two different days.                             |
| Same prices              | `[1,1,1]`     | `0`                        | No positive profit is possible.                                        |
| Decreasing prices        | `[7,6,4,3,1]` | `0`                        | The algorithm must not return a negative profit.                       |
| Minimum at the beginning | `[1,5,3,6]`   | `5`                        | The minimum price can remain unchanged while a better profit is found. |
| Minimum at the end       | `[2,4,1]`     | `2`                        | A new minimum cannot be used to sell on the same day.                  |

## Tests

Automated tests cover the examples above, single-element arrays, empty and `null` inputs, equal prices, decreasing prices, increasing prices, and cases where the minimum price appears before or after a profitable transaction.

See [`MaxProfitCalculatorTest.java`](../../src/test/java/MaxProfitCalculatorTest.java).

## Implementation

See [`MaxProfitCalculator.java`](../../src/main/java/MaxProfitCalculator.java).

## Key Takeaways

- **Initialize the state:** The first array element provides the initial minimum price, so iteration can start at index `1`.
- **Maintain a running minimum:** `minPrice` represents the lowest price encountered so far.
- **Evaluate before updating:** Calculate the potential profit using the previous minimum before considering the current price as a new minimum.
- **Track only what is needed:** Since the method returns only the maximum profit, there is no need to store the buy or sell days.
- **Optimize both time and space:** A single pass achieves `O(n)` time and `O(1)` auxiliary space.
