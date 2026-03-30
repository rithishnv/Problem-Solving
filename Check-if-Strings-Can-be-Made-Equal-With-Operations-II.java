1class Solution {
2    public boolean checkStrings(String s1, String s2) {
3        int even[]=new int[26];
4        int odd[]=new int[26];
5        for(int i=0;i<s1.length();i++)
6        {
7            if(i%2==0)
8            {
9            even[s1.charAt(i)-'a']++;
10            even[s2.charAt(i)-'a']--;
11            }
12            else
13            {
14            odd[s1.charAt(i)-'a']++;
15            odd[s2.charAt(i)-'a']--;
16            }
17        }
18        for(int i=0;i<26;i++)
19        {
20            if(even[i]!=0)return false;
21            if(odd[i]!=0)return false;
22        }
23        return true;
24    }
25}