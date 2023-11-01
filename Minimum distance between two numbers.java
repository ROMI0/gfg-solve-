class Solution {
    int minDist(int a[], int n, int x, int y) {
        int minDistance = Integer.MAX_VALUE;
        int xIndex = -1;
        int yIndex = -1;
        
        for (int i = 0; i < n; i++) {
            if (a[i] == x) {
                xIndex = i;
                if (yIndex != -1) {
                    minDistance = Math.min(minDistance, xIndex - yIndex);
                }
            } else if (a[i] == y) {
                yIndex = i;
                if (xIndex != -1) {
                    minDistance = Math.min(minDistance, yIndex - xIndex);
                }
            }
        }
        
        if (minDistance == Integer.MAX_VALUE) {
            return -1;
        }
        
        return minDistance;
    }
}
