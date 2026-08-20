import java.util.Arrays;
class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        List<Integer> li=new ArrayList<>();
        List<Integer> li1=new ArrayList<>();
        int j=0;
        li.add(nums[0]);
        li1.add(nums[1]);
        for(int i=2;i<n;i++){
            if(li.get(li.size()-1)>li1.get(li1.size()-1)){
            li.add(nums[i]);
            }
            else{
            li1.add(nums[i]);
            }
        }
        for(Integer i:li){
            nums[j++]=i;
        }
        for(Integer i:li1){
            nums[j++]=i;
        }
        return nums;
    }
}