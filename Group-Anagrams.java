class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new TreeMap<>();
        for(String s:strs){
            char[] arr=s.toCharArray();
            Arrays.sort(arr);
            String k=String.valueOf(arr);
            List<String> li=map.getOrDefault(k,new ArrayList<String>());
            li.add(s);
            map.put(k,li);
        }
        List<List<String>> res=new ArrayList<>();
        // for(String i:map.keySet()){
        //     res.add(map.get(i));
        // }
        return new ArrayList(map.values());
    }
}