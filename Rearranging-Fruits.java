class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer,Integer> map=new HashMap<>();
        Map<Integer,Integer> map1=new HashMap<>();
        for(int i:basket1)
        map.put(i,map.getOrDefault(i,0)+1);
        for(int i:basket2)
        map1.put(i,map1.getOrDefault(i,0)+1);
        Set<Integer> set=new HashSet<>(map.keySet());
        set.addAll(map1.keySet());
        int min=Integer.MAX_VALUE;
        List<Integer> li=new ArrayList<>();
        List<Integer> li1=new ArrayList<>();
        for(int i:set){
            min=Math.min(i,min);
            int dif=map.getOrDefault(i,0)-map1.getOrDefault(i,0);
            if(dif%2!=0)
            return -1;
            if(dif>0){
                for(int j=0;j<dif/2;j++)
                li.add(i);
            }
            else if(dif<0){
                for(int j=0;j<-dif/2;j++)
                li1.add(i);
            }
        }
        long res=0;
        Collections.sort(li);
        Collections.sort(li1,Collections.reverseOrder());
        for(int i=0;i<li.size();i++)
        res+=Math.min(Math.min(li.get(i),li1.get(i)),2L*min);
        return res;
    }
}