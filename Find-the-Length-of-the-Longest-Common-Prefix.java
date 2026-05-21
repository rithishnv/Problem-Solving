1class Solution {
2    public int findlength(int s){
3        int c=0;
4        while(s>0){
5            c++;
6            s/=10;
7        }
8        return c;
9    }
10    public int longestCommonPrefix(int[] arr1, int[] arr2) {
11        int max=0;
12        Set<Integer> a=new HashSet<>();
13        for(int i:arr1){
14            while(i>0){
15                a.add(i);
16                i/=10;
17            }
18        }
19        for(int j:arr2){
20            while(j>0){
21                if(a.contains(j)){
22                    max=Math.max(max,findlength(j));
23                    break;
24                }
25                j/=10;
26            }
27        }
28        return max;
29    }
30}