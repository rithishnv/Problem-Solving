1class Solution {
2    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
3        Arrays.sort(hBars);
4        Arrays.sort(vBars);
5        int s=Math.min(maxLen(hBars),maxLen(vBars));
6        return s*s;
7    }
8    public int maxLen(int[] arr){
9        int cnt=2,len=2;
10        for(int i=1;i<arr.length;i++){
11            if(arr[i]==arr[i-1]+1)
12            cnt++;
13            else
14            cnt=2;
15            len=Math.max(len,cnt);
16        }
17        return len;
18    }
19}