class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer,Integer> map=new TreeMap<>();
        for(int[] i:nums1){
            map.put(i[0],map.getOrDefault(i[0],0)+i[1]);
        }
         for(int[] i:nums2){
            map.put(i[0],map.getOrDefault(i[0],0)+i[1]);
        }
        int[][] a=new int[map.size()][2];
        int j=0;
        for(int i:map.keySet()){
            a[j][0]=i;
            a[j++][1]=map.get(i);
        }
        return a;
    }
}