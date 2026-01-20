1    class Solution {
2        public int[] minBitwiseArray(List<Integer> nums) {
3            int a[]=new int[nums.size()];
4            int k=0;
5            for(int i=0;i<nums.size();i++){
6                int f=0;
7                for(int j=1;j<nums.get(i);j++){
8                    if((j|(j+1))==nums.get(i)){
9                        a[k++]=j;
10                        f=1;
11                        break;
12                    }
13                }
14                if(f==0)a[k++]=-1;
15            }
16            return a;
17        }
18    }