1class Solution {
2    public int countPartitions(int[] nums, int k) {
3        int[] A=nums;
4        int n = A.length, mod = 1_000_000_007, acc = 1;
5        int[] dp = new int[n + 1];
6        dp[0] = 1;
7
8        Deque<Integer> minq = new ArrayDeque<>();
9        Deque<Integer> maxq = new ArrayDeque<>();
10        for (int i = 0, j = 0; j < n; ++j) {
11            while (!maxq.isEmpty() && A[j] > A[maxq.peekLast()])
12                maxq.pollLast();
13            maxq.addLast(j);
14
15            while (!minq.isEmpty() && A[j] < A[minq.peekLast()])
16                minq.pollLast();
17            minq.addLast(j);
18
19            while (A[maxq.peekFirst()] - A[minq.peekFirst()] > k) {
20                acc = (acc - dp[i++] + mod) % mod;
21                if (minq.peekFirst() < i)
22                    minq.pollFirst();
23                if (maxq.peekFirst() < i)
24                    maxq.pollFirst();
25            }
26
27            dp[j + 1] = acc;
28            acc = (acc + dp[j + 1]) % mod;
29        }
30
31        return dp[n];
32    }
33}