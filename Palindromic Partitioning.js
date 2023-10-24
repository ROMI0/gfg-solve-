class Solution {
    palindromicPartition(S) {
        const n = S.length;
        
        // Function to check if a substring is a palindrome
        const isPalindrome = (str, start, end) => {
            while (start < end) {
                if (str[start] !== str[end]) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        };
        
        // Create an array to store minimum cut values
        const minCuts = new Array(n);
        
        // Initialize the array
        for (let i = 0; i < n; i++) {
            minCuts[i] = i;  // Maximum cuts needed
        }
        
        for (let i = 1; i < n; i++) {
            for (let j = 0; j <= i; j++) {
                if (isPalindrome(S, j, i)) {
                    if (j === 0) {
                        minCuts[i] = 0;  // No cut needed
                    } else {
                        minCuts[i] = Math.min(minCuts[i], minCuts[j - 1] + 1);
                    }
                }
            }
        }
        
        return minCuts[n - 1];
    }
}
