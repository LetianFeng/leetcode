public class Solution121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int profit = 0;
        int min = prices[0];

        for (int price : prices) {
            if (profit < price - min)
                profit = price - min;
            else if (min > price)
                min = price;
        }

        return profit;
    }
}