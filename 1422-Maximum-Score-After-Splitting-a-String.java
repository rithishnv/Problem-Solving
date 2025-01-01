class Solution {
    public int maxScore(String s) {
        int n=s.length();
        int[] z=new int[n];
        int[] o=new int[n];
        if(s.charAt(0)=='0')
        z[0]++;
        else
        o[0]++;
        for(int i=1;i<n;i++){
            if(s.charAt(i)=='0')
            z[i]++;
            if(s.charAt(i)=='1')
            o[i]++;
            z[i]+=z[i-1];
            o[i]+=o[i-1];
        }
        int sum=0;
        for(int i=0;i<n-1;i++){
            sum=Math.max(sum,z[i]+(o[n-1]-o[i]));
        }
        return sum;
    }
}