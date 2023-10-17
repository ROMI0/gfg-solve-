-> JAVA CODE --
------

class Solution {
    public int largestIsland(int N, int[][] grid) {
        int maxIslandSize = 0;
        int currentColor = 2; // Starting from 2 because 0 and 1 are already used.

        // Color the islands and store their sizes in a map.
        Map<Integer, Integer> islandSizes = new HashMap<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    int size = colorIsland(i, j, grid, currentColor);
                    islandSizes.put(currentColor, size);
                    maxIslandSize = Math.max(maxIslandSize, size);
                    currentColor++;
                }
            }
        }

        // Check each 0 cell and calculate the total size when converting it to 1.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> adjacentColors = new HashSet<>();
                    adjacentColors.add(i > 0 ? grid[i - 1][j] : 0);
                    adjacentColors.add(i < N - 1 ? grid[i + 1][j] : 0);
                    adjacentColors.add(j > 0 ? grid[i][j - 1] : 0);
                    adjacentColors.add(j < N - 1 ? grid[i][j + 1] : 0);

                    int newSize = 1; // Start with the current cell itself.
                    for (int color : adjacentColors) {
                        newSize += islandSizes.getOrDefault(color, 0);
                    }

                    maxIslandSize = Math.max(maxIslandSize, newSize);
                }
            }
        }

        return maxIslandSize;
    }

    private int colorIsland(int i, int j, int[][] grid, int color) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = color;
        int size = 1;

        size += colorIsland(i - 1, j, grid, color);
        size += colorIsland(i + 1, j, grid, color);
        size += colorIsland(i, j - 1, grid, color);
        size += colorIsland(i, j + 1, grid, color);

        return size;
    }
}


