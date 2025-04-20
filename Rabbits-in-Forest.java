class Solution {
    public int numRabbits(int[] answers) {
        int[] arr=new int[1001];
        for(int i:answers)
        arr[i]++;
        int res=0;
        for(int i=0;i<1001;i++){
            res+=((arr[i]+i)/(i+1))*(i+1);
        }
        return res;
    }
}