class Solution {
    public int maxProfit(int[] prices) {
        int prevNoState =0;
        int prevBuy = -prices[0];
        int prevSell =0;
        for(int i=1;i<prices.length;i++){
            int noState= Math.max(prevSell,prevNoState);
            int buy = Math.max(prevBuy,prevNoState-prices[i]);
            int sell = prevBuy+prices[i];
            prevNoState = noState;
            prevBuy = buy;
            prevSell = sell;
        }
        return Math.max(prevNoState,prevSell);
    }
}
