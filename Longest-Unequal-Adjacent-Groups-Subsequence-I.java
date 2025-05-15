class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> res=new ArrayList<>();
        int f=(groups[0]==1)?0:1;
        for(int i=0;i<words.length;i++){
            if(groups[i]!=f){
                res.add(words[i]);
                f=(f==0)?1:0;
            }
        }
        return res;
    }
}