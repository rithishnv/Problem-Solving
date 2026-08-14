class Solution {
    public int maximumLengthSubstring(String s) {
         Map<Character,Integer> map=new HashMap<>();
        int res=0;
        int i=0;
        int n=s.length();
        for(int j=0;j<n;j++){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            while(map.get(s.charAt(j))>2){
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)-1);
                i++;
            }
            res=Math.max(res,j-i+1);
        }
        return res;
    }
}