class Solution {
    public List<Integer> pattern(int N) {
        List<Integer> result = new ArrayList<>();
        patternHelper(N, result);
        return result;
    }

    private void patternHelper(int N, List<Integer> result) {
        if (N <= 0) {
            result.add(N);
            return;
        }

        result.add(N);
        patternHelper(N - 5, result);
        result.add(N);
    }
}
