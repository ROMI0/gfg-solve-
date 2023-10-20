class Solution {
    public int isPossible(int N, int[] arr) {
        int[] count = new int[3]; // To count the remainders when dividing by 3.

        for (int num : arr) {
            count[num % 3]++;
        }

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += i * count[i];
        }

        if (sum % 3 == 0) {
            return 1; // It's possible to form a number divisible by 3.
        }

        return 0; // It's not possible to form a number divisible by 3.
    }
}
