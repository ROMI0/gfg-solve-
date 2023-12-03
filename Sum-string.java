class Solution {
    public int isSumString(String S) {
        int n = S.length();

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String num1 = S.substring(0, i);
                String num2 = S.substring(i, j);

                if (isValidSumString(num1, num2, S.substring(j))) {
                    return 1;
                }
            }
        }

        return 0;
    }

    private boolean isValidSumString(String num1, String num2, String remaining) {
        if (remaining.isEmpty()) {
            return true;
        }

        String sum = addStrings(num1, num2);

        if (remaining.startsWith(sum)) {
            return isValidSumString(num2, sum, remaining.substring(sum.length()));
        }

        return false;
    }

    private String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int x = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j--) - '0' : 0;

            int sum = x + y + carry;
            carry = sum / 10;
            result.insert(0, sum % 10);
        }

        return result.toString();
    }
}
