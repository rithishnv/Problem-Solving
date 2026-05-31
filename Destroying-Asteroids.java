1class Solution {
2    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
3        Arrays.sort(asteroids);
4        long t=mass;
5        for(int i:asteroids){
6            if(t<i){
7                return false;
8            }
9            t+=i;
10        }
11        return true;
12    }
13}