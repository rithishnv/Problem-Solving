class Solution {
    public int maxDistance(String s, int k) {
        int[] arr=new int[4];
        int res=0,tmp=0;
        int j=0;
        for(char i:s.toCharArray()){
            if(i=='N')
            arr[0]++;
            else if(i=='S')
            arr[1]++;
            else if(i=='W')
            arr[2]++;
            else
            arr[3]++;
            tmp=Math.min(j+1,Math.abs(arr[0]-arr[1])+Math.abs(arr[2]-arr[3])+2*k);
            res=Math.max(res,tmp);
            j++;
        }
        return res;
    }
}