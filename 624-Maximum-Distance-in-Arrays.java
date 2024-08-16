class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int a=0;
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> li= arrays.get(i);
            int m = li.get(0);
            int m1 = li.get(li.size() - 1);
            a=Math.max(a,max-m);
            a=Math.max(a,(m1-min));
            min=Math.min(min,m);
            max=Math.max(max,m1);
           
        }
        return a;
    }
}