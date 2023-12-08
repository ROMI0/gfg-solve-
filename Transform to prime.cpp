class Solution {
public:
    bool isprime(int& n) {
        if (n == 1) 
            return false;

        for (int i = 2; i <= sqrt(n); i++)
            if (n % i == 0) 
                return false;

        return true;
    }

    int minNumber(int arr[], int N) {
        int sum = 0;
        for (int i = 0; i < N; i++) 
            sum += arr[i];
            
        int cnt = 0;
        while (!isprime(sum)) {
            ++cnt;
            ++sum;
        }

        return cnt;
    }
};
