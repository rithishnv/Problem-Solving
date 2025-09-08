class Solution {
    public int[] getNoZeroIntegers(int n) {

        for (int i = 1; i < n; i++)
            if (nonZero(n - i) && nonZero(i))
                return new int[]{n - i, i};

        return new int[]{};
    }

    private boolean nonZero(int n) {

        while (n > 0) {
            if (n % 10 == 0) return false;
            n /= 10;
        }

        return true;
    }
}