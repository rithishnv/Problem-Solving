class Solution {
    public char kthCharacter(long k, int[] operations) {
        int shift=0;
        List<Long> li=new ArrayList<>();
        long len=1;
        for(int i:operations){
            len*=2;
            li.add(len);
            if(len>=k)
            break;
        }
        for(int i=li.size()-1;i>-1;i--){
            long m=li.get(i)/2;
            if(k>m){
                k-=m;
                if(operations[i]==1)
                shift++;
            }
        }
        return (char)(((shift)%26)+'a');
    }
}