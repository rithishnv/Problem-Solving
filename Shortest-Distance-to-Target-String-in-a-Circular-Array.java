1class Solution {
2    public int closestTarget(String[] words, String target, int startIndex) {
3        int n=words.length;
4        int r=Integer.MAX_VALUE;
5        for(int i=0;i<n;i++){
6            if(words[i].equals(target)){
7                int t=Math.abs(startIndex-i+n)%n;
8                int a=Math.abs(i-startIndex+n)%n;
9                r=Math.min(r,Math.min(t,a));
10            }
11        }
12        return (r==Integer.MAX_VALUE)?-1:r;
13    }
14}