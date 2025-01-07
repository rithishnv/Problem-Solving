class Solution {
    public void per(int[] nums, boolean[] arr, List<Integer> l, List<List<Integer>> li) {
        if (l.size() == nums.length) {
            li.add(new ArrayList<Integer>(l));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (arr[j])
                continue;
            arr[j] = true;
            l.add(nums[j]);
            per(nums, arr, l, li);
            l.remove(l.size() - 1);
            arr[j] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> li = new ArrayList<>();
        boolean[] arr = new boolean[nums.length];
        List<Integer> l = new ArrayList<>();
        per(nums, arr, l, li);
        return li;
    }
}