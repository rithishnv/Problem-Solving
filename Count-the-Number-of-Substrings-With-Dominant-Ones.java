class Solution {
    public int numberOfSubstrings(String s) {
       int res = 0;
    int n = s.length();
    for (int z = 0; z + z * z <= n; ++z) {
        int[] cnt = new int[2];
        int p = 0;
        int oldRes = res;
        for (int i = 0, j = 0; i < n; ++i) {
            cnt[s.charAt(i) == '1' ? 1 : 0]++;
            while (cnt[0] > z) {
                cnt[s.charAt(j) == '1' ? 1 : 0]--;
                j++;
            }
            if (cnt[0] == z && cnt[1] > 0 && cnt[1] >= z * z) {
                if (p < j) p = j;
                while (p < i && s.charAt(p) == '1') p++;
                res += 1 + Math.min(p - j, cnt[1] - z * z);
            }
        }
        if (res == oldRes) break;
    }
    return res;
    }
}