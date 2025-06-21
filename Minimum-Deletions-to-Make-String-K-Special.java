class Solution {
    public int minimumDeletions(String word, int k) {
        int[] arr=new int[26];
        for(char i:word.toCharArray()){
            arr[i-'a']++;
        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(arr[i]==0)
            continue;
            int temp=0;
            for(int j=0;j<26;j++){
                if(arr[j]<arr[i])
                temp+=arr[j];
                else if(arr[j]>arr[i]+k)
                temp+=(arr[j]-arr[i]-k);
                
            }
            res=Math.min(res,temp);
        }
        return res;
    }
}