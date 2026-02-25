1class Solution {
2    public int[] sortByBits(int[] arr) {
3        Arrays.sort(arr);
4        Map<Integer,List<Integer>> map=new HashMap<>();
5        for(int i:arr){
6            int t=Integer.bitCount(i);
7            if(!map.containsKey(t)){
8                map.put(t,new ArrayList<Integer>());
9            }
10            List<Integer> a=map.get(t);
11            a.add(i);
12            map.put(t,a);
13        }
14        int k=0;
15        for(int i:map.keySet()){
16            for(int j:map.get(i)){
17                arr[k++]=j;
18            }
19        }
20        return arr;
21    }
22}