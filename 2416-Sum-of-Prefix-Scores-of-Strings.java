class trieNode{
    trieNode[] arr=new trieNode[26];
    int val=0;
}
class Solution {
    public int[] sumPrefixScores(String[] words) {
        int[] r=new int[words.length];
        trieNode root=new trieNode();
        for(String s:words){
            trieNode node=root;
            for(char i:s.toCharArray()){
            if(node.arr[i-'a']==null){
                node.arr[i-'a']=new trieNode();
            }
            node=node.arr[i-'a'];
            node.val++;
          }
        }
        for(int i=0;i<words.length;i++){
            int c=0;
            trieNode node=root;
            for(char j:words[i].toCharArray()){
                node=node.arr[j-'a'];
                c+=node.val;
            }
            r[i]=c;
        }
        return r;
    }
}