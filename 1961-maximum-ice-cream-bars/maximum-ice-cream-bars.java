class Solution {
    public int maxIceCream(int[] costs, int coins) {

        int maxCost = 0;

        for(int cost : costs){
            maxCost = Math.max(maxCost, cost);
        }

        int[] freq = new int[maxCost + 1];

        for(int cost : costs){
            freq[cost]++;
        }

        int count = 0;

        for(int price = 1; price <= maxCost; price++){

            if(freq[price] == 0)
                continue;

            int totalCost = freq[price] * price;

            if(coins >= totalCost){
                coins -= totalCost;
                count += freq[price];
            } else {
                count += coins / price;
                return count;
            }
        }

        return count;
    }
}