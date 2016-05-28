package hw5;
/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * @author D2Victoria
 *
 */


public class BestTimeToBuyAndSellStockWithCooldown_309 {
	// each day, # of stock we're holding can either be 1 or 0
	// 0:            cooldown         ||        sell
	//       yesterday-0, today-0     ||    yesterday-1, today-0
	// =           0[yesterday]       ||    1[yesterday] + price[today]
	
	// 1:            buy【restriction】   ||       cooldown
	//    前天-0, yesterday-0, today-1    ||    yesterday-1, today-1
	// =     0[前天] - price[today]       ||    1[yesterday]
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        
        int[] zeroStock = new int[prices.length];
        int[] oneStock = new int[prices.length];
        
        // initialize
        zeroStock[0] = 0; // cooldown only
        oneStock[0] = -prices[0]; // buy in
        zeroStock[1] = Math.max(zeroStock[0], oneStock[0] + prices[1]);
        oneStock[1] = Math.max(zeroStock[0]-prices[1], oneStock[0]);
        
        
        
        for (int i = 2; i < prices.length; i++) {
            zeroStock[i] = Math.max(zeroStock[i - 1], oneStock[i - 1] + prices[i]);
            oneStock[i] = Math.max(zeroStock[i - 2] - prices[i], oneStock[i - 1]);
        }
        return zeroStock[prices.length - 1];
		
	}
}
