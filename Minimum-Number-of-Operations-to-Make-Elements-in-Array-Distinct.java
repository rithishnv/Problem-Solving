class Solution {
    public boolean check(int[] arr){
        for(int i:arr){
            if(i>1)
            return false;
        }
        return true;
    }
    public int minimumOperations(int[] nums) {
        int e=0;
        for(int i:nums){
            e=Math.max(e,i);
        }
        int[] arr=new int[e+1];
        for(int i:nums){
            arr[i]++;
        }
        if(check(arr))
        return 0;
        int t=0,n=nums.length;
        for(int i=0;i<=nums.length-2;i+=3){
            if(check(arr))
            return t;
            arr[nums[i]]--;
            if(i+1<n)
            arr[nums[i+1]]--;
            if(i+2<n)
            arr[nums[i+2]]--;
            t++;
        }
        return t;
    }
}