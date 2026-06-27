1class Solution {
2    public int maximumLength(int[] nums) {
3        Map<Integer,Integer> map = new HashMap<>();
4        int n = nums.length;
5        for(int i : nums){
6            map.put(i,map.getOrDefault(i,0)+1);
7        }
8        int maxSize =  0;
9        Arrays.sort(nums);
10        for(int i = 0;i<n;i++){
11            if(i>0 && nums[i]==nums[i-1]){
12                continue;
13            }
14            if(nums[i]==1){
15                int freq1 = map.get(1);
16                if(freq1 %2==0){
17                freq1--;
18                }
19                maxSize = freq1;
20            }
21            else if (map.containsKey(nums[i])){
22                int size = 0;
23                int key = nums[i];
24                int freq = 0;
25                while(map.containsKey(key) && map.get(key)>1){
26                     freq = map.get(key);
27                    if(freq>=2){
28                        size += 2;
29                    }
30                    else{
31                     size+=1;
32                    }
33                    map.remove(key);
34                    key = key*key;
35                }
36                if(!map.containsKey(key)){
37                    size-=1;
38                }
39                else{
40                    size+= map.get(key);
41                    map.remove(key);
42                }
43                maxSize = Math.max(maxSize,size);
44            }
45        }
46        return maxSize;
47    }
48}