class Solution {
    int[] arr;
    int check(int[] arr){
       int cnt=0;
        for(int i=0;i<26;i++){
            if(arr[i]==0)
            continue;
            arr[i]--;
            cnt++;
            cnt+=check(arr);
            arr[i]++;
        }
        return cnt;
    }
    public int numTilePossibilities(String tiles) {
        arr=new int[26];
        for(char i:tiles.toCharArray())
        arr[i-'A']++;
        return check(arr);
    }
}