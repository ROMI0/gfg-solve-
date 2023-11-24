import java.util.ArrayList;

class Solution {
    int mod = 1000000007;

    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        ArrayList<Long> out = new ArrayList<>();
        ArrayList<Long> prev = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            out.add(1L);
            prev.add(1L);
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < i; ++j) {
                out.set(j, (prev.get(j) + prev.get(j - 1)) % mod);
            }
            prev = new ArrayList<>(out);
        }

        return out;
    }
}
