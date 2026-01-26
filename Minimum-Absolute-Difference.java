1class Solution {
2    public List<List<Integer>> minimumAbsDifference(int[] arr) {
3        List<List<Integer>> li=new ArrayList<>();
4        int min=Integer.MAX_VALUE;
5        Arrays.sort(arr);
6        for(int i=1;i<arr.length;i++){
7            min=Math.min(min,(arr[i]-arr[i-1]));
8        }
9        for(int i=1;i<arr.length;i++){
10            if(arr[i]-arr[i-1]==min){
11                List<Integer> li1=new ArrayList<Integer>();
12                li1.add(arr[i-1]);
13                li1.add(arr[i]);
14                li.add(li1);
15            }
16        }
17        return li;
18    }
19}