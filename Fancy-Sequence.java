1class Fancy {
2    ArrayList<Long> list;
3    long mul, add;
4    long MOD = 1_000_000_007L;
5
6    public Fancy() {
7        list = new ArrayList<>();
8        mul = 1;
9        add = 0;
10    }
11    
12    public void append(int val) {
13        long stored = ((val - add + MOD) % MOD * modInverse(mul)) % MOD;
14        list.add(stored);
15    }
16    
17    public void addAll(int inc) {
18        add = (add + inc) % MOD;
19    }
20    
21    public void multAll(int m) {
22        mul = (mul * m) % MOD;
23        add = (add * m) % MOD;
24    }
25    
26    public int getIndex(int idx) {
27        if (idx >= list.size()) return -1;
28        long ans = (list.get(idx) * mul) % MOD;
29        ans = (ans + add) % MOD;
30        return (int) ans;
31    }
32
33    private long modInverse(long x) {
34        return power(x, MOD - 2);
35    }
36
37    private long power(long a, long b) {
38        long res = 1;
39        a %= MOD;
40        while (b > 0) {
41            if ((b & 1) == 1) {
42                res = (res * a) % MOD;
43            }
44            a = (a * a) % MOD;
45            b >>= 1;
46        }
47        return res;
48    }
49}
50
51/**
52 * Your Fancy object will be instantiated and called as such:
53 * Fancy obj = new Fancy();
54 * obj.append(val);
55 * obj.addAll(inc);
56 * obj.multAll(m);
57 * int param_4 = obj.getIndex(idx);
58 */