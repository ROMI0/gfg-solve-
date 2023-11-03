class Solution {
    boolean checkTriplet(int[] arr, int n) {
        // Create a set to store the squares of elements
        Set<Integer> set = new HashSet<>();
        
        // Calculate the squares of all elements and store them in the set
        for (int i = 0; i < n; i++) {
            set.add(arr[i] * arr[i]);
        }
        
        // Check for Pythagorean triplets
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sumOfSquares = arr[i] * arr[i] + arr[j] * arr[j];
                if (set.contains(sumOfSquares)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
