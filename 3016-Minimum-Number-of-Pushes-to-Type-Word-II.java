class Solution {
    public int minimumPushes(String word) {
        int[] a=new int[26];
            for(char j:word.toCharArray()){
                a[j-'a']++;
            }
        Arrays.sort(a);
        int t=0,s=0,k=1;
        for(int i=a.length-1;i>=0;i--){
            if(a[i]!=0){
                t++;
                s+=(a[i]*k);
            }
            if(t%8==0){
                k++;
                t=0;
            }
        }
        return s;
    }
}