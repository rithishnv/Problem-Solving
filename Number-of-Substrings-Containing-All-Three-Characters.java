class Solution {
    public int numberOfSubstrings(String s) {
        int res=0,i=0,j=0,c=0;
        int[] arr=new int[3];
        while(i<s.length()){
            if(arr[s.charAt(i)-'a']++==0)
            c++;
            while(c>=3){
                res+=s.length()-i;
                if(--arr[s.charAt(j)-'a']==0)
                c--;
                j++;
            }
            i++;
        }
        return res;
    }
}