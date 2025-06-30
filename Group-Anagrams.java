class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            char[] arr=new char[30];
            for(char c:s.toCharArray()){
                arr[c-'a']++;
            }
            String k=String.valueOf(arr);
            // System.out.println(k);
            List<String> li=map.getOrDefault(k,new ArrayList<String>());
            li.add(s);
            map.put(k,li);
        }
        List<List<String>> res=new ArrayList<>();
        for(String i:map.keySet()){
            res.add(map.get(i));
        }
        return res;
    }
}