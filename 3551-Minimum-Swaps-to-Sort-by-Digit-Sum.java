class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        List<int[]> arr = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            int sum = 0;
            int f = nums[i];
            while(f > 0){
                sum += f % 10;
                f = f/10;
            }
            arr.add(new int[]{sum,nums[i]});
            map.put(nums[i],i);
        }
        int cnt = 0;
        Collections.sort(arr,(a,b) -> a[0] == b[0]? a[1] - b[1]: a[0] - b[0]);
        for(int i = 0;i<n;i++){
            int[] val = arr.get(i);
            if(val[1] == nums[i]) continue;
            int idx = map.get(val[1]);
            nums[idx] = nums[i];
            map.put(nums[i],idx);
            cnt++;
        }
        return cnt;

        
    }
}