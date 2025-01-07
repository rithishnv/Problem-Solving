class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }
        int t=0;
        for(int i=0;i<nums1.length;i++){
            t=nums1[i];
            nums1[i]=-1;
            for(int j=map.get(t)+1;j<nums2.length;j++){
                if(t<nums2[j]){
                    nums1[i]=nums2[j];
                    break;
                }
            }
        }
        return nums1;
    }
}