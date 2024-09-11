class Solution {
    public int minOperations(int n) {
        int sum=0,c=0;
        for(int i=0;i<n;i++){
            sum+=(2*i)+1;
        }
        sum/=n;
        for(int i=0;i<n;i++){
            if((2*i)+1!=sum)
            c+=Math.abs(((2*i)+1)-sum);
        }
        return c/2;
    }
}