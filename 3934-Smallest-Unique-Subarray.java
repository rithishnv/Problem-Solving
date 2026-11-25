class Solution {
    int[] nums;
    long b = 19;
    long mod = 1000000007;
    long[] pow;
    Map<Long, Integer> hashval = new HashMap<>();
    public int smallestUniqueSubarray(int[] nums) {
        this.nums = nums;
        this.pow = new long[nums.length+1];
        int minposs = nums.length;
        int minlen = 1, maxlen = nums.length;
        while(minlen<=maxlen) {
            int midlen = (minlen+maxlen)/2;
            if(checkUnique(midlen)) {
                if(midlen < minposs) minposs = midlen;
                maxlen = midlen-1;
            } else {
                minlen = midlen+1;
            }
        }
        return minposs;
    }

    private boolean checkUnique(int subarrayLen) {
        int n = nums.length;
        pow[0] = 1;
        for(int i = 1; i <= n; i++) {
            pow[i] = (pow[i-1]*b)%mod;
        }
        long cur = 0;
        for(int i = 0; i < subarrayLen; i++) {
            cur = (cur*b+nums[i])%mod;
        }
        hashval.clear();
        hashval.put(cur, 1);
        for(int i = 1; i <= n-subarrayLen; i++) {
            cur -= pow[subarrayLen-1]*nums[i-1];
            cur %= mod;
            if(cur < 0) cur += mod;
            cur = (cur*b+nums[i+subarrayLen-1])%mod;
            hashval.merge(cur, 1, Integer::sum);
        }
        return hashval.containsValue(1);
    }
}