class Solution {
    public int maxIceCream(int[] costs, int coins) {

        int[] freq = new int[100001];

        for (int cost : costs) {
            freq[cost]++;
        }

        int count = 0;

        for (int price = 1; price <= 100000; price++) {

            while (freq[price] > 0 && coins >= price) {
                coins -= price;
                count++;
                freq[price]--;
            }
        }

        return count;
    }
}