class Solution {
public:
    vector<vector<int>> transitiveClosure(int N, vector<vector<int>>& graph) {
        vector<vector<int>> transitiveClosure(N, vector<int>(N, 0));

        for (int i = 0; i < N; i++) {
            dfs(graph, transitiveClosure, N, i, i);
        }

        return transitiveClosure;
    }

    void dfs(vector<vector<int>>& graph, vector<vector<int>>& transitiveClosure, int N, int start, int current) {
        transitiveClosure[start][current] = 1;
        for (int i = 0; i < N; i++) {
            if (graph[current][i] == 1 && !transitiveClosure[start][i]) {
                dfs(graph, transitiveClosure, N, start, i);
            }
        }
    }
};
