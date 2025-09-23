class Solution {
    public int compareVersion(String version1, String version2) {
        int res=0;
        String[] arr=version1.split("\\.");
        String[] arr1=version2.split("\\.");
        int i=0,j=0;
        while(i<arr.length && j<arr1.length){
            int n1=Integer.valueOf(arr[i++]);
            int n2=Integer.valueOf(arr1[j++]);
            if(n1==n2)
            continue;
            else if(n1<n2){
            return -1;
            }
            else{
            return 1;
            }
        }
        while(i<arr.length){
            int n1=Integer.valueOf(arr[i++]);
            if(n1>0)
            return 1;
        }
        while(j<arr1.length){
            int n1=Integer.valueOf(arr1[j++]);
            if(n1>0)
            return -1;
        }
        return 0;
    }
}