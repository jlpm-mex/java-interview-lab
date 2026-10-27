public class MaxProfitCalculator {

    public int maxProfit(int[] prices){


        if(prices == null || prices.length == 0)
            throw new IllegalArgumentException("Array input can't be empty or null");

        int minPrice = prices[0];
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i ++){

            maxProfit = (prices[i] - minPrice) > maxProfit ? (prices[i] - minPrice) : maxProfit;

            if(prices[i] < minPrice ) {
                minPrice = prices[i];
            }

        }

        return maxProfit;
    }
}
