class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String,Integer> map=new HashMap<>();
        int res=0;
        for(int[] i:dominoes){
            Arrays.sort(i);
            String s=Arrays.toString(i);
            map.put(s,map.getOrDefault(s,0)+1);
        }
         for(int[] i:dominoes){
            String s=Arrays.toString(i);
            res+=map.get(s)-1;
            map.put(s,map.get(s)-1);
        }
        return res;
    }
}