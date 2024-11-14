class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Arrays.sort(logs,(a,b) ->Integer.compare(a[0],b[0]));
        int[] arr=new int[k];
        for(int i=0;i<logs.length;i++){
            int ka=logs[i][0];
            Set<Integer> set=new HashSet<>();
            while(i<logs.length && logs[i][0]==ka){
                set.add(logs[i++][1]);
            }
            i--;
            arr[set.size()-1]++;
        }
        return arr;
    }
}