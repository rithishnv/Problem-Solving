class Solution {
    public int minChanges(String s) {
        int o=0;
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length-1;i+=2){
            if(arr[i]!=arr[i+1])
            o++;
        }
       return o;
    }
}