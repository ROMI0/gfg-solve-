
class Solution {
    // Function to return list of integers visited in snake pattern in matrix.
    static ArrayList<Integer> snakePattern(int matrix[][]) {
        ArrayList<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            // For even rows, iterate from left to right.
            if (i % 2 == 0) {
                for (int j = 0; j < cols; j++) {
                    result.add(matrix[i][j]);
                }
            } else {  // For odd rows, iterate from right to left.
                for (int j = cols - 1; j >= 0; j--) {
                    result.add(matrix[i][j]);
                }
            }
        }

        return result;
    }
}
