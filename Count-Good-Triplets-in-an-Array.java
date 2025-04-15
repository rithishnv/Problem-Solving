class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> li=new ArrayList<>();
        int j=0;
        for(int i:nums1)
        map.put(i,j++);
        long res=0;
        int n=nums2.length;
        for(int i:nums2){
            int ind=map.get(i);
            int left=orderOfKey(li,ind);
            int right=(n-1-ind)-(li.size()-left);
            res+=(long)left*right;
            int pos=orderOfKey(li,ind);
            li.add(pos,ind);
        }
        return res;
    }
    public int orderOfKey(List<Integer> li,int ind){
        int pos=Collections.binarySearch(li,ind);
        return (pos<0)?-pos-1:pos;
    }
}