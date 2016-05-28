package hw5;

public class CoinChange_322 {
	public int coinChange(int[] coins, int amount) {  
        if(coins == null || coins.length == 0 || amount < 0) {  
            return -1;  
        }  
        
        // initialize
        int[] fewestFor = new int[amount+1];  
        fewestFor[0] = 0;
        
        for(int i = 1; i<fewestFor.length; i++) {  
            fewestFor[i] = Integer.MAX_VALUE; // mark as failure to come up with any combination
        }
        
        // function
        for(int amnt = 1; amnt <= amount; amnt++) { // fewestFor[amnt]  
            for(int ithCoin = 0; ithCoin < coins.length; ithCoin++) {  
                if(coins[ithCoin] <= amnt) {  
                    int leftAmount = amnt - coins[ithCoin];  
                    if(fewestFor[leftAmount] != Integer.MAX_VALUE) {  
                        fewestFor[amnt] = Math.min(fewestFor[amnt], fewestFor[leftAmount] + 1);  
                    }  
                }     
            }  
        }  
        
        if (fewestFor[amount] < Integer.MAX_VALUE) {
        	return fewestFor[amount];
        }
        
        return -1;  
    }  
}
