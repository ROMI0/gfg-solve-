class Solution {
public:
    int knapSack(int N, int W, int val[], int wt[]) {
        vector<int> dp(W + 1, 0);

        for (int w = 1; w <= W; w++) {
            for (int i = 0; i < N; i++) {
                if (wt[i] <= w) {
                    dp[w] = max(dp[w], dp[w - wt[i]] + val[i]);
                }
            }
        }

        return dp[W];
    }
};
