class Solution {
    public int distinctSubseqII(String s) {
        long mod = 1000000007;
        long[] dp = new long[26];
        for (char c : s.toCharArray()) {
            int i =c-'a';
            long total=1;
            for (long x:dp) {
                total =(total+x)%mod;
            }
            dp[i] = total;
        }
        long ans = 0;
        for (long x:dp) {
            ans=(ans+x)%mod;
        }
        return (int) ans;
    }
}