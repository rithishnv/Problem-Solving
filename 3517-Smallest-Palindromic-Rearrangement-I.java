class Solution {
    public String smallestPalindrome(String s) {
        int[] arr=new int[26];
        for(char i:s.toCharArray()){
            arr[i-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        StringBuilder bt=new StringBuilder();
        char a='a';
        for(int i=0;i<26;i++){
            if(arr[i]%2!=0){
                bt.append(a);
                arr[i]--;
            }
            a++;
        }
        a='a';
        for(int i=0;i<26;i++){
            for(int j=0;j<arr[i]/2;j++){
                sb.append(a);
            }
            a++;
        }
        a--;
        sb.append(bt);
        for(int i=25;i>-1;i--){
            for(int j=0;j<arr[i]/2;j++){
                sb.append(a);
            }
            a--;
        }
        return sb.toString();
    }
}