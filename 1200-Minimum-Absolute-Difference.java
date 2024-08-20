class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> li=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i=1;i<arr.length;i++){
            min=Math.min(min,(arr[i]-arr[i-1]));
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]==min){
                List<Integer> li1=new ArrayList<Integer>();
                li1.add(arr[i-1]);
                li1.add(arr[i]);
                li.add(li1);
            }
        }
        return li;
    }
}