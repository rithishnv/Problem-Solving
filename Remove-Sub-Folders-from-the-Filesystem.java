class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> set=new HashSet<>();
        List<String> res=new ArrayList<>();
        for(String i:folder)
        set.add(i);
        for(String i:set){
            res.add(i);
            for(int j=0;j<i.length();j++){
                if(i.charAt(j)=='/' && set.contains(i.substring(0,j))){
                    res.remove(res.size()-1);
                    break;
                }
            }
        }
        return res;
    }
}