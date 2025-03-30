class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] arr=new int[26];
        List<Integer> li=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']=i;
        }
        int i=0,j=arr[s.charAt(i)-'a'];
        int n=s.length();
        while(i!=n && j!=n){
            int t=i;
            while(i!=n && j!=n && i<=j){
                int ind=s.charAt(i)-'a';
                if(arr[ind]>j){
                    j=arr[ind];
                }
                i++;
            }
            li.add(j-t+1);
            if(i!=n)
            j=arr[s.charAt(i)-'a'];
        }
        return li;
    }
}