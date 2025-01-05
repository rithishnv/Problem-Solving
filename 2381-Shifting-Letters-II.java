class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        int[] arr=new int[n];
            for(int[] i:shifts){
             int d=(i[2]==1)?1:-1;
             arr[i[0]]+=d;
             if(i[1]+1<n)
             arr[i[1]+1]-=d;
            }
        for(int i=1;i<n;i++){
            arr[i]+=arr[i-1];
        }
        for(int i=0;i<n;i++){
            int c=((s.charAt(i)-'a')+arr[i])%26;
            if(c<0)
            c+=26;
            sb.append((char)(c+'a'));
        }
        return sb.toString();
    }
}