class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> set=new HashSet<>();
        Set<Integer> prev=new HashSet<>();
        for(int i:arr){
            Set<Integer> cur=new HashSet<Integer>();
            cur.add(i);
            for(int j:prev){
                cur.add(j|i);
            }
            // System.out.println(cur);
            set.addAll(cur);
            prev=cur;
        }
        return set.size();
    }
}