class Solution {
    boolean isVowel(char s){
        return s=='a' || s=='e' || s=='i' ||s=='o' ||s=='u';
    }
    public int maxVowels(String s, int k) {
        int max=0,cnt=0;
        for(int i=0;i<s.length();i++){
            if(isVowel(s.charAt(i)))
                cnt++;
            if(i>=k&&isVowel(s.charAt(i-k)))
                cnt--;
            max=Math.max(max,cnt);
        }
        return max;
    }
}