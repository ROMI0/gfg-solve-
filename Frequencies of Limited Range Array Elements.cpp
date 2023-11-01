class Solution {
public:
    void frequencyCount(vector<int>& arr, int N, int P) {
        int offset = P + 1;

        for (auto i : arr) {
            int val = (i - 1) % offset;
            if (val < N) {
                arr[val] += offset;
            }
        }

        for (int i = 0; i < N; ++i) {
            arr[i] /= offset;
        }
    }
};
