1class Solution {
2    public int minimumBoxes(int[] apple, int[] capacity) {
3        Arrays.sort(capacity);
4        int s=0,c=0;
5        for(int i:apple){
6            s+=i;
7        }
8        int j=capacity.length-1;
9        while(s>0){
10            s-=capacity[j--];
11            c++;
12        }
13        return c;
14    }
15}