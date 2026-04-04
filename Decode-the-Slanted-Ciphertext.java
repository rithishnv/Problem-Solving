1class Solution {
2    public String decodeCiphertext(String encodedText, int rows) {
3        int n=encodedText.length();
4        int limit=n/rows;
5        int i=0;
6        StringBuilder ans=new StringBuilder();
7        while(i<limit){
8            for(int j=i;j<n;j+=limit+1){
9                ans.append(encodedText.charAt(j));
10            }
11            i++;
12        }
13        return ans.toString().stripTrailing();
14    }
15}