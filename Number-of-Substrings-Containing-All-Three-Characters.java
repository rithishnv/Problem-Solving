1class Solution {
2    public int numberOfSubstrings(String s) {
3        int res=0,i=0,j=0,c=0;
4        int[] arr=new int[3];
5        while(i<s.length()){
6            if(arr[s.charAt(i)-'a']++==0)
7            c++;
8            while(c>=3){
9                res+=s.length()-i;
10                if(--arr[s.charAt(j)-'a']==0)
11                c--;
12                j++;
13            }
14            i++;
15        }
16        return res;
17    }
18}