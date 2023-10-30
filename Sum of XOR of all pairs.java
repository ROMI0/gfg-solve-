class Solution {
    public long sumXOR(int arr[], int n) {
        long totalXOR = 0;
        for (int i = 0; i < 31; i++) {
            long countSetBits = 0;
            for (int j = 0; j < n; j++) {
                if ((arr[j] & (1 << i)) != 0) {
                    countSetBits++;
                }
            }
            totalXOR += (countSetBits * (n - countSetBits)) * (1 << i);
        }
        return totalXOR;
    }
}


