class Solution {
    public String customSortString(String order, String s) {
        int[] arr=new int[26];
        PriorityQueue<int[]> q=new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int j=0;
        for(char i:order.toCharArray()){
            q.add(new int[]{j++,i-'a'});
        }
        StringBuilder sb=new StringBuilder();
        for(char i:s.toCharArray())
        arr[i-'a']++;
        while(!q.isEmpty()){
            j=q.poll()[1];
            while(arr[j]-->0){
                sb.append((char)(j+'a'));
            }
        }
        for(int i=0;i<26;i++){
            while(arr[i]-->0){
                sb.append((char)(i+'a'));
            }
        }
        return sb.toString();
    }
}