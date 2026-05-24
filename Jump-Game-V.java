1class Solution {
2     int n;
3
4    public int dfs(int i,int[] arr,int d,int[] dp) {
5        if(dp[i] != -1) {
6            return dp[i];
7        }
8        int ans = 1;
9        for(int j = i + 1;j <= Math.min(n - 1, i + d);j++) {
10            if(arr[j] >= arr[i]) {
11                break;
12            }
13            ans = Math.max(ans,1 + dfs(j, arr, d, dp));
14        }
15        for(int j = i - 1;j >= Math.max(0, i - d);j--) {
16            if(arr[j] >= arr[i]) {
17                break;
18            }
19            ans = Math.max(ans,1 + dfs(j, arr, d, dp));
20        }
21        return dp[i] = ans;
22    }
23
24    public int maxJumps(int[] arr, int d) {
25        n = arr.length;
26        int[] dp = new int[n];
27        Arrays.fill(dp, -1);
28        int ans = 1;
29        for(int i = 0; i < n; i++) {
30            ans = Math.max(ans,dfs(i, arr, d, dp));
31        }
32        return ans;
33    }
34}