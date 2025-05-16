class Solution {
    public boolean check(String a,String b){
        if(a.length()!=b.length())
        return false;
        int d=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i))
            d++;
        }
        return d==1;
    }
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n=words.length;
        int[] dp=new int[n];
        int[] parent=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(parent,-1);
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(groups[i]!=groups[j] && check(words[i],words[j]) && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    parent[i]=j;
                }
            }
            max=Math.max(dp[i],max);
        }
        List<String> li=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(dp[i]==max){
                while(i!=-1){
                li.add(words[i]);
                i=parent[i];
                }
                break;
            }
        }
        Collections.reverse(li);
        return li;
     }
}