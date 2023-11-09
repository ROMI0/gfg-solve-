class Solution {
    int columnWithMaxZeros(int arr[][], int N) {
        int maxZeros = 0;  // Variable to store the maximum number of zeros
        int maxZerosColumn = -1;  // Variable to store the column with maximum zeros

        // Iterate through each column
        for (int j = 0; j < N; j++) {
            int zerosCount = 0;  // Variable to count zeros in the current column

            // Count zeros in the current column
            for (int i = 0; i < N; i++) {
                if (arr[i][j] == 0) {
                    zerosCount++;
                }
            }

            // Check if the current column has more zeros than the maximum
            if (zerosCount > maxZeros) {
                maxZeros = zerosCount;
                maxZerosColumn = j;
            }
        }

        return maxZerosColumn;
    }
}
