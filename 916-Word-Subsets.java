class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> li=new ArrayList<>();
        int[] b=new int[26];
        for(String i:words2){
            int[] a=new int[26];
            for(char j:i.toCharArray()){
                a[j-'a']++;
                b[j-'a']=Math.max(b[j-'a'],a[j-'a']);
            }
        }
        for(String i:words1){
            int[] o=new int[26];
            boolean g=true;
            for(char j:i.toCharArray()){
                o[j-'a']++;
            }
            for(int k=0;k<26;k++){
                if(b[k]!=0 && b[k]>o[k]){
                    g=false;
                    break;
                }
            }
            if(g)
            li.add(i);
        }
        return li;
    }
}