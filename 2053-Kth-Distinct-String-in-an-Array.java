class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String,Integer> s=new LinkedHashMap<>();
       for(String i:arr)
       s.put(i,s.getOrDefault(i,0)+1);
       int c=0;
       for(Map.Entry<String,Integer> j:s.entrySet()){
        if(j.getValue()==1)
         c++;
         if(c==k)
         return j.getKey();
       }
        return "";
    }
}