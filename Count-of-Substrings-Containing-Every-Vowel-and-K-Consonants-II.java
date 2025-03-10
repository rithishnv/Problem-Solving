class Solution {
    public boolean isVowel(char s){
        if(s=='a' ||s=='e' ||s=='i' ||s=='o' ||s=='u')
        return true;
        return false;
    }
    public long countOfSubstrings(String word, int k) {
        return window(word,k)-window(word,k+1);
    }
    public long window(String s,int k){
        Map<Character,Integer> map=new HashMap<>();
        long res=0;
        int n=s.length(),i=0,j=0,c=0;
        while(i<n){
            if(isVowel(s.charAt(i))){
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            }
            else
            c++;
            while(map.size()==5 && c>=k){
                res+=n-i;
                if(isVowel(s.charAt(j))){
                    map.put(s.charAt(j),map.get(s.charAt(j))-1);
                    if(map.get(s.charAt(j))==0)
                    map.remove(s.charAt(j));
                }
                else
                c--;
                j++;
            }
            i++;
        }
        return res;
    }
}