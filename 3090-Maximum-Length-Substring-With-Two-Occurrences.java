class Solution {
    public int maximumLengthSubstring(String s) {
        int[] arr=new int[26];
        int res=0;
        int i=0;
        int n=s.length();
        for(int j=0;j<n;j++){
            arr[s.charAt(j)-'a']++;
            while(arr[s.charAt(j)-'a']>2){
                arr[s.charAt(i)-'a']--;
                i++;
            }
            res=Math.max(res,j-i+1);
        }
        return res;
    }
}