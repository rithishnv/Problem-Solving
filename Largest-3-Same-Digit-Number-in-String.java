class Solution {
    public String largestGoodInteger(String num) {
        int n=num.length();
        if(n<3)
        return "";
        int[] arr=new int[10];
        int max=-1;
        for(int i=0;i<3;i++){
            int ind=num.charAt(i)-'0';
            arr[ind]++;
            if(arr[ind]==3)
            max=Math.max(max,ind);
        }
        int i=0;
        for(int j=3;j<n;j++){
            arr[num.charAt(i)-'0']--;
            if(++arr[num.charAt(j)-'0']==3){
                max=Math.max(max,num.charAt(j)-'0');
            }
            i++;
        }
        return (max==-1)?"":String.valueOf(max)+max+max;

    }
}