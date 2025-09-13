class Solution {
    public int maxFreqSum(String s) {
        int[] arr=new int[26];
        int v=0,c=0;
        for(char i:s.toCharArray()){
            arr[i-'a']++;
            if(isVowel(i)){
            v=Math.max(v,arr[i-'a']);
            }
            else
            c=Math.max(c,arr[i-'a']);
        }
        return c+v;
    }
    public boolean isVowel(char a){
        if(a=='a' || a=='e' || a=='i' || a=='o' || a=='u')
        return true;
        return false;
    }
}