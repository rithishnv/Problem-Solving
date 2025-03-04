class Solution {
    public int lengthOfLIS(int[] arr) {
        List<Integer> li=new ArrayList<>();
        li.add(arr[0]);
        int l=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>li.get(li.size()-1)){
                li.add(arr[i]);
                l++;
            }
            else{
                int ind=Collections.binarySearch(li,arr[i]);
                if(ind<0)
                ind=-ind-1;
                li.set(ind,arr[i]);
            }
        }
        return l;
    }
}