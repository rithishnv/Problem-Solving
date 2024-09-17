class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] a=s1.split(" ");
        String[] b=s2.split(" ");
        HashMap<String,Integer> m=new HashMap<>();
        for(String i:a)
        m.put(i,m.getOrDefault(i,0)+1);
         for(String i:b)
        m.put(i,m.getOrDefault(i,0)+1);
        List<String> li=new ArrayList<>();
        for(Map.Entry<String,Integer> e:m.entrySet()){
            if(e.getValue()==1)
            li.add(e.getKey());
        }
        return li.toArray(new String[li.size()]);
    }
}