class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String,Integer> map=new HashMap<>();
        int res=0;
        for(int[] i:dominoes){
            Arrays.sort(i);
            String s=Arrays.toString(i);
            int t=map.getOrDefault(s,0);
            res+=t;
            map.put(s,map.getOrDefault(s,0)+1);
        }
        return res;
    }
}