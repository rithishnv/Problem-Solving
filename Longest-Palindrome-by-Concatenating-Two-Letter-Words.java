class Solution {
    public int longestPalindrome(String[] words) {
       int[][] arr=new int[26][26];
       int res=0,mid=0;
       for(String s:words){
        int i=s.charAt(0)-'a',j=s.charAt(1)-'a';
        if(arr[j][i]>0){
            arr[j][i]--;
            res+=4;
            if(i==j)
            mid--;
        }
        else{
            arr[i][j]++;
            if(i==j)
            mid++;
        }
       }
       if(mid>0)
       res+=2;
       return res;
    }
}