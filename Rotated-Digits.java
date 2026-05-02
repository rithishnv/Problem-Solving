1class Solution {
2    public int rotatedDigits(int n) {
3        int cnt = 0;
4        for (int i = 1; i <= n; i++) {
5            if (check(i)) cnt++;
6        }
7        return cnt;
8    }
9
10    private boolean check(int num) {
11        boolean isValid = true;
12        boolean canChange = false;
13        while (num > 0) {
14            int rem = num % 10;
15            if (rem == 3 || rem == 4 || rem == 7) {
16                isValid = false;
17                break;
18            } else if (rem == 2 ||rem == 5 || rem == 6 || rem == 9) {
19                canChange = true;
20            }
21            num /= 10;
22        }
23        if (isValid && canChange) return true;
24        return false;
25    }
26}