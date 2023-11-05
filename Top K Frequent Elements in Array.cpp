
class Solution {
public:
    vector<int> topK(vector<int>& nums, int k) {
        unordered_map<int, int> mp;
        for (auto i : nums)
            ++mp[i];

        priority_queue<pair<int, int>> pq;

        for (auto itr : mp) {
            pq.push({itr.second, itr.first});
        }

        vector<int> out;
        while (!pq.empty() && k--) {
            out.push_back(pq.top().second);
            pq.pop();
        }

        return out;
    }
};
